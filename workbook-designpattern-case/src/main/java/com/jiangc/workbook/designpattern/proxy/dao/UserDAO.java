package com.jiangc.workbook.designpattern.proxy.dao;

import com.jiangc.workbook.designpattern.proxy.bean.User;

/**
 * 类名称：UserDAO<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public interface UserDAO {
    User getUserById(int id);

    public void save();
}
