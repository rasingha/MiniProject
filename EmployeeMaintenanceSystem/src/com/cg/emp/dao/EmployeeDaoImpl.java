package com.cg.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.util.DatabaseConnection;

public class EmployeeDaoImpl implements IEmployeeDao {

	
	Logger logger=Logger.getRootLogger();
	public EmployeeDaoImpl() {
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	
	Employee emp=null;
	Connection con=null;
	PreparedStatement ps=null;
	User user=null;
	
	public HashMap<String, String> getData() throws EmployeeException {
		
		 con=DatabaseConnection.getConnection();
		 HashMap<String ,String > h=new HashMap<>();
			
			try {
				ps=con.prepareStatement(QueryMapper.GET_USER);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					h.put(rs.getString("userName"), rs.getString("userPassword"));
				}
				return h;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
			
			
			
		
		
		
	}
	
	@Override
	public String addEmp() throws EmployeeException {
		
		
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
	public List<Employee> searchEmpByFName(String empFName) throws EmployeeException{
		
		return null;
	}
	
	public List<Employee> searchEmpByLName(String empLName) throws EmployeeException{
		
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
