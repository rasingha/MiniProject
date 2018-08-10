package com.cg.emp.bean;

public class Employee extends LeaveHistory{
	
	private String empId;
	private String empFName;
	private String empLName;
	private String empDOB;
	private String empDOJ;
	private int empDeptId;
	private String empGrade;
	private String empDesign;
	private String empBasic;
	private String empGender;
	private String empMStatus;
	private String empAddress;
	private String empContact;
	private String empMgrId;
	private Department dept_name;
	private String empFullName;
	LeaveHistory lh;
	
	public String getEmpFullName() {
		return empFullName;
	}
	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}
	public LeaveHistory getLh() {
		return lh;
	}
	public void setLh(LeaveHistory lh) {
		this.lh = lh;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public String getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}
	public String getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(String empDOJ) {
		this.empDOJ = empDOJ;
	}
	public int getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}
	public String getEmpGrade() {
		return empGrade;
	}
	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}
	public String getEmpDesign() {
		return empDesign;
	}
	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}
	public String getEmpBasic() {
		return empBasic;
	}
	public void setEmpBasic(String empBasic) {
		this.empBasic = empBasic;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpMStatus() {
		return empMStatus;
	}
	public void setEmpMStatus(String empMStatus) {
		this.empMStatus = empMStatus;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpContact() {
		return empContact;
	}
	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}
	public String getEmpMgrId() {
		return empMgrId;
	}
	public void setEmpMgrId(String empMgrId) {
		this.empMgrId = empMgrId;
	}
	
	
	public Department getDept_name() {
		return dept_name;
	}
	public void setDept_name(Department dept_name) {
		this.dept_name = dept_name;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFName=" + empFName + ", empLName=" + empLName + ", empDOB=" + empDOB
				+ ", empDOJ=" + empDOJ + ", empDeptId=" + empDeptId + ", empGrade=" + empGrade + ", empDesign="
				+ empDesign + ", empBasic=" + empBasic + ", empGender=" + empGender + ", empMStatus=" + empMStatus
				+ ", empAddress=" + empAddress + ", empContact=" + empContact + ", empMgrId=" + empMgrId
				+ ", dept_name=" + dept_name + "]";
	}
	
	
	

}
