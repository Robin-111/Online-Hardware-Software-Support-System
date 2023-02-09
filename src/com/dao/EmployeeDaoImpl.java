package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.ComplaintException;
import com.exceptions.EmployeeException;
import com.exceptions.EngineerException;
import com.models.Complaints;
import com.models.Employee;
import com.models.EngineerComplaints;
import com.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public String registerEmployee(int deptid, String name, String username, String password) throws EmployeeException {
		
		// TODO Auto-generated method stub
String res = "Failed.... Details entered are incorrect. Please recheck and try again!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into employee (deptid,name,username,password)"
					+ "values(?,?,?,?)");
			ps.setInt(1, deptid);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, password);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = "Registration Successfull.";
			}else {
				throw new EmployeeException("Registration failed.  Recheck entries and try again.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException {
Employee emp = new Employee();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where username=?"
					+ "AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp.setEmpId(rs.getInt("empId"));
				emp.setDeptid(rs.getInt("deptId"));
				emp.setName(rs.getString("name"));
				emp.setUserName(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
			}else {
				throw new EmployeeException("Invalid username or password");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}

	@Override
	public int raiseComplaint(int empId, String compType) throws ComplaintException {
int complaintId = 0;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into complaints (complaintId,"
					+ "empId, complaintType,status, dateRaised) values(?,?,?,?,?)");
			
			complaintId = (int) (Math.random()*10000);
			LocalDate dateRaised = LocalDate.now();
			
			ps.setInt(1, complaintId);
			ps.setInt(2, empId);
			ps.setString(3, compType);
			ps.setString(4, "Raised");
			ps.setDate(5, java.sql.Date.valueOf(dateRaised));
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Complaint raised successfully");
			}else {
				throw new ComplaintException("Complaint could not be raised. Please try again.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaintId;
	}

	@Override
	public EngineerComplaints checkComplaintStatus(int complaintId) throws ComplaintException {
EngineerComplaints ec = new EngineerComplaints();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select c.complaintId, c.engId, e.name,c.complaintType, c.status, c.dateRaised from complaints c INNER JOIN engineer e ON c.engId=e.engId where complaintId=?");
			
			ps.setInt(1, complaintId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ec.setComplaintId(rs.getInt("complaintId"));
				ec.setComplaintType(rs.getString("complaintType"));
				
				ec.setEngId(rs.getInt("engId"));
				ec.setName(rs.getString("name"));
				ec.setStatus(rs.getString("status"));
				ec.setDateRaised(rs.getDate("dateRaised"));
			}else {
				throw new ComplaintException("Complaint not assigned yet. Please check back later.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return ec;
	}

	@Override
	public List<Complaints> checkComplaintHistory(int empId) throws ComplaintException {
List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where empId=?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints comp = new Complaints();
				comp.setComplaintId(rs.getInt("complaintId"));
				comp.setEmpId(rs.getInt("empId"));
				comp.setComplaintType(rs.getString("complaintType"));
				comp.setEngId(rs.getInt("engId"));
				comp.setStatus(rs.getString("status"));
				comp.setDateRaised(rs.getDate("dateRaised"));
				comp.setDateResolved(rs.getDate("dateResolved"));
				
				complaints.add(comp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return complaints;
	}

	@Override
	public String changeEmployeePassword(String username, String oldPassword, String newPassword)
			throws EmployeeException {
	String res = "Password could not be changed. Please try again.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set password=? where username=? and password=?");
			
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, oldPassword);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = "Password changed successfully.";
			}else {
				throw new EmployeeException("Wrong username or password entered. Please try again.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return res;
	}

}
