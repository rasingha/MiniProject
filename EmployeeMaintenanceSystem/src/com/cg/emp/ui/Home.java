package com.cg.emp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmployeeServImpl;
import com.cg.emp.service.IEmployeeServ;

public class Home {
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		IEmployeeServ service=new EmployeeServImpl();
		User user=null;
		int empCh=0;
		String eid, fname, lname, dept, grade, ms;
			
		while(true) {
			user=new User();
			System.out.println("*************Welcome to Capgemini Portal*************");
			System.out.println("\n");
			System.out.println("  LOGIN ");
			System.out.println("UserName: ");
			user.setUserName(sc.next());	
			System.out.println("Password: ");				
			user.setUserPassword(sc.next());
			
			if(user.getUserName().equals("admin")&&user.getUserPassword().equals("admin"))
			{
				System.out.println("*******For Admin********");
					
			}	
			else {					
				try {
					boolean userValid=service.isValid(user);	
					System.out.println(userValid);
					if(userValid==true)
					{	
						System.out.println("*******For Employee*******");				
						while(true)
						{
								System.out.println("\nEnter choice for search\n1. Search by Employee id\n2. Search by First Name\n3. Search by Last Name"
										+ "\n4. Search by Department\n5. Search by Grade\n6. Search by Marital Status\n7. Apply for leave");
								empCh=sc.nextInt();
						
									switch(empCh)
									{
										case 1:
											System.out.println("Enter Employee ID: ");
											eid=sc.next();
											Employee e=new Employee();
											try {
												e=service.searchEmpById(eid);
												if(e==null)
												{
													System.out.println("Sorry...Record Not Found...!!!");
												}
												else
												{
													System.out.println("Employee ID : "+e.getEmpId()+"\nFirst Name : "+e.getEmpFName()+"\nLast Name : "+e.getEmpLName()+"\nDate of Birth : "+e.getEmpDOB()+"\nDate of Joining : "+e.getEmpDOJ()+""
															+ "\nDepartment ID : "+e.getEmpDeptId()+"\nDepartment Name : "+e.getDept_name()+"\nGrade : "+e.getEmpGrade()+"\nDesignation : "+e.getEmpDesign()+"\nEmployee Basic : "+e.getEmpBasic()+"\nGender : "+e.getEmpGender()+"\nMarital Status : "+e.getEmpMStatus()+"\nHome Address : "+e.getEmpAddress()+"\nContact Number : "+e.getEmpContact()+"\nEmployee's Manager ID : "+e.getEmpMgrId());
												}
													
											} catch (EmployeeException e1) {
												System.err.println(e1.getMessage());
											}
											break;
											
										case 2:
											System.out.println("Enter First Name: ");
											fname=sc.next();
											
											List<Employee> l1= new ArrayList<Employee>();
				
											try {
												l1=service.searchEmpByFName(fname);
												if(l1==null)
												{
													System.out.println("Sorry...Record Not Found...!!!");
												}
												else
												{
													for(Employee e1 : l1) {
														System.out.println(e1);
													}
												}
													
											} catch (EmployeeException e1) {
												System.err.println(e1.getMessage());
											}
											break;
											
										case 3:
											
											System.out.println("Enter Last Name: ");
											lname=sc.next();
											List<Employee> emp2= new ArrayList<Employee>();
											
											try {
												emp2=service.searchEmpByLName(lname);
												if(emp2==null)
												{
													System.out.println("Sorry...Record Not Found...!!!");
												}
												else
												{
													for(Employee employee : emp2) {
														System.out.println(employee);
													}
												}
													
											} catch (EmployeeException emp) {
												System.err.println(emp.getMessage());
											}
											break;
											
										case 4:
												break;
										case 5:
											
												System.out.println("Enter Grade : ");
												grade=sc.next();
												try {
													e=service.searchEmpByGrade(grade);
													if(e==null)
													{
														System.out.println("Sorry...Record Not Found...!!!");
													}
													else
													{
														System.out.println("Employee ID : "+e.getEmpId()+"\nFirst Name : "+e.getEmpFName()+"\nLast Name : "+e.getEmpLName()+"\nDate of Birth : "+e.getEmpDOB()+"\nDate of Joining : "+e.getEmpDOJ()+""
																+ "\nDepartment ID : "+e.getEmpDeptId()+"\nGrade : "+e.getEmpGrade()+"\nDesignation : "+e.getEmpDesign()+"\nEmployee Basic : "+e.getEmpBasic()+"\nGender : "+e.getEmpGender()+"\nMarital Status : "+e.getEmpMStatus()+"\nHome Address : "+e.getEmpAddress()+"\nContact Number : "+e.getEmpContact()+"\nEmployee's Manager ID : "+e.getEmpMgrId());
													}
														
												} catch (EmployeeException e1) {
													System.err.println(e1.getMessage());
												}
												break;
										case 6:
												break;
										default:
												break;
									}
								}
					}
				}	
					catch(EmployeeException em) {
						System.err.println(em);
					}
			}
				
				
			}
		}
	
}
