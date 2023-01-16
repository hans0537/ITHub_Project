package com.ithub.qnaanswer;

public class QnaanswerDTO {

	private int qanswerSeq;
	private int mqnaSeq;
	private int adminSeq;
	private String qanswerTitle;
	private String qanswerContent;
	
	public QnaanswerDTO() {}
	
	public QnaanswerDTO(int qanswerSeq, int mqnaSeq, int adminSeq, String qanswerTitle, String qanswerContent) {
		super();
		this.qanswerSeq = qanswerSeq;
		this.mqnaSeq = mqnaSeq;
		this.adminSeq = adminSeq;
		this.qanswerTitle = qanswerTitle;
		this.qanswerContent = qanswerContent;
	}

	public int getQanswerSeq() {
		return qanswerSeq;
	}

	public void setQanswerSeq(int qanswerSeq) {
		this.qanswerSeq = qanswerSeq;
	}

	public int getMqnaSeq() {
		return mqnaSeq;
	}

	public void setMqnaSeq(int mqnaSeq) {
		this.mqnaSeq = mqnaSeq;
	}

	public int getAdminSeq() {
		return adminSeq;
	}

	public void setAdminSeq(int adminSeq) {
		this.adminSeq = adminSeq;
	}

	public String getQanswerTitle() {
		return qanswerTitle;
	}

	public void setQanswerTitle(String qanswerTitle) {
		this.qanswerTitle = qanswerTitle;
	}

	public String getQanswerContent() {
		return qanswerContent;
	}

	public void setQanswerContent(String qanswerContent) {
		this.qanswerContent = qanswerContent;
	}
	
}
