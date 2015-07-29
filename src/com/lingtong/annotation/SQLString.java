package com.lingtong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLString {
   
	public int value() default 0;              //表示大小  默认varchar(0)
	
	public String name() default "";
	
	public Constraints constraints() default @Constraints;
	
}
