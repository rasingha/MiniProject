package com.cg.emp.service;

import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.EmployeeException;

public interface IEmployeeServ {
	
	public String addEmp() throws EmployeeException;
	public String modifyEmp() throws EmployeeException;
	public List<Employee> dispEmp(Employee emp) throws EmployeeException;
	public boolean applyLeave() throws EmployeeException;
	public boolean approveLeave() throws EmployeeException; 
	public Employee searchEmpByName(String empName) throws EmployeeException;
	public Employee searchEmpById(String empId) throws EmployeeException;
	public Employee searchEmpByDept(String dept) throws EmployeeException;
	public Employee searchEmpByGrade(String grade) throws EmployeeException;
	public Employee searchEmpByMS(String ms) throws EmployeeException;
	
}
