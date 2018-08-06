package com.cg.emp.bean;

public class LeaveHistory {
	private int leave_id;
	private int emp_id;
	private int leave_bal;
	private int noofdays_App;
	private String date_from;
	private String date_to;
	private String status;
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getLeave_bal() {
		return leave_bal;
	}
	public void setLeave_bal(int leave_bal) {
		this.leave_bal = leave_bal;
	}
	public int getNoofdays_App() {
		return noofdays_App;
	}
	public void setNoofdays_App(int noofdays_App) {
		this.noofdays_App = noofdays_App;
	}
	public String getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}
	public String getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveHistory [leave_id=" + leave_id + ", emp_id=" + emp_id + ", leave_bal=" + leave_bal
				+ ", noofdays_App=" + noofdays_App + ", date_from=" + date_from + ", date_to=" + date_to + ", status="
				+ status + "]";
	}
	
}
