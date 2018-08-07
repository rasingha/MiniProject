package com.cg.emp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmployeeServImpl;
import com.cg.emp.service.IEmployeeServ;

public class Home {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		IEmployeeServ service=new EmployeeServImpl();

		int choice=0,empCh=0;
		String eid, fname, lname, dept, grade, ms;
		
		
		while(true) {
			
			System.out.println("Enter ur choice:\n1. Admin\n2. Employee\n3. Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("*******For Admin********");
				break;
			case 2:System.out.println("*******For Employee*******");
				
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
			
			case 3:System.exit(0);
				break;
			
			default:
					break;
			}
		}
	}
}
