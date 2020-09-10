package com.jiangc.workbook.designpattern.factory.multifactory_level2;

import com.jiangc.workbook.designpattern.factory.commonfactory_level1.Sender;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produceMail();
		sender.send();
	}
}
