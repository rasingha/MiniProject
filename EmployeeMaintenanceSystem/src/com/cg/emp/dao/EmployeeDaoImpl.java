package com.cg.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.util.DatabaseConnection;

public class EmployeeDaoImpl implements IEmployeeDao {

	
	Logger logger=Logger.getRootLogger();
	public EmployeeDaoImpl() {
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	
	Employee emp=null;

	@Override
	public String addEmp() throws EmployeeException {
		
		emp=new Employee();
		Connection connection = DatabaseConnection.getConnection();	
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		int queryResult=0;
		
		return null;
	}

	@Override
	public String modifyEmp() throws EmployeeException{
		
		return null;
	}

	@Override
	public List<Employee> dispEmp(Employee emp) throws EmployeeException {
		
		return null;
	}

	@Override
	public boolean applyLeave() throws EmployeeException{
		
		return false;
	}

	@Override
	public boolean approveLeave() throws EmployeeException {
		
		return false;
	}

	@Override
	public Employee searchEmpByName(String empName) throws EmployeeException{
		
		return null;
	}

	@Override
	public Employee searchEmpById(String empId) throws EmployeeException {
		
		return null;
	}

	@Override
	public Employee searchEmpByDept(String dept) throws EmployeeException {
		
		return null;
	}

	@Override
	public Employee searchEmpByGrade(String grade) throws EmployeeException {
		
		return null;
	}

	@Override
	public Employee searchEmpByMS(String ms) throws EmployeeException{
		
		return null;
	}

}
