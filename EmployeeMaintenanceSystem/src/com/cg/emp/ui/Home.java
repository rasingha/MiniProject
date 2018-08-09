package com.cg.emp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmployeeServImpl;
import com.cg.emp.service.IEmployeeServ;

public class Home {
	
	static int empCh=0;
	static int adminChoice=0;
	static String eid, fname, lname, dept, grade, ms;
	static User user=null;
	public static void main(String[] args) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		PropertyConfigurator.configure("resources/log4j.properties");
		
		while(true) {
			user=new User();
			System.out.println("*************Welcome to Capgemini Portal*************");
			System.out.println("\n");
			System.out.println("  LOGIN ");
			System.out.println("User Id:");
			user.setUserId(sc.next());
			System.out.println("UserName: ");
			user.setUserName(sc.next());	
			System.out.println("Password: ");				
			user.setUserPassword(sc.next());
			
			/********Admin Login through his credentials****/
			if(user.getUserId().charAt(0)=='A'&&user.getUserName().equals("admin")&&user.getUserPassword().equals("admin"))
			{
				System.out.println("*******Welcome Admin********");
				System.out.println("\nEnter Your Choice\n1.) Add Employee Details\n"
						+ "2.) Modify Employee Details\n3.) Display all Employee Details\n4.)Exit");
				System.out.println("Choose an Option");
				adminChoice=sc.nextInt();
				switch(adminChoice) {
				
					case 1: System.out.println("In add Employee");
							populateaddEmployee();
							break;
							
					case 2: System.out.println("In modify Employee");
							populatemodifyEmployee();
							break;
					
					case 3: System.out.println("In display Employee");
							populatedispEmployee();
							break;
					case 4: exit(0);
							break;
				}
					
			}	
			
			/*****Employee Login through his credentials********/
			else if(user.getUserId().charAt(0)=='E'){	
				IEmployeeServ service=new EmployeeServImpl();
				try {
					boolean userValid=service.isValid(user);	
					System.out.println(userValid);
					if(userValid==true)
					{
						System.out.println("\nEnter your choice:\n1) Search an Employee\n"
								+ "2) Apply for a Leave");
						int empCh=sc.nextInt();
						switch(empCh) {
						
							case 1: searchEmployee();	
									break;
							case 2: applyforLeave();
									break;
						}
							
					}
				}catch(EmployeeException em) {
					System.err.println(em);
				}	
				
			}	
			
			/********Manager get Logged in through his credentials*********/
			else {
				IEmployeeServ service=new EmployeeServImpl();
				try {
					boolean userValid=service.isValid(user);	
					System.out.println(userValid);
					if(userValid==true)
					{
						System.out.println("\n1) Aprrove a Leave\n2) Search an Employee");
						System.out.println("Enter your choice");
						int mgrChoice=sc.nextInt();
						switch(mgrChoice) {
						
							case 1: leaveApproval();
									break;
							case 2: searchEmployee();
									break;
						}
				
					}
				}catch(EmployeeException em) {
					System.err.println(em);
				}
			}	
		
		}		
	}

	/*****************Functionalities of Employee****************************/
	private static void applyforLeave() {
		// TODO Auto-generated method stub
		
	}

	private static void searchEmployee() {
		
		Scanner sc=new Scanner(System.in);
		IEmployeeServ service=new EmployeeServImpl();
		try {
			boolean userValid=service.isValid(user);	
			System.out.println(userValid);
			if(userValid==true)
			{	
				System.out.println("*******Welcome "+user.getUserName()+"***********");				
				while(true)
				{
						System.out.println("\nEnter choice for search\n1."
								+ " Search by Employee id\n2. Search by First Name\n"
								+ "3. Search by Last Name\n4. Search by Department\n"
								+ "5. Search by Grade\n6. Search by Marital Status\n");
						empCh=sc.nextInt();
				
							switch(empCh)
							{
								case 1: searchByEmpId();
										break;
									
								case 2: searchByFName();									
										break;
									
								case 3: searchByLName();											
										break;
									
								case 4:	searchByDept();
										break;
										
								case 5:	searchByGrade();
										break;
										
								case 6:	searchByMarStatus();
										break;
								case 7: exit(0);
										break;
								default:
										break;
							}
						}
			}
		}catch(EmployeeException em) {
			System.err.println(em);
		}	
		sc.close();
		
	}
		private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

		private static void searchByMarStatus() {
			// TODO Auto-generated method stub
			
		}
	
		private static void searchByGrade() {	
			Scanner sc=new Scanner(System.in);
			IEmployeeServ service=new EmployeeServImpl();
			Employee e=new Employee();
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
			sc.close();		
		}
	
		private static void searchByDept() {
			// TODO Auto-generated method stub
			
		}
	
		private static void searchByLName() {		
			Scanner sc=new Scanner(System.in);
			IEmployeeServ service=new EmployeeServImpl();
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
			sc.close();		
		}
	
		private static void searchByFName() {	
			Scanner sc=new Scanner(System.in);
			IEmployeeServ service=new EmployeeServImpl();
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
			sc.close();		
		}
	
		private static void searchByEmpId() {
			Scanner sc=new Scanner(System.in);
			Employee e=new Employee();
			IEmployeeServ service=new EmployeeServImpl();
			System.out.println("Enter Employee ID: ");
			eid=sc.next();		
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
			sc.close();
		}

	/*******End Of Functionality of Employee***********/
		

	/******Functionality of Manager*****************/
	private static void leaveApproval() {
		// TODO Auto-generated method stub
		
	}
	/******End of Functionality of Manager*****************/
	
	

	/*******Functionalities of Admin***********/
	
	private static void populatedispEmployee() {
		// TODO Auto-generated method stub
		
	}

	private static void populatemodifyEmployee() {
		// TODO Auto-generated method stub
		
	}

	private static void populateaddEmployee() {
		// TODO Auto-generated method stub
		
	}
	/*******End of Functionalities of Admin***********/
	
}
