package com.cg.emp.service;

import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.LeaveHistory;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;

public interface IEmployeeServ {
	
	public boolean isValid(User user) throws EmployeeException;
	public String addEmp() throws EmployeeException;
	public String modifyEmp() throws EmployeeException;
	public List<Employee> dispEmp(Employee emp) throws EmployeeException;
	public List<Employee> searchEmpByFName(String empFName) throws EmployeeException;
	public List<Employee> searchEmpByLName(String empLName) throws EmployeeException;
	public Employee searchEmpById(String empId) throws EmployeeException;
	public Employee searchEmpByDept(String dept) throws EmployeeException;
	public Employee searchEmpByGrade(String grade) throws EmployeeException;
	public Employee searchEmpByMS(String ms) throws EmployeeException;
	List<Employee> getLeavesList(Employee emp) throws EmployeeException;
	int LeaveEligibility(Employee emp) throws EmployeeException;
	int LeaveCheck(Employee emp) throws EmployeeException;
	boolean validateCustomer(Employee emp, LeaveHistory lh) throws EmployeeException;
	public String applyLeave(Employee emp, LeaveHistory lh) throws EmployeeException;
	public boolean approveLeave(Employee emp) throws EmployeeException;
	
}
