package com.jiangcz.controller;

import com.jiangcz.bean.User;
import com.jiangcz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 类名称：UserController<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Controller
public class UserController {

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
}
