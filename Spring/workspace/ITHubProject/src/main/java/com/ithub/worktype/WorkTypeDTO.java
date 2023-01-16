package com.ithub.worktype;

public class WorkTypeDTO {

	private int wtypeSeq;
	private String wtypeName;
	
	public WorkTypeDTO() {}
	
	public WorkTypeDTO(int wtypeSeq, String wtypeName) {
		super();
		this.wtypeSeq = wtypeSeq;
		this.wtypeName = wtypeName;
	}

	public int getWtypeSeq() {
		return wtypeSeq;
	}

	public void setWtypeSeq(int wtypeSeq) {
		this.wtypeSeq = wtypeSeq;
	}

	public String getWtypeName() {
		return wtypeName;
	}

	public void setWtypeName(String wtypeName) {
		this.wtypeName = wtypeName;
	}
	
}
