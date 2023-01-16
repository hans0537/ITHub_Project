package com.ithub.occupation;

public class OccupationDTO {

	private int occSeq;
	private String occName;
	
	public OccupationDTO() {}
	
	public OccupationDTO(int occSeq, String occName) {
		super();
		this.occSeq = occSeq;
		this.occName = occName;
	}

	public int getOccSeq() {
		return occSeq;
	}

	public void setOccSeq(int occSeq) {
		this.occSeq = occSeq;
	}

	public String getOccName() {
		return occName;
	}

	public void setOccName(String occName) {
		this.occName = occName;
	}
	
	
}
