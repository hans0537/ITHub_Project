package com.ithub.emptype;

public class EmpTypeDTO {

	private int etypeSeq;
	private String etypeName;
	
	public EmpTypeDTO() {}
	
	public EmpTypeDTO(int etypeSeq, String etypeName) {
		super();
		this.etypeSeq = etypeSeq;
		this.etypeName = etypeName;
	}

	public int getEtypeSeq() {
		return etypeSeq;
	}

	public void setEtypeSeq(int etypeSeq) {
		this.etypeSeq = etypeSeq;
	}

	public String getEtypeName() {
		return etypeName;
	}

	public void setEtypeName(String etypeName) {
		this.etypeName = etypeName;
	}
	
}
