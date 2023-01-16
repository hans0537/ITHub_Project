package com.ithub.industry;

public class IndustryDTO {
	
	private int iSeq;
	private String iName;
	private String iContent;
	
	public IndustryDTO() {}
	
	public IndustryDTO(int iSeq, String iName, String iContent) {
		super();
		this.iSeq = iSeq;
		this.iName = iName;
		this.iContent = iContent;
	}

	public int getiSeq() {
		return iSeq;
	}

	public void setiSeq(int iSeq) {
		this.iSeq = iSeq;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}
	
}
