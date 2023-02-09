package com.usecases;

import java.util.ArrayList;
import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.ComplaintException;
import com.models.Complaints;

public class HodCheckComplaints {
public void hodCheckAllComplaints() {
		
		List<Complaints> comps = new ArrayList<>();
		
		HodDao dao = new HodDaoImpl();
		
		try {
			comps = dao.checkComplaints();
			comps.forEach(comp -> System.out.println(comp));
		} catch (ComplaintException e) {
			System.out.println(e.getMessage());
		} 
	}
}
