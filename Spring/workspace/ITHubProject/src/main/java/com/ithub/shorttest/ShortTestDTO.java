package com.ithub.shorttest;

public class ShortTestDTO {

	private int shortSeq;			// 주관식
	private int stSeq;
	private String shortTest;
	private String shortAnswer;
	
	public ShortTestDTO() {}
	
	public ShortTestDTO(int shortSeq, int stSeq, String shortTest, String shortAnswer) {
		super();
		this.shortSeq = shortSeq;
		this.stSeq = stSeq;
		this.shortTest = shortTest;
		this.shortAnswer = shortAnswer;
	}

	public int getShortSeq() {
		return shortSeq;
	}

	public void setShortSeq(int shortSeq) {
		this.shortSeq = shortSeq;
	}

	public int getStSeq() {
		return stSeq;
	}

	public void setStSeq(int stSeq) {
		this.stSeq = stSeq;
	}

	public String getShortTest() {
		return shortTest;
	}

	public void setShortTest(String shortTest) {
		this.shortTest = shortTest;
	}

	public String getShortAnswer() {
		return shortAnswer;
	}

	public void setShortAnswer(String shortAnswer) {
		this.shortAnswer = shortAnswer;
	}
	
}
