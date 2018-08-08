package com.cg.emp.service;

import java.util.HashMap;
import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.User;
import com.cg.emp.dao.EmployeeDaoImpl;
import com.cg.emp.dao.IEmployeeDao;
import com.cg.emp.exception.EmployeeException;

public class EmployeeServImpl implements IEmployeeServ {
	
	IEmployeeDao empDao=null;
	
	public boolean isValid(User user) throws EmployeeException {
		
		IEmployeeDao iEmployeeDao=new EmployeeDaoImpl();
		HashMap<String, String> h1=iEmployeeDao.getData();
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

	
	public boolean applyLeave() throws EmployeeException{
		empDao=new EmployeeDaoImpl();
		return empDao.applyLeave();
	}

	
	public boolean approveLeave() throws EmployeeException {
		empDao=new EmployeeDaoImpl();
		return empDao.approveLeave();
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

	

}
