package com.cg.emp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.emp.exception.EmployeeException;

public class DatabaseConnection {

	public static Connection getConnection() throws EmployeeException {
		
		String driver="";
		String url="";
		String username="";
		String pwd="";
		Connection connection=null;
		try 
		{
			FileInputStream fin=new FileInputStream("resources\\dbConfig.properties");
			Properties prop=new Properties();
			prop.load(fin);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			pwd=prop.getProperty("pwd");
			Class.forName(driver);
			connection=DriverManager.getConnection(url, username, pwd);
		} 
		catch (ClassNotFoundException e)
		{
			throw new EmployeeException("Technical Error");
		} 
		catch (SQLException e) 
		{
			throw new EmployeeException("Technical Error");
		} 
		catch (IOException e) 
		{
			throw new EmployeeException(" Could not read the database details from properties file ");
		}
		return connection;
	}

}