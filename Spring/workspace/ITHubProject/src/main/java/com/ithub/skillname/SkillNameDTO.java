package com.ithub.skillname;

public class SkillNameDTO {

	private int snSeq;
	private String snName;
	
	public SkillNameDTO() {}
	
	public SkillNameDTO(int snSeq, String snName) {
		super();
		this.snSeq = snSeq;
		this.snName = snName;
	}

	public int getSnSeq() {
		return snSeq;
	}

	public void setSnSeq(int snSeq) {
		this.snSeq = snSeq;
	}

	public String getSnName() {
		return snName;
	}

	public void setSnName(String snName) {
		this.snName = snName;
	}
	
}
