package com.jiangcz.service.impl;

import com.jiangcz.bean.User;
import com.jiangcz.dao.UserDAO;
import com.jiangcz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名称：UserServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    //开启注解取消xml
    /*public UserDAO getUserDAO(){
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }*/

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
