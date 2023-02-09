package com.dao;

import java.util.List;

import com.exceptions.ComplaintException;
import com.exceptions.EngineerException;
import com.exceptions.HODException;
import com.models.Complaints;
import com.models.Engineer;
import com.models.HOD;

public interface HodDao {
public HOD loginHod(String username, String password) throws HODException;
	
	public String registerEngineer(String name, String username, String password, String type, String location) throws EngineerException;
	
	public List<Engineer> getEngineers() throws EngineerException;
	
	public String deleteEngineer(int engId) throws EngineerException;
	
	public List<Complaints> checkComplaints() throws ComplaintException;
	
	public String assignComplaintToEngineer(int complaintId, int engId) throws EngineerException;
}
