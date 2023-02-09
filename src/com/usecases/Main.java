package com.usecases;

import java.util.Scanner;

import com.exceptions.ComplaintException;

public class Main {

	  public static void main(String[] args) {
			System.out.println("Welcome to the Online Hardware Software Support System.");
			System.out.println("**********************************************");
			System.out.println("Enter 1 if you are the HOD.");
			System.out.println("Enter 2 if you are an employee.");
			System.out.println("Enter 3 if you are a system engineer.");
			System.out.println("Enter 4 to exit");
			
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			System.out.println("*******************************");
			
			switch(choice) {
			
			case 1:
				System.out.println("HOD");
				System.out.println("********************************");
				HodLogin login = new HodLogin();
				login.LoginHod();
				
				while(true) {
					System.out.println("Enter 1 : Register  new Engineer.");
					System.out.println("Enter 2 : See the list of all registered engineers.");
					System.out.println("Enter 3 : Delete any Engineer.");
					System.out.println("Enter 4 : See all raised complaints");
					System.out.println("Enter 5 : Assign a complaint to an engineer.");
					System.out.println("Enter 6 : Logout");
					
					int hodChoice=sc.nextInt();
					System.out.println("**********************************");
					
					if(hodChoice==1) {
						HodRegisterEngineer reg = new HodRegisterEngineer();
						System.out.println("Register a new Engineer.");
						System.out.println("****************************************");
						reg.hodRegisterEngineer();
					}
						
					else if(hodChoice==2) {
						HodCheckEngineers chk = new HodCheckEngineers();
						System.out.println("Engineers List");
						System.out.println("**************************************");
						chk.hodCheckEngineers();
					}				
						
					else if(hodChoice==3) {
						HodDeleteEngineer dlt = new HodDeleteEngineer();
						dlt.hodDeleteEngineer();
						System.out.println("***************************************");
					}
								
					else if(hodChoice==4) {
						HodCheckComplaints chkCom = new HodCheckComplaints();
						System.out.println("All Complaints");
						System.out.println("=====================================");
						chkCom.hodCheckAllComplaints();
						System.out.println("=====================================");
					}
					
					else if(hodChoice==5) {
						HodAssigningComplaintsToEngineer assign = new HodAssigningComplaintsToEngineer();
						assign.hodAssignToEngineer();
						System.out.println("=====================================");
					}
						
					else if(hodChoice==6) {
						Main.main(args);
					}
						
						
					else {
						System.out.println("Invalid choice. Please enter a correct choice.");
						System.out.println("====================================================");
					
					}
				}
				
			case 2:
				while(true) {
					System.out.println("Employee.");
					System.out.println("==================================================");
					System.out.println("Enter 1 to login if you are already registered.");
					System.out.println("Enter 2 to register to the system if you are a new employee.");
					System.out.println("Enter 3 to exit.");
					
					int empChoiceLogin = sc.nextInt();
					if(empChoiceLogin==1) {
						empLogin empLogin = new empLogin();
						int empIdLoggedin=empLogin.loginEmp();

						
						while(true) {
							System.out.println("Enter 1 to register a complaint.");
							System.out.println("Enter 2 to check status of a complaint.");
							System.out.println("Enter 3 to check complaint history.");
							System.out.println("Enter 4 to change password.");
							System.out.println("Enter 5 to logout.");
							
							int empChoice = sc.nextInt();
							System.out.println("==========================================");
							System.out.println("Employee.");
							System.out.println("===========================================");
							if(empChoice==1) {
								System.out.println("Raise Complaint.");
								System.out.println("=======================================");
								empRaisingComplaint empTicket = new empRaisingComplaint();
								empTicket.raiseComplaint(empIdLoggedin);
								System.out.println("========================================");
							}else if(empChoice==2) {
								empCheckComplaintStatus empStatus= new empCheckComplaintStatus();
								empStatus.checkComplaintStatus();
								System.out.println("==========================================");
							}else if(empChoice==3) {
								System.out.println("Complaint History");
								System.out.println("============================================");
								empCheckingComplaintHistory empHis = new empCheckingComplaintHistory();
								empHis.checkComplaintHistory(empIdLoggedin);
								System.out.println("=============================================");
							}else if(empChoice==4) {
								System.out.println("Change password.");
								System.out.println("=============================================");
								empChangePassword empChngPswrd = new empChangePassword();
								empChngPswrd.employeeChangePassword();
								System.out.println("=============================================");
								
							}else if(empChoice==5) {
								main(args);
							}
						}
						
					}else if(empChoiceLogin==2) {
						emplRegisteration empRegister = new emplRegisteration();
						empRegister.registerEmployee();
						System.out.println("============================================");
					}else if(empChoiceLogin==3){
						System.out.println("*****************************************");
						System.out.println("Thank you.");
						System.exit(0);
					}else {
						System.out.println("Invalid choice. Please try again.");
					}
				}
				
			case 3:
				System.out.println("System Engineer");
				System.out.println("==================================================");
				
				engineerLogin engLogin = new engineerLogin();
				int engIdLoggedin=engLogin.engineerLogin();
				System.out.println("=================================================");
				

				while(true) {
					
					System.out.println("Enter 1 to check complaints assigned.");
					System.out.println("Enter 2 to update the status of a complaint.");
					System.out.println("Enter 3 to see list of all the complaints attended.");
					System.out.println("Enter 4 to change password.");
					System.out.println("Enter 5 to logout.");
					
					int engChoice = sc.nextInt();
					if(engChoice==1) {
						engineercheckAssignedComplaints engCompsAss = new engineercheckAssignedComplaints();
						System.out.println("Complaints Assigned.");
						System.out.println("==============================================");
						try {
							engCompsAss.checkComplaintsAssigned(engIdLoggedin);
							System.out.println("==========================================");
						} catch (ComplaintException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						
					}else if(engChoice==2) {
						System.out.println("Update complaint status");
						System.out.println("==============================================");
					    engineerUpdatingComplaintsStatus engUpdateComplaint = new engineerUpdatingComplaintsStatus();
						engUpdateComplaint.engUpdateComplaintStatus();
						System.out.println("==============================================");
						
					}else if (engChoice==3) {
						System.out.println("All complaints attended.");
						System.out.println("================================================");
						engineerCheckAttendedComplaints engAttended = new engineerCheckAttendedComplaints();
						engAttended.checkComplaintsAttended(engIdLoggedin);
						System.out.println("=================================================");
						
					}else if(engChoice==4) {
						System.out.println("Change password.");
						System.out.println("=================================================");
						engineerChangingPassword engChangePswrd = new engineerChangingPassword();
						engChangePswrd.engineerChangePassword();
						System.out.println("==================================================");
						
					}else if(engChoice==5) {
						
						main(args);
					}else {
						System.out.println("Invalid choice. Please try again with other valid option.");
					}
				}
				
				
			case 4: 
				System.out.println("Thank you!!!!.");
				System.exit(0);
			
			}
	}
}
