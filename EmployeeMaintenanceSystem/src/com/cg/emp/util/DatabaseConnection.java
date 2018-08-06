package com.cg.emp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	public static Connection getConnection() {
		String driver="";
		String url="";
		String username="";
		String pwd="";
		Connection connection=null;
		try {
			FileInputStream fi= new FileInputStream("./resources/dbConfig.properties");
			Properties prop=new Properties();
			prop.load(fi);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			pwd=prop.getProperty("pwd");
			Class.forName(driver);
			connection=DriverManager.getConnection(url, username,pwd);
			System.out.println("Connected with DB");
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver class not Loaded");
		}
		
		catch (SQLException e) {
			System.out.println("Enable to connect with DB..");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void main(String[] args) {
		getConnection();
	}
}
