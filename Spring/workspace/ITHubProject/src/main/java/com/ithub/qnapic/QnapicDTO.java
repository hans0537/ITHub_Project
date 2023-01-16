package com.ithub.qnapic;

public class QnapicDTO {

	private int qpicSeq;
	private int mqnaSeq;
	private String qpicPic;
	
	public QnapicDTO() {}
	
	public QnapicDTO(int qpicSeq, int mqnaSeq, String qpicPic) {
		super();
		this.qpicSeq = qpicSeq;
		this.mqnaSeq = mqnaSeq;
		this.qpicPic = qpicPic;
	}

	public int getQpicSeq() {
		return qpicSeq;
	}

	public void setQpicSeq(int qpicSeq) {
		this.qpicSeq = qpicSeq;
	}

	public int getMqnaSeq() {
		return mqnaSeq;
	}

	public void setMqnaSeq(int mqnaSeq) {
		this.mqnaSeq = mqnaSeq;
	}

	public String getQpicPic() {
		return qpicPic;
	}

	public void setQpicPic(String qpicPic) {
		this.qpicPic = qpicPic;
	}
	
}
