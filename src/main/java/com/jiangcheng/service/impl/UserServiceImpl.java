package com.jiangcheng.service.impl;

import com.jiangcheng.bean.User;
import com.jiangcheng.dao.UserDAO;
import com.jiangcheng.service.UserService;

/**
 * 类名称：UserServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
