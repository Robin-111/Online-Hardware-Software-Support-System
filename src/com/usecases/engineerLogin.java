package com.usecases;

import java.util.Scanner;

import com.dao.EngineerDAO;
import com.dao.EngineerDaoImpl;
import com.exceptions.EngineerException;
import com.models.Engineer;

public class engineerLogin {
  
public int engineerLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("*****************************");
		
		EngineerDAO dao = new EngineerDaoImpl();
		int engId = 0;
		
		try {
			Engineer eng = dao.loginEngineer(username, password);
			System.out.println("Welcome " + eng.getName());
			engId=eng.getEngId();
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			engineerLogin();
		}
		return engId;
	}
}
