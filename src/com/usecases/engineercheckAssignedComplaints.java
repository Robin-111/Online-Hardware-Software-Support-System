package com.usecases;

import java.util.List;

import com.dao.EngineerDAO;
import com.dao.EngineerDaoImpl;
import com.exceptions.ComplaintException;
import com.models.Complaints;

public class engineercheckAssignedComplaints {

	
public void checkComplaintsAssigned(int engId) throws ComplaintException {
		
		EngineerDAO dao = new EngineerDaoImpl();
		try {
			List<Complaints> complaintsAssigned = dao.checkAssignedComplaints(engId);
			if(complaintsAssigned.isEmpty()) {
				System.out.println("No new complaints assigned.");
			}else
			complaintsAssigned.forEach(comps -> System.out.println(comps));
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			throw new ComplaintException("No complaints assigned.");
		}
		
	}
}
