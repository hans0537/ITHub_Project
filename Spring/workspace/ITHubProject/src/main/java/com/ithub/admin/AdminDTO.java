package com.ithub.admin;

import java.sql.Date;

public class AdminDTO {
	private int adminSeq;
	private int deptSeq;
	private String adminId;
	private String adminPw;
	private String adminName;
	private String adminHp;
	private String adminEmail;
	private Date adminJoindate;
	
	private String deptName;
	
	public AdminDTO() {}

	public AdminDTO(int adminSeq, int deptSeq, String adminId, String adminPw, String adminName, String adminHp,
			String adminEmail, Date adminJoindate, String deptName) {
		super();
		this.adminSeq = adminSeq;
		this.deptSeq = deptSeq;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminName = adminName;
		this.adminHp = adminHp;
		this.adminEmail = adminEmail;
		this.adminJoindate = adminJoindate;
		this.deptName = deptName;
	}

	public int getAdminSeq() {
		return adminSeq;
	}

	public void setAdminSeq(int adminSeq) {
		this.adminSeq = adminSeq;
	}

	public int getDeptSeq() {
		return deptSeq;
	}

	public void setDeptSeq(int deptSeq) {
		this.deptSeq = deptSeq;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminHp() {
		return adminHp;
	}

	public void setAdminHp(String adminHp) {
		this.adminHp = adminHp;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Date getAdminJoindate() {
		return adminJoindate;
	}

	public void setAdminJoindate(Date adminJoindate) {
		this.adminJoindate = adminJoindate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}