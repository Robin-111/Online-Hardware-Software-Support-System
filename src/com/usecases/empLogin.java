package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDaoImpl;
import com.exceptions.EmployeeException;
import com.models.Employee;

public class empLogin {
  public int loginEmp() {
	  int empId = 0;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		System.out.println("***************************");
		
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		try {
			Employee emp = dao.loginEmployee(username, password);
			System.out.println("Welcome "+ emp.getName());
			System.out.println("*************************************");
			empId = emp.getEmpId();
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("===========================================");
			loginEmp();
		}
	return empId;
	  
  }
}
