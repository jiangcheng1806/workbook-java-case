package com.jiangcheng.theory.designpattern.factory.abstractfactory;

public class SendSmsFactory implements Provider {

	@Override
    public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
