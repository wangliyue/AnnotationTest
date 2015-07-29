package com.lingtong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constraints {               //Ô¼Êø×¢½â

   public  boolean primaryKey() default false;
   
   public  boolean allowNull() default true;
   
   public  boolean unique()  default false;
}
