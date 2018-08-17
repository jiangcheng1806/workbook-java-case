package com.jiangcheng.theory.designpattern.factory.multifactory;

import com.jiangcheng.theory.designpattern.commonfactory.Sender;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
}
