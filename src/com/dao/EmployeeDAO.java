package com.dao;

import java.util.List;

import com.exceptions.ComplaintException;
import com.exceptions.EmployeeException;
import com.models.Complaints;
import com.models.Employee;
import com.models.EngineerComplaints;

public interface EmployeeDAO {

	public String registerEmployee(int deptid, String name, String username, String password) throws EmployeeException;
	
	public Employee loginEmployee(String username, String password) throws EmployeeException;
	
	public int raiseComplaint(int empId, String compType) throws ComplaintException;
	
	public EngineerComplaints checkComplaintStatus(int complaintId) throws ComplaintException;
	
	public List<Complaints> checkComplaintHistory(int empId) throws ComplaintException;
	
	public String changeEmployeePassword(String username, String oldPassword, String newPassword) throws EmployeeException;
}
