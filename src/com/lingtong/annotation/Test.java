package com.lingtong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)              //��ע��������ʱ������
@Target(ElementType.METHOD)                      //��ע�������ڷ�����
public @interface Test {
	                       //û���κ�Ԫ�ص�ע���Ϊ���ע��
}
