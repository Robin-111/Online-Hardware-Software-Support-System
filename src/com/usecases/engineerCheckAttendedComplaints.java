package com.usecases;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDaoImpl;
import com.exceptions.ComplaintException;
import com.models.Complaints;

public class engineerCheckAttendedComplaints {
	public void checkComplaintsAttended(int engId) {
		EngineerDAO dao = new EngineerDaoImpl();
		
		try {
			List<Complaints> comps = dao.checkComplaintsAttended(engId);
			if(comps.isEmpty()) {
				System.out.println("No complaints attended.");
			}else {
				comps.forEach(comp -> System.out.println(comp));
			}
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
