package com.jiangc.workbook.designpattern.proxy.staticproxy;

public class ProxyTest {


	public static void main(String[] args) {
		
		Sourceable source = new Proxy();
		
		source.method();
	}
}
