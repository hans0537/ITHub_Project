package com.ithub.skill;

public class SkillDTO {

	private int skillSeq;
	private int mSeq;
	private int snSeq;
	private int stSeq;
	private String stCheck;		// Y: 평가 응시, N: 평가 미응시
	private int stScore;
	
	public SkillDTO() {}
	
	public SkillDTO(int skillSeq, int mSeq, int snSeq, int stSeq, String stCheck, int stScore) {
		super();
		this.skillSeq = skillSeq;
		this.mSeq = mSeq;
		this.snSeq = snSeq;
		this.stSeq = stSeq;
		this.stCheck = stCheck;
		this.stScore = stScore;
	}

	public int getSkillSeq() {
		return skillSeq;
	}

	public void setSkillSeq(int skillSeq) {
		this.skillSeq = skillSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getSnSeq() {
		return snSeq;
	}

	public void setSnSeq(int snSeq) {
		this.snSeq = snSeq;
	}

	public int getStSeq() {
		return stSeq;
	}

	public void setStSeq(int stSeq) {
		this.stSeq = stSeq;
	}

	public String getStCheck() {
		return stCheck;
	}

	public void setStCheck(String stCheck) {
		this.stCheck = stCheck;
	}

	public int getStScore() {
		return stScore;
	}

	public void setStScore(int stScore) {
		this.stScore = stScore;
	}
	
}
