package com.jiangcheng.theory.designpattern.proxy.daoproxy;

/**
 * 类名称：ProxyFactory<br>
 * 类描述：<br>
 * 创建时间：2018年08月27日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class ProxyFactory {

    private Object target; // 维护一个目标对象

    public ProxyFactory(Object target){
        this.target = target;
    }
}
