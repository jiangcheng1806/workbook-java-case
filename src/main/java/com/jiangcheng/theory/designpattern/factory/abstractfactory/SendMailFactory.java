package com.jiangcheng.theory.designpattern.factory.abstractfactory;

public class SendMailFactory implements Provider {

	@Override
    public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
