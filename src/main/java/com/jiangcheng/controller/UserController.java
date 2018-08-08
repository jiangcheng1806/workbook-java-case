package com.jiangcheng.controller;

import com.jiangcheng.bean.User;
import com.jiangcheng.service.UserService;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUserById(int id){
        return userService.getUserById(id);
    }
}
