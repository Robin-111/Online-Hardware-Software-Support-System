package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDaoImpl;
import com.exceptions.ComplaintException;

public class empRaisingComplaint {
   
	public void raiseComplaint(int empId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 if Hardware Complaint.");
		System.out.println("Press 2 if Software Complaint.");
		int compChoice = sc.nextInt();
		String compType="Not mentioned";
		if(compChoice==1) compType="Hardware";
		
		else if(compChoice==2) compType ="Software";
		
		else {
			System.out.println("Invalid Choice. Please try again.");
			System.out.println("==================================");
			raiseComplaint(empId);
		}
		
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		try {
			int compId = dao.raiseComplaint(empId, compType);
			System.out.println("Complaint Id: "+ compId +" Please keep this noted down to check complaint status lates.");
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
