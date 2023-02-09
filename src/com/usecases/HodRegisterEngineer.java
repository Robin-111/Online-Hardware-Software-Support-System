package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.EngineerException;

public class HodRegisterEngineer {
   
	public void hodRegisterEngineer() {
		String res = "Invalid entry. Please try again.";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer name");
		String name = sc.next();
		System.out.println("Enter Engineer's Username");
		String username = sc.next();
		System.out.println("Enter Engineer's password");
		String password = sc.next();
		
		System.out.println("Enter 1 for Hardware Engineer");
		System.out.println("Enter 2 for Software Engineer");
		int typeChoice = sc.nextInt();
		
		String type = "";
		
		if(typeChoice==1) {
			type = "Hardware Engineer";
		}else if(typeChoice==2) {
			type = "Software Engineer";
		}else {
			System.out.println("Invalid choice. Please try again.");
			hodRegisterEngineer();
		}
		
		System.out.println("Enter Engineer's location");
		String location = sc.next();
		
		System.out.println("****************************************");
		
		HodDao dao = new HodDaoImpl();
		
		try {
			res = dao.registerEngineer(name, username, password, type, location);
			System.out.println(res);
			System.out.println("*************************************");
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
			System.out.println("*************************************************");
			hodRegisterEngineer();
		}
	}
}
