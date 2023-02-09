package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.HODException;
import com.models.HOD;

public class HodLogin {
	public void LoginHod() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		System.out.println("==================================");
		
		HodDao dao = new HodDaoImpl();
		
		try {
			HOD hod = dao.loginHod(username, password);
			System.out.println("Welcome "+ hod.getName());
			System.out.println("======================================");
			
		} catch (HODException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("===========================================");
			LoginHod();
		}
	}
}
