package com.usecases;

import java.util.List;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDaoImpl;
import com.exceptions.ComplaintException;
import com.models.Complaints;

public class empCheckingComplaintHistory {
  
public void checkComplaintHistory(int empId) {
		
		EmployeeDAO dao = new EmployeeDaoImpl();
		
		try {
			List<Complaints> complaints = dao.checkComplaintHistory(empId);
			complaints.forEach(comp -> System.out.println(comp));
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
