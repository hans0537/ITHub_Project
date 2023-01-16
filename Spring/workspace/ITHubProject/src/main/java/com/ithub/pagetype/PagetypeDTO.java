package com.ithub.pagetype;

public class PagetypeDTO {

	private int ptypeSeq;
	private String ptypeName;
	
	public PagetypeDTO() {}
	
	public PagetypeDTO(int ptypeSeq, String ptypeName) {
		super();
		this.ptypeSeq = ptypeSeq;
		this.ptypeName = ptypeName;
	}

	public int getPtypeSeq() {
		return ptypeSeq;
	}

	public void setPtypeSeq(int ptypeSeq) {
		this.ptypeSeq = ptypeSeq;
	}

	public String getPtypeName() {
		return ptypeName;
	}

	public void setPtypeName(String ptypeName) {
		this.ptypeName = ptypeName;
	}

}
