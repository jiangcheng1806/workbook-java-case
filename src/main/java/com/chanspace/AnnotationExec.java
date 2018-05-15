package com.chanspace;

@MyAnnotation
public class AnnotationExec {

	public static void main(String[] args) {
		
		System.runFinalizersOnExit(true);//这是一个过时了的方法 ,如果没有注解就会有警告提示  
		
		//判断此类是否有MyAnnotation注解
		if(AnnotationExec.class.isAnnotationPresent(MyAnnotation.class)) {
			 //如果有，则获取该注解
			MyAnnotation annotation = AnnotationExec.class.getAnnotation(MyAnnotation.class);
			
			System.out.println(annotation);
		}
		
		
		
		System.out.println("Hello World!");
	}
}
