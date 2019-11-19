package com.jiangcz.application.spring.controller;

import com.google.common.base.Objects;
import com.jiangcz.application.spring.bean.User;
import com.jiangcz.application.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.JedisCommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("userService")//需要配合在service注解处标上名称
    private UserService userService;

    //开启注解取消xml
    /*public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public User getUserById(int id){
        return userService.getUserById(id);
    }

    /**
     * 可用
     * @param lockKey
     * @return
     */
    private Boolean setLock0(String lockKey){
        Object nx = redisTemplate.execute((RedisCallback<String>) connection -> {
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            return commands.set(lockKey, "true", "NX", "PX", 6000);
        });
        log.debug("并发锁存的值：{}", nx);
        if (!Objects.equal(nx, "OK")) {
            log.info("并发的重复请求，过滤掉了:{}-并发锁已经存在",lockKey);
           return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 不可用
     * 当setIfAbsent成功之后断开连接，下面设置过期时间的代码 stringRedisTemplate.expire(key,timeout); 是无法执行的，这时候就会有大量没有过期时间的数据存在数据库。
     * @param lockKey
     * @return
     */
    private Boolean setLock1(String lockKey){
        if (redisTemplate.opsForValue().setIfAbsent(lockKey,"true")){
            redisTemplate.boundValueOps(lockKey).expire(6,TimeUnit.SECONDS);
            return Boolean.FALSE;
        } else {
            log.debug("提交间隔时间过短  {}",lockKey);
            return Boolean.FALSE;
        }
    }

    /**
     * 不可用
     * 加了事务管理之后，setIfAbsent的返回值竟然是null，这样就没办根据返回值判断是否执行此后的添加过期时间饿操作了
     * @param lockKey
     * @return
     */
    private Boolean setLock2(String lockKey){
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        if (redisTemplate.opsForValue().setIfAbsent(lockKey,"true")){
            redisTemplate.boundValueOps(lockKey).expire(6,TimeUnit.SECONDS);
            stringRedisTemplate.exec();
        } else {
            log.debug("提交间隔时间过短  {}",lockKey);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * 不可用
     * 当出现并发时，String result = stringRedisTemplate.opsForValue().get(key); 这里就会有多个线程同时拿到为空的key，然后同时写入脏数据。
     * @param lockKey
     * @return
     */
    private Boolean setLock3(String lockKey){
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey,"true");
        if (result == null){
            redisTemplate.boundValueOps(lockKey).expire(6,TimeUnit.SECONDS);
            stringRedisTemplate.exec();
        } else {
            log.debug("提交间隔时间过短  {}",lockKey);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 可用
     * 使用stringRedisTemplate.exec();的返回值判断setIfAbsent是否成功
     * @param lockKey
     * @return
     */
    private Boolean setLock4(String lockKey){
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.opsForValue().setIfAbsent(lockKey,"true");
        redisTemplate.expire(lockKey,6,TimeUnit.SECONDS);
        List result = redisTemplate.exec();//// 这里result会返回事务内每一个操作的结果，如果setIfAbsent操作失败后，result[0]会为false。
        if (true == (Boolean) result.get(0)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 可用 升级redis 直接在setIfAbsent中设置过期时间
     * @param lockKey
     * @return
     */
    private Boolean setLock5(String lockKey){
        if ( redisTemplate.opsForValue().setIfAbsent(lockKey,"true",6,TimeUnit.SECONDS)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * java 使用redis的事务时不能直接用Api中的multi()和exec()，这样multi()和exec()两次使用的stringRedisTemplate不是一个connect，会导致死锁 解决方案
     * @param lockKey
     * @return
     */
    private Boolean setLock6(String lockKey) {
        //String lockKey = event.getModel() + ":" + event.getAction() + ":" + event.getId() + ":" + event.getMessage_id();
        log.info("lockKey : {}" , lockKey);
        // 使用sessionCallBack处理
        SessionCallback<Boolean> sessionCallback = new SessionCallback<Boolean>() {
            List<Object> exec = null;
            @Override
            @SuppressWarnings("unchecked")
            public Boolean execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                stringRedisTemplate.opsForValue().setIfAbsent(lockKey,"true");
                stringRedisTemplate.expire(lockKey,6, TimeUnit.SECONDS);
                exec = operations.exec();
                if(exec.size() > 0) {
                    return (Boolean) exec.get(0);
                }
                return false;
            }
        };
        return stringRedisTemplate.execute(sessionCallback);
    }
}
