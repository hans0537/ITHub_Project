package com.ithub.webtype;

public class WebTypeDTO {

	private int wtSeq;
	private String wtType;
	
	public WebTypeDTO() {}
	
	public WebTypeDTO(int wtSeq, String wtType) {
		super();
		this.wtSeq = wtSeq;
		this.wtType = wtType;
	}

	public int getWtSeq() {
		return wtSeq;
	}

	public void setWtSeq(int wtSeq) {
		this.wtSeq = wtSeq;
	}

	public String getWtType() {
		return wtType;
	}

	public void setWtType(String wtType) {
		this.wtType = wtType;
	}
	
}
