package com.cg.emp.dao;

public interface QueryMapper {
	
	public static final String GET_USER="SELECT username,UserPassword,userid FROM User_Master";
	public static final String INSERT_QUERY="INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SEARCH_QUERY = "SELECT * FROM employee where emp_id=? ";
	public static final String INSERTLEAVE_QUERY = "INSERT INTO leave_history VALUES(seq_leave_id.NEXTVAL,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'),?)";
	public static final String LEAVEID_QUERY_SEQUENCE = "SELECT seq_leave_id.CURRVAL FROM DUAL";
	public static final String RETRIEVE_LEAVES_QUERY = "select l.leave_id,l.emp_id,l.leave_balance,l.noofdays_applied,l.date_from,l.date_to,l.status from Leave_History l inner join  Employee e on e.Emp_ID=l.EMP_ID ";
	public static final String LEAVE_SEARCH_QUERY ="select l.leave_id,l.emp_id,l.leave_balance,l.noofdays_applied,l.date_from,l.date_to,l.status,m.leavesleft from Leave_History l inner join  LeaveMaster m on l.Emp_ID=m.EMP_ID where l.emp_id=?";
	public static final String LEAVE_CHECK_QUERY = "select *from leave_history where emp_id=?";
	public static final String LEAVE_APP_QUERY = "update leave_history set status=? where emp_id=?";
	public static final String LEAVE_REJ_QUERY = "update leave_history set status=? where emp_id=?";
	public static final String LEAVE_MASTER_BAL = "update leavemaster set leavesleft=? where emp_id=?";
}
