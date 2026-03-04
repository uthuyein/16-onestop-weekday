package com.jdc.mkt.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jdc.mkt.User;
import com.jdc.mkt.User.Gender;

public class UserDetail {

	static User getUserFromConsole() throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please type Id !");
		int id = Integer.parseInt(reader.readLine());
		
		System.out.println("Please type user name !");
		String name = reader.readLine();
		
		System.out.println("Please type gender !");
		Gender gender = Gender.valueOf(reader.readLine());
		
		var user = new User();
		user.setId(id);
		user.setName(name);
		user.setGender(gender);
		return user;
		
	}
}
