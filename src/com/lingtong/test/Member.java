package com.lingtong.test;

import com.lingtong.annotation.Constraints;
import com.lingtong.annotation.DBTable;
import com.lingtong.annotation.SQLInteger;
import com.lingtong.annotation.SQLString;

@DBTable(name="member")
public class Member {
   
	@SQLString(30)
	public String firstName;
	
	@SQLString(50)
	public String lastName;
	
	@SQLInteger
	public Integer age;
	
	@SQLString(value = 30,constraints=@Constraints(primaryKey=true))
	public String  handle;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
	
}
