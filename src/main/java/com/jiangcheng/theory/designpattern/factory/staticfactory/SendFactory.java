package com.jiangcheng.theory.designpattern.factory.staticfactory;

import com.jiangcheng.theory.designpattern.commonfactory.MailSender;
import com.jiangcheng.theory.designpattern.commonfactory.Sender;
import com.jiangcheng.theory.designpattern.commonfactory.SmsSender;

/**
 * 静态工厂模式就是在多个工厂方法模式的基础上进行静态化从而使使用工厂模式的时候不需要手动创建工厂了
 * @author Chan Kiang
 *
 */
public class SendFactory {

	public static Sender produceMail(){
		return new MailSender();
	}
	
	public static Sender produceSms(){
		return new SmsSender();
	}
}
