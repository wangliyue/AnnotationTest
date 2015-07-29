package com.lingtong.test;

import com.lingtong.annotation.Test;

public class Testable {
    
	public void execute(){
		System.out.println("I am execute....");
	}
	
	@Test
	public void testExecute(){
		execute();
	}
}
