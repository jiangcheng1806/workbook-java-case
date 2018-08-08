package com.jiangcheng.service.impl;

import com.jiangcheng.bean.User;
import com.jiangcheng.dao.UserDAO;
import com.jiangcheng.service.UserService;
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
