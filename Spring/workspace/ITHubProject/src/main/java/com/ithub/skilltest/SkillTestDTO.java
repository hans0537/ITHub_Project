package com.ithub.skilltest;

public class SkillTestDTO {
	
	private int stSeq;
	private String stTopic;
	private int stCnt;				// 응시자수
	private String stIntro;			// 기술평가 유의사항
	
	public SkillTestDTO() {}
	
	public SkillTestDTO(int stSeq, String stTopic, int stCnt, String stIntro) {
		super();
		this.stSeq = stSeq;
		this.stTopic = stTopic;
		this.stCnt = stCnt;
		this.stIntro = stIntro;
	}

	public int getStSeq() {
		return stSeq;
	}

	public void setStSeq(int stSeq) {
		this.stSeq = stSeq;
	}

	public String getStTopic() {
		return stTopic;
	}

	public void setStTopic(String stTopic) {
		this.stTopic = stTopic;
	}

	public int getStCnt() {
		return stCnt;
	}

	public void setStCnt(int stCnt) {
		this.stCnt = stCnt;
	}

	public String getStIntro() {
		return stIntro;
	}

	public void setStIntro(String stIntro) {
		this.stIntro = stIntro;
	}
	
}
