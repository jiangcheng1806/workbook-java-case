package com.jiangcheng.theory.designpattern.factory.multifactory;

import com.jiangcheng.theory.designpattern.commonfactory.MailSender;
import com.jiangcheng.theory.designpattern.commonfactory.Sender;
import com.jiangcheng.theory.designpattern.commonfactory.SmsSender;

/**
 * 
 * 对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 * 
 * 
 * @author Chan Kiang
 *
 */
public class SendFactory {

	public Sender produceMail(){
		return new MailSender();
	}
	
	public Sender produceSms(){
		return new SmsSender();
	}
}
