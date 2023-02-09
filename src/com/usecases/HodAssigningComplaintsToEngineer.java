package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.EngineerException;

public class HodAssigningComplaintsToEngineer {
   
	public void hodAssignToEngineer() {
		Scanner sc = new Scanner(System.in);
		HodDao dao = new HodDaoImpl();
		System.out.println("Assign complaint to an engineer");
		System.out.println("========================================");
		
		System.out.println("Enter complaint id to be assigned.");
		int compId = sc.nextInt();
		System.out.println("Enter engineer id to assign the complaint.");
		int engId = sc.nextInt();
		
		try {
			String res = dao.assignComplaintToEngineer(compId, engId);
			System.out.println(res);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}
