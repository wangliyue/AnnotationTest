package com.lingtong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)              //该注解在运行时起作用
@Target(ElementType.METHOD)                      //该注解作用在方法上
public @interface Test {
	                       //没有任何元素的注解称为标记注解
}
