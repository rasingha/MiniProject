package com.cg.emp.dao;

public interface QueryMapper {
	
	public static final String GET_USER="SELECT username,UserPassword,userid FROM User_Master";
	public static final String INSERT_QUERY="INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

}
