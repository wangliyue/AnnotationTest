package com.lingtong.test;

import org.junit.Test;


public class AtUnitExample1 {
    
	public String methodOne(){
		return  "This is MethodOne";
	}
	
	public  int methodTwo(){
		System.out.println("This is MethodTwo");
		return 2;
	}
	
	@Test
	public  void methodOneTest(){
		 methodOne().equals("This is MethodOne");
	}
	
	@Test
	public boolean  m2(){
		return methodTwo() == 2;
	}
	
	@Test
	public boolean m3(){
		return true;
	}
	
	@Test
	public boolean failureTest(){
		return false;
	}
	
	@Test
	public boolean  anotherDisappointment(){
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   

	}

}
