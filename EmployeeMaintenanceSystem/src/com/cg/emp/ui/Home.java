package com.cg.emp.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.LeaveHistory;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.EmployeeServImpl;
import com.cg.emp.service.IEmployeeServ;

public class Home {
	
	static int empCh=0;
	static int adminChoice=0;
	static String eid, fname, lname, dept, grade, ms;
	static User user=null;
	static Scanner sc=new Scanner(System.in);
	static IEmployeeServ empServ=null;
	static LeaveHistory lh=null;
	static Employee emp=null;
	static Logger logger = Logger.getRootLogger();
	static List<Employee> leavesList =null;
	static int choice=0;
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
						
							case 1:
								searchEmployee();	
									break;
							case 2:
								applyforLeave();
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
						
							case 1: 
								leaveApproval();
									break;
							case 2: 
								searchEmployee();
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
		empServ=new EmployeeServImpl();
		emp=new Employee();
		lh=new LeaveHistory();
		while(true) {
		System.out.println("\t\t\t\t\t---------Leave Application----------");
		System.out.println("Employee ID:");
		emp.setEmpId(sc.next());
		System.out.println("Employee Full Name:");
		emp.setEmpFullName(sc.next());
		System.out.println("Leave Balance:");
		lh.setLeave_bal(sc.nextInt());
		System.out.println("Leave from(dd/mm/yyyy):");
		lh.setDate_from(sc.next());
		System.out.println("Leave upto(dd/mm/yyyy):");
		lh.setDate_to(sc.next());
		System.out.println("Number Of Days");
		lh.setNoofdays_App(sc.nextInt());
		try {
		if(empServ.validateCustomer(emp,lh)){
			String leave_id=empServ.applyLeave(emp,lh);
				if(leave_id != null)
				{
					System.out.println("\nLeave applied successfully with leave Id "+leave_id+"\nWait for the Approval..");
				break;
				}
				else {
					System.out.println("Problem occured.Check Log file or console");
				}
			} 
		else {
			System.err.println("Please enter details in valid format, Try again");
		}}
		catch (EmployeeException e) {
			logger.error("exception occured",e);
			System.out.println("ERROR : "+ e.getMessage());
		}
		}
		
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
		

	/******Functionality of Manager(Leave Approval)*****************/
	private static void leaveApproval() {
		empServ=new EmployeeServImpl();
		emp=new Employee();
		lh=new LeaveHistory();
		leavesList = new ArrayList<Employee>();
		String result = null;
		String result1 = null;
		try {
			leavesList = empServ.getLeavesList(emp);
			if (leavesList != null) {
				Iterator<Employee> i = leavesList.iterator();
				System.out.println("\n\tLeave Requests:-");
				System.out.println("\t-----------------\n");
				System.out.format("%10s%19s%20s%25s%15s%15s%15s\n", "LEAVE ID", "EMP ID", "LEAVE BALANCE",
						"NO OF DAYS APPLIED", "DATE_FROM", "DATE_TO", "STATUS");
				while (i.hasNext()) {

					Employee e = (Employee) i.next();
					try {
						SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");

						java.util.Date date = in.parse(e.getDate_from());
						java.util.Date date1 = in.parse(e.getDate_to());
						result = out.format(date);
						result1 = out.format(date1);
					} catch (ParseException e1) {
						
						logger.error("exception occured",e1);
						System.out.println("ERROR : "+ e1.getMessage());
					}
					System.out.format("%4s%26s%15s%20s%25s%15s%15s\n", e.getLeave_id(), e.getEmpId(), e.getLeave_bal(),
							e.getNoofdays_App(), result, result1,e.getStatus());
				}
			} else {
				System.out.println("No Leave Requests Found");
			} 
		
		while(true) {
			System.out.println("\n\t\t\t---------Enter Emp Id of Employee request you want to accept/reject----------");
			System.out.println("Employee ID:");
			emp.setEmpId(sc.next());
			if(empServ.LeaveCheck(emp)==0)
			{
				System.out.println("The Leave with '"+emp.getEmpId()+"' is not found");
				System.out.println("Enter correct Emp ID");
			}
			else if(empServ.LeaveEligibility(emp)==0)
			{
				System.out.println("\nSo,The Person with '"+emp.getEmpId()+"' is not eligible for Leave");
				break;
			}
			else {
				System.out.println("\nThe Person with '"+emp.getEmpId()+"' is eligible for Leave");
				break;
			}
				
				} 
		
		
		
			while(true) {
				
		System.out.println("---------Leave Approval----------");
		System.out.println("1) Approve");
		System.out.println("2) Reject");
		System.out.println("Enter Your Choice:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			emp.setStatus("approved");
			if(empServ.approveLeave(emp)) {
				System.out.println("\nLeave approved successfully");
				break;
			}
			break;
		case 2:
			emp.setStatus("rejected");
			if(empServ.approveLeave(emp)) {
				System.out.println("\nLeave rejected successfully");
			}
		
	}
		break;
			}
		}
		catch (EmployeeException e) {
			logger.error("exception occured",e);
			System.out.println("ERROR : "+ e.getMessage());
		}
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
