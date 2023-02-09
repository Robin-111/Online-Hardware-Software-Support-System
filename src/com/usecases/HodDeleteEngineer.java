package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.EngineerException;

public class HodDeleteEngineer {
	public void hodDeleteEngineer() {
		System.out.println("Delete Engineer");
		System.out.println("=======================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer Id to be deleted .....");
		int engId = sc.nextInt();
		System.out.println("=======================================");
		HodDao dao = new HodDaoImpl();
		
		try {
			String res = dao.deleteEngineer(engId);
			System.out.println(res);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}
