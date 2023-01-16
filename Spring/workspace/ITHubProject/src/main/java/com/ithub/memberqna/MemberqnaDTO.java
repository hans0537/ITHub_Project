package com.ithub.memberqna;

public class MemberqnaDTO {

	private int mqnaSeq;
	private int mSeq;
	private int scSeq;
	private String mqnaTitle;
	private String mqnaContent;
	private int mqnaState;
	
	private String scTitle;
	
	private String mLastname;
	private String mFirstname;
	private String mPic;
	
	public MemberqnaDTO() {}
	
	public MemberqnaDTO(int mqnaSeq, int mSeq, int scSeq, String mqnaTitle, String mqnaContent, int mqnaState, String scTitle,
			String mLastname, String mFirstname, String mPic) {
		super();
		this.mqnaSeq = mqnaSeq;
		this.mSeq = mSeq;
		this.scSeq = scSeq;
		this.mqnaTitle = mqnaTitle;
		this.mqnaContent = mqnaContent;
		this.mqnaState = mqnaState;
		this.scTitle = scTitle;
		this.mLastname = mLastname;
		this.mFirstname = mFirstname;
		this.mPic = mPic;
	}

	public int getMqnaSeq() {
		return mqnaSeq;
	}

	public void setMqnaSeq(int mqnaSeq) {
		this.mqnaSeq = mqnaSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getScSeq() {
		return scSeq;
	}

	public void setScSeq(int scSeq) {
		this.scSeq = scSeq;
	}

	public String getMqnaTitle() {
		return mqnaTitle;
	}

	public void setMqnaTitle(String mqnaTitle) {
		this.mqnaTitle = mqnaTitle;
	}

	public String getMqnaContent() {
		return mqnaContent;
	}

	public void setMqnaContent(String mqnaContent) {
		this.mqnaContent = mqnaContent;
	}

	public int getMqnaState() {
		return mqnaState;
	}

	public void setMqnaState(int mqnaState) {
		this.mqnaState = mqnaState;
	}

	public String getScTitle() {
		return scTitle;
	}

	public void setScTitle(String scTitle) {
		this.scTitle = scTitle;
	}

	public String getmLastname() {
		return mLastname;
	}

	public void setmLastname(String mLastname) {
		this.mLastname = mLastname;
	}

	public String getmFirstname() {
		return mFirstname;
	}

	public void setmFirstname(String mFirstname) {
		this.mFirstname = mFirstname;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}
	
}
