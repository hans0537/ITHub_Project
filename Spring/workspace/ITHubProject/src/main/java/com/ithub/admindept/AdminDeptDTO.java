package com.ithub.admindept;

public class AdminDeptDTO {
	
	private int deptSeq;
	private String deptName;
	
	public AdminDeptDTO() {}
	
	public AdminDeptDTO(int deptSeq, String deptName) {
		super();
		this.deptSeq = deptSeq;
		this.deptName = deptName;
	}

	public int getDeptSeq() {
		return deptSeq;
	}

	public void setDeptSeq(int deptSeq) {
		this.deptSeq = deptSeq;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
