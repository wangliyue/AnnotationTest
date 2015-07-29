package com.lingtong.test;

import java.util.List;

import com.lingtong.annotation.UserCase;

public class PasswordUtils {
   @UserCase(description="����������ٰ���һ������", id = 47)
   public boolean validatePassword(String password){
	     return (password.matches("\\w*\\d\\w*"));
   }
   @UserCase(id=48)
   public String encryptPassword(String password){
	   return new StringBuilder(password).reverse().toString();
   }
   @UserCase(id=49,description="�����벻�ܺ;�������ͬ")
   public  boolean  checkForNewPassword(List<String> prevPasswords,String password){
	   return !prevPasswords.contains(password);
   }
}
