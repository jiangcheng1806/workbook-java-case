package com.jiangcheng.theory.designpattern.proxy.daoproxy;

import com.jiangcheng.bean.User;
import com.jiangcheng.dao.UserDAO;

/**
 * 类名称：UserDaoProxy<br>
 * 类描述：<br>
 * 创建时间：2018年08月27日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class UserDaoProxy implements UserDAO {

    private UserDAO target;

    public UserDaoProxy(UserDAO target){
        this.target = target;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
