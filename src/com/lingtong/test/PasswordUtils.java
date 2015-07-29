package com.lingtong.test;

import java.util.List;

import com.lingtong.annotation.UserCase;

public class PasswordUtils {
   @UserCase(description="密码必须至少包含一个数字", id = 47)
   public boolean validatePassword(String password){
	     return (password.matches("\\w*\\d\\w*"));
   }
   @UserCase(id=48)
   public String encryptPassword(String password){
	   return new StringBuilder(password).reverse().toString();
   }
   @UserCase(id=49,description="新密码不能和旧密码相同")
   public  boolean  checkForNewPassword(List<String> prevPasswords,String password){
	   return !prevPasswords.contains(password);
   }
}
