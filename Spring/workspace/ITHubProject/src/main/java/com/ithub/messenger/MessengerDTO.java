package com.ithub.messenger;

public class MessengerDTO {

	private int mesSeq;
	private String mesId;
	private int mSeq;
	private int mtSeq;
	
	public MessengerDTO() {}
	
	public MessengerDTO(int mesSeq, String mesId, int mSeq, int mtSeq) {
		super();
		this.mesSeq = mesSeq;
		this.mesId = mesId;
		this.mSeq = mSeq;
		this.mtSeq = mtSeq;
	}

	public int getMesSeq() {
		return mesSeq;
	}

	public void setMesSeq(int mesSeq) {
		this.mesSeq = mesSeq;
	}

	public String getMesId() {
		return mesId;
	}

	public void setMesId(String mesId) {
		this.mesId = mesId;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getMtSeq() {
		return mtSeq;
	}

	public void setMtSeq(int mtSeq) {
		this.mtSeq = mtSeq;
	}

}
