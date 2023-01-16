package com.ithub.mestype;

public class MestypeDTO {

	private int mtSeq;
	private String mtType;
	
	public MestypeDTO() {}
	
	public MestypeDTO(int mtSeq, String mtType) {
		super();
		this.mtSeq = mtSeq;
		this.mtType = mtType;
	}

	public int getMtSeq() {
		return mtSeq;
	}

	public void setMtSeq(int mtSeq) {
		this.mtSeq = mtSeq;
	}

	public String getMtType() {
		return mtType;
	}

	public void setMtType(String mtType) {
		this.mtType = mtType;
	}
	
}
