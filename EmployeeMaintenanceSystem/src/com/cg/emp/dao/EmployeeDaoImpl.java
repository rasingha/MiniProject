package com.cg.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.emp.bean.Employee;
import com.cg.emp.bean.LeaveHistory;
import com.cg.emp.bean.User;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.util.DatabaseConnection;

public class EmployeeDaoImpl implements IEmployeeDao {

	
	Logger logger=Logger.getRootLogger();
	public EmployeeDaoImpl() {
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	
	Employee emp=null;
	PreparedStatement ps=null;
	User user=null;
	Connection connection = null;	
	PreparedStatement preparedStatement=null;		
	ResultSet resultSet = null;
	int queryResult=0;

	public HashMap<String, String> getData() throws EmployeeException {
		
		 connection=DatabaseConnection.getConnection();
		 HashMap<String ,String > h=new HashMap<>();
			
			try {
				ps=connection.prepareStatement(QueryMapper.GET_USER);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					h.put(rs.getString("userName"), rs.getString("userPassword"));
				}
				return h;
			} catch (SQLException e) {
				
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
	@Override
	public String applyLeave(Employee emp, LeaveHistory lh) throws EmployeeException{
		connection = DatabaseConnection.getConnection();
		String leave_id=null;
		try
		{	
			preparedStatement=connection.prepareStatement(QueryMapper.SEARCH_QUERY);
			preparedStatement.setString(1,emp.getEmpId());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{

				if(resultSet.getString("emp_id").equals(emp.getEmpId())){
				preparedStatement=connection.prepareStatement(QueryMapper.INSERTLEAVE_QUERY);
				preparedStatement.setString(1,emp.getEmpId());
				preparedStatement.setInt(2,lh.getLeave_bal());
				preparedStatement.setInt(3,lh.getNoofdays_App());
				preparedStatement.setString(4,lh.getDate_from());
				preparedStatement.setString(5,lh.getDate_to());
				preparedStatement.setString(6,"applied");
				queryResult=preparedStatement.executeUpdate();
				
				
				if(queryResult==1) {
				preparedStatement = connection.prepareStatement(QueryMapper.LEAVEID_QUERY_SEQUENCE);
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					logger.info("Leave applied successfully:");
					leave_id=Integer.toString(resultSet.getInt(1));
					return  leave_id;
							
				}
			}
				else {
					logger.error("Insertion failed ");
					throw new EmployeeException("Inserting mobile details failed ");

				}
				}
				else {
					System.out.println("Employee not found");
					logger.error("Employee not found");
					return null;
			}
			
			}
					}
				
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new EmployeeException("Tehnical problem occured refer log"+sqlException.getMessage());
		}

		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new EmployeeException("Error in closing db con");

			}
		}
		return leave_id;
	}

	@Override
	public boolean approveLeave(Employee emp) throws EmployeeException {
		connection = DatabaseConnection.getConnection();
		
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet resultset = null;
		int leave_bal=0;
		int n=0;
		
		try
		{
			if(emp.getStatus().equalsIgnoreCase("approved")) {
				
			ps=connection.prepareStatement(QueryMapper.LEAVE_SEARCH_QUERY);
			ps.setString(1,emp.getEmpId());
			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				leave_bal=resultset.getInt("LeavesLeft");
				leave_bal=leave_bal-resultset.getInt("noofdays_applied");
			}
			ps=connection.prepareStatement(QueryMapper.LEAVE_MASTER_BAL);
			ps.setInt(1,leave_bal);
			ps.setString(2,emp.getEmpId());
			ps.executeUpdate();
			ps1=connection.prepareStatement(QueryMapper.LEAVE_APP_QUERY);
			ps1.setString(1,emp.getStatus());
			ps1.setString(2,emp.getEmpId());
			
			n=ps1.executeUpdate();
			if(n==1) {
			return true;}}
		
		else {
			ps1=connection.prepareStatement(QueryMapper.LEAVE_REJ_QUERY);
			ps1.setString(1,emp.getStatus());
			ps1.setString(2,emp.getEmpId());
			n=ps1.executeUpdate();
			if(n==1) {
			return true;}
		}}
		catch (SQLException sqlException) {
			(logger).error(sqlException.getMessage());
			throw new EmployeeException("Technical problem occured. Refer log"+sqlException.getMessage());
			
		}

		finally
		{
			try 
			{
				
				
				connection.close();
			} 
			catch (SQLException e) 
			{
				logger.error(e.getMessage());
				throw new EmployeeException("Error in closing db con");

			}
		}
		return false;
	}
	@Override
	public List<Employee> getLeavesList(Employee emp) throws EmployeeException {
			
			connection = DatabaseConnection.getConnection();
	int leaveCount = 0;

	PreparedStatement ps=null;
	ResultSet resultset = null;

	List<Employee> leavesList=new ArrayList<Employee>();
	try
	{
		ps=connection.prepareStatement(QueryMapper.RETRIEVE_LEAVES_QUERY);
		resultset=ps.executeQuery();
		while(resultset.next())
		{	
			Employee bean=new Employee();
			bean.setLeave_id(resultset.getInt("leave_id"));
			bean.setEmpId(resultset.getString("emp_id"));
			bean.setLeave_bal(resultset.getInt("leave_balance"));
			bean.setNoofdays_App(resultset.getInt("noofdays_applied"));
			bean.setDate_from(resultset.getString("date_from"));
			bean.setDate_to(resultset.getString("date_to"));
			bean.setStatus(resultset.getString("status"));
			leavesList.add(bean);
			leaveCount++;
		}			
		if( leaveCount == 0)
			return null;
		else
			return leavesList;
	} catch (SQLException sqlException) {
		(logger).error(sqlException.getMessage());
		throw new EmployeeException("Technical problem occured. Refer log");
	}

	finally
	{
		try 
		{
			leavesList=null;
			//resultset.close();
			ps.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			logger.error(e.getMessage());
			throw new EmployeeException("Error in closing db con");

		}
	}
		}

		@Override
		public int LeaveEligibility(Employee emp) throws EmployeeException {
			connection = DatabaseConnection.getConnection();
			
			PreparedStatement ps=null;
			ResultSet resultset = null;
			
			try
			{
				
				ps=connection.prepareStatement(QueryMapper.LEAVE_SEARCH_QUERY);
				ps.setString(1,emp.getEmpId());
				resultset=ps.executeQuery();
				while(resultset.next())
				{	
					System.out.println("\nLeaves left for this Employee: "+resultset.getInt("LeavesLeft"));
					System.out.println("\nNo of Days he/she applied: "+resultset.getInt("noofdays_applied"));
					if(resultset.getInt("LeavesLeft")>resultset.getInt("noofdays_applied")) {
						
						
						return (resultset.getInt("LeavesLeft"));
					}
					
				} 
			}
			catch (SQLException sqlException) {
				(logger).error(sqlException.getMessage());
				throw new EmployeeException("Technical problem occured. Refer log");
			}

			finally
			{
				try 
				{
					ps.close();
					connection.close();
				} 
				catch (SQLException e) 
				{
					logger.error(e.getMessage());
					throw new EmployeeException("Error in closing db con");

				}
			}
			return 0;
	}

		@Override
		public int LeaveCheck(Employee emp) throws EmployeeException {
			connection = DatabaseConnection.getConnection();
			
			PreparedStatement ps=null;
			ResultSet resultset = null;
			
			try
			{
				ps=connection.prepareStatement(QueryMapper.LEAVE_CHECK_QUERY);
				ps.setString(1,emp.getEmpId());
				resultset=ps.executeQuery();
				if(!resultset.next())
				{	
					return 0;
				} 
				
			}
			catch (SQLException sqlException) {
				(logger).error(sqlException.getMessage());
				throw new EmployeeException("Technical problem occured. Refer log");
			}

			finally
			{
				try 
				{
					ps.close();
					connection.close();
				} 
				catch (SQLException e) 
				{
					logger.error(e.getMessage());
					throw new EmployeeException("Error in closing db con");

				}
			}
			return 1;
			
		}


}
