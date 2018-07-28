package com.jiangcheng.theory.designpattern.bridge;

public class MyBridge extends Bridge {

	@Override
    public void method(){
		getSource().method();
	}
}
