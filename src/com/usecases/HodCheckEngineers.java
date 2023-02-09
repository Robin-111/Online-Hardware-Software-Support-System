package com.usecases;

import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exceptions.EngineerException;
import com.models.Engineer;

public class HodCheckEngineers {
    
	public void hodCheckEngineers() {
		HodDao dao = new HodDaoImpl();
		
		try {
			List<Engineer> engs = dao.getEngineers();
			engs.forEach(eng -> System.out.println(eng));
			System.out.println("***********************************");
			
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}
}
