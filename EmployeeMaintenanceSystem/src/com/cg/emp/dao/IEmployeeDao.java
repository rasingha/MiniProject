package com.cg.emp.dao;

import java.util.HashMap;
import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.*;

public interface IEmployeeDao {
	
	public HashMap<String, String> getData() throws EmployeeException;
	public String addEmp() throws EmployeeException;
	public String modifyEmp() throws EmployeeException;
	public List<Employee> dispEmp(Employee emp) throws EmployeeException;
	public boolean applyLeave() throws EmployeeException;
	public boolean approveLeave() throws EmployeeException; 
	public List<Employee> searchEmpByFName(String empFName) throws EmployeeException;
	public List<Employee> searchEmpByLName(String empLName) throws EmployeeException;
	public Employee searchEmpById(String empId) throws EmployeeException;
	public Employee searchEmpByDept(String dept) throws EmployeeException;
	public Employee searchEmpByGrade(String grade) throws EmployeeException;
	public Employee searchEmpByMS(String ms) throws EmployeeException;
}
