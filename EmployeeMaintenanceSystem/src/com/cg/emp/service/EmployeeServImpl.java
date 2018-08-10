package com.cg.emp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.LeaveHistory;
import com.cg.emp.bean.User;
import com.cg.emp.dao.EmployeeDaoImpl;
import com.cg.emp.dao.IEmployeeDao;
import com.cg.emp.exception.EmployeeException;

public class EmployeeServImpl implements IEmployeeServ {
	
	IEmployeeDao empDao=null;
	LocalDateTime ldt = null;
	
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public boolean isValid(User user) throws EmployeeException {
		
		IEmployeeDao iEmployeeDao=new EmployeeDaoImpl();
		HashMap<String, String> h1=iEmployeeDao.getData();
		System.out.println(h1.get(user.getUserName()));
		if(h1.containsKey(user.getUserName())) {
			if(user.getUserPassword().equals(h1.get(user.getUserName()))) {
				return true;
			}
			else
				throw new EmployeeException("Invalid Credentials");
		}
		return false;
			
	}
	
	@Override
	public String addEmp() throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.addEmp();
	}

	@Override
	public String modifyEmp() throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.modifyEmp();
	}

	@Override
	public List<Employee> dispEmp(Employee emp) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.dispEmp(emp);
	}

	public List<Employee> searchEmpByFName(String empFName) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpByFName(empFName);
	}
	
	public List<Employee> searchEmpByLName(String empLName) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpByLName(empLName);
	}


	public Employee searchEmpById(String empId) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpById(empId);
	}


	public Employee searchEmpByDept(String dept) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpByDept(dept);
	}

	public Employee searchEmpByGrade(String grade) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpByGrade(grade);
	}

	
	public Employee searchEmpByMS(String ms) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.searchEmpByMS(ms);
	}
	@Override
	public boolean validateCustomer(Employee emp, LeaveHistory lh) throws EmployeeException {
		List<String> validationErrors = new ArrayList<String>();

		
		if(!(isValidEmpName(emp.getEmpFullName()))) {
			validationErrors.add("\n Name Should Be In Alphabets and minimum 3 characters long ! \n");
		}
		
		if(!(isValidEmpId(emp.getEmpId()))){
			validationErrors.add("\n ID Should Be in the format E123456 \n");
		}
		
		if(!(isValidDateFrom(lh.getDate_from()))){
			System.out.println(lh.getDate_from());
			validationErrors.add("\n Date From field should be in format dd/MM/yyyy \n");
		}
		
		if(!(isValidDateTo(lh.getDate_to()))){
			System.out.println(lh.getDate_to());
			validationErrors.add("\n Date to field should be in format dd/MM/yyyy \n" );
		}
		
		if(!validationErrors.isEmpty())
			throw new EmployeeException(validationErrors+"");
		else
			return true;
	}

	private boolean isValidDateTo(String date_to) {
		try {
			ldt=LocalDateTime.parse(date_to,dateFormat);
			String text=ldt.format(dateFormat);
	        return text.equals(date_to);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(date_to, dateFormat);
	            String result = ld.format(dateFormat);
	            return result.equals(date_to);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(date_to, dateFormat);
	                String result = lt.format(dateFormat);
	                return result.equals(date_to);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                e2.printStackTrace();
	            }
	        }
	    }

	    return false;
	}

	private boolean isValidDateFrom(String date_from) {
		try {
			ldt=LocalDateTime.parse(date_from,dateFormat);
			String text=ldt.format(dateFormat);
	        return text.equals(date_from);
	    } catch (DateTimeParseException e) {
	        try {
	            LocalDate ld = LocalDate.parse(date_from, dateFormat);
	            String result = ld.format(dateFormat);
	            return result.equals(date_from);
	        } catch (DateTimeParseException exp) {
	            try {
	                LocalTime lt = LocalTime.parse(date_from, dateFormat);
	                String result = lt.format(dateFormat);
	                return result.equals(date_from);
	            } catch (DateTimeParseException e2) {
	                // Debugging purposes
	                e2.printStackTrace();
	            }
	        }
	    }

	    return false;
		
	}

	private boolean isValidEmpId(String empId) {
		Pattern namePattern=Pattern.compile("^[E][0-9]{5}$");
		Matcher nameMatcher=namePattern.matcher(empId);
		return nameMatcher.matches();
	}

	private boolean isValidEmpName(String empFullName) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(empFullName);
		return nameMatcher.matches();
	}
	@Override
	public List<Employee> getLeavesList(Employee emp) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.getLeavesList(emp);
	}

	@Override
	public int LeaveEligibility(Employee emp) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.LeaveEligibility(emp);
		
	}

	@Override
	public int LeaveCheck(Employee emp) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.LeaveCheck(emp);
		
	}
	public String applyLeave(Employee emp,LeaveHistory lh) throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.applyLeave(emp,lh);
	}

	
	public boolean approveLeave(Employee emp) throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.approveLeave(emp);
	}

}
