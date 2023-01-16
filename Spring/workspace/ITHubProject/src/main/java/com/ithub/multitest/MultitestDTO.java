package com.ithub.multitest;

public class MultitestDTO {

	private int multiSeq;
	private int stSeq;
	private String multiQuestion;
	private String multiAnswer;
	
	public MultitestDTO() {}
	
	public MultitestDTO(int multiSeq, int stSeq, String multiQuestion, String multiAnswer) {
		super();
		this.multiSeq = multiSeq;
		this.stSeq = stSeq;
		this.multiQuestion = multiQuestion;
		this.multiAnswer = multiAnswer;
	}

	public int getMultiSeq() {
		return multiSeq;
	}

	public void setMultiSeq(int multiSeq) {
		this.multiSeq = multiSeq;
	}

	public int getStSeq() {
		return stSeq;
	}

	public void setStSeq(int stSeq) {
		this.stSeq = stSeq;
	}

	public String getMultiQuestion() {
		return multiQuestion;
	}

	public void setMultiQuestion(String multiQuestion) {
		this.multiQuestion = multiQuestion;
	}

	public String getMultiAnswer() {
		return multiAnswer;
	}

	public void setMultiAnswer(String multiAnswer) {
		this.multiAnswer = multiAnswer;
	}
}
