package com.ithub.servicecenter;

import java.sql.Date;

public class ServiceCenterDTO {
	
	private int scSeq;
	private int scateSeq;
	private String scTitle;
	private String scContent;
	private Date scDate;
	
	public ServiceCenterDTO() {}
	
	public ServiceCenterDTO(int scSeq, int scateSeq, String scTitle, String scContent, Date scDate) {
		super();
		this.scSeq = scSeq;
		this.scateSeq = scateSeq;
		this.scTitle = scTitle;
		this.scContent = scContent;
		this.scDate = scDate;
	}

	public int getScSeq() {
		return scSeq;
	}

	public void setScSeq(int scSeq) {
		this.scSeq = scSeq;
	}

	public int getScateSeq() {
		return scateSeq;
	}

	public void setScateSeq(int scateSeq) {
		this.scateSeq = scateSeq;
	}

	public String getScTitle() {
		return scTitle;
	}

	public void setScTitle(String scTitle) {
		this.scTitle = scTitle;
	}

	public String getScContent() {
		return scContent;
	}

	public void setScContent(String scContent) {
		this.scContent = scContent;
	}

	public Date getScDate() {
		return scDate;
	}

	public void setScDate(Date scDate) {
		this.scDate = scDate;
	}

}
