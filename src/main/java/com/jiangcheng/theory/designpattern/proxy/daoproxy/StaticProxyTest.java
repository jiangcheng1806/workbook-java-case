package com.jiangcheng.theory.designpattern.proxy.daoproxy;

import com.jiangcheng.dao.UserDAO;
import com.jiangcheng.dao.impl.UserDAOImpl;
import org.junit.Test;

/**
 * 类名称：StaticProxyTest<br>
 * 类描述：<br>
 * 创建时间：2018年08月27日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class StaticProxyTest {
    @Test
    public void testStaticProxy(){
        //目标对象
        UserDAO target = new UserDAOImpl();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
