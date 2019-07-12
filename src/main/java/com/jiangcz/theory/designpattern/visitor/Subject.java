package com.jiangcz.theory.designpattern.visitor;

public interface Subject {

	public void accept(Visitor visitor);
	
	public String getSubject();
	
}
