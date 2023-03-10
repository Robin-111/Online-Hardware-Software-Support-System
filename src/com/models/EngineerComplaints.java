package com.models;

import java.util.Date;

public class EngineerComplaints {

	private int engId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;
	private int complaintId;
	private int empId;
	private String complaintType;
	private String status;
	private Date dateRaised;
	private String dateResolved;
	public EngineerComplaints() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EngineerComplaints(int engId, String name, String userName, String password, String type, String location,
			int complaintId, int empId, String complaintType, String status, Date dateRaised, String dateResolved) {
		super();
		this.engId = engId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.location = location;
		this.complaintId = complaintId;
		this.empId = empId;
		this.complaintType = complaintType;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
	}
	@Override
	public String toString() {
		return "EngineerComplaints [engId=" + engId + ", name=" + name + ", userName=" + userName + ", password="
				+ password + ", type=" + type + ", location=" + location + ", complaintId=" + complaintId + ", empId="
				+ empId + ", complaintType=" + complaintType + ", status=" + status + ", dateRaised=" + dateRaised
				+ ", dateResolved=" + dateResolved + "]";
	}
	public int getEngId() {
		return engId;
	}
	public void setEngId(int engId) {
		this.engId = engId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateRaised() {
		return dateRaised;
	}
	public void setDateRaised(Date dateRaised) {
		this.dateRaised = dateRaised;
	}
	public String getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}
	
	
}
