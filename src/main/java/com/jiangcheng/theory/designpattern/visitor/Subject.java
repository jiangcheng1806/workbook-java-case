package com.jiangcheng.theory.designpattern.visitor;

public interface Subject {

	public void accept(Visitor visitor);
	
	public String getSubject();
	
}
