package com.dao;

import java.util.List;

import com.exceptions.ComplaintException;
import com.exceptions.EngineerException;
import com.models.Complaints;
import com.models.Engineer;

public interface EngineerDAO {
  
public Engineer loginEngineer(String username, String password) throws EngineerException;
	
	public List<Complaints> checkAssignedComplaints(int engId) throws ComplaintException;
	
	public String updateComplaintStatus(int complaintId, String newStatus) throws ComplaintException;
	
	public List<Complaints> checkComplaintsAttended(int engId) throws ComplaintException;
	
	public String changeEngineerPassword(String username, String oldPassword, String newPassword) throws EngineerException;
}
