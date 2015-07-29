package com.lingtong.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lingtong.annotation.UserCase;

/**
 * UserCase的注解处理器
 * @author wly
 *
 */
public class UseCaseTracker {
     
	public static void  trackUserCases(List<Integer> useCases,Class<?> cl){
		for(Method m :cl.getDeclaredMethods()){
			UserCase uc = m.getAnnotation(UserCase.class);
			if(uc != null){
				System.out.println("Found Use Case:"+uc.id()+" " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i :useCases){
			System.out.println("Warning:Missing user case-"+i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases,47,48,49,50);
		trackUserCases(useCases, PasswordUtils.class);
	}
}
