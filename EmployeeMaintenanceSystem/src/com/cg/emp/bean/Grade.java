package com.cg.emp.bean;

public class Grade {
	
	private String gradeCode;
	private String descp;
	private int minSal;
	private int maxSal;
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public int getMinSal() {
		return minSal;
	}
	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}
	public int getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}
	@Override
	public String toString() {
		return "Grade [gradeCode=" + gradeCode + ", descp=" + descp + ", minSal=" + minSal + ", maxSal=" + maxSal + "]";
	}
	

}
