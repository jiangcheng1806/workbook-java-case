package com.jiangcheng.theory.designpattern.factory.staticfactory;

import com.jiangcheng.theory.designpattern.factory.commonfactory.Sender;

public class FactoryTest {

	public static void main(String[] args) {
		//SendFactory factory = new SendFactory();
		//Sender mailSender = factory.produceMail();
		Sender mailSender = SendFactory.produceMail();
		mailSender.send();
	}
}
