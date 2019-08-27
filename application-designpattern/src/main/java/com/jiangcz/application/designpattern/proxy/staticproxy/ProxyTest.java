package com.jiangcz.application.designpattern.proxy.staticproxy;

public class ProxyTest {


	public static void main(String[] args) {
		
		Sourceable source = new Proxy();
		
		source.method();
	}
}
