package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDaoImpl;
import com.exceptions.ComplaintException;
import com.models.EngineerComplaints;

public class empCheckComplaintStatus {
    public void checkComplaintStatus() {
		// TODO Auto-generated method stub
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter your complaint id to check status");
		int compId = sc.nextInt();
		System.out.println("****************************");
		System.out.println("Complaint status:- ");
		
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		try {
			EngineerComplaints dto =  dao.checkComplaintStatus(compId);
			System.out.println("ComplaintId: " + dto.getComplaintId());
			System.out.println("Complaint Type: " + dto.getComplaintType());
			System.out.println("Engineer id: " + dto.getEngId());
			System.out.println("Engineer name: " + dto.getName());
			System.out.println("Status: " + dto.getStatus());
			System.out.println("Date raised: " + dto.getDateRaised());
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
