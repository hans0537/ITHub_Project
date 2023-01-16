package com.ithub.bclike;

public class BclikeDTO {

	private int bclikeSeq;
	private int mSeq;
	private int bcSeq;
	private int pSeq;
	
	public BclikeDTO() {}
	
	public BclikeDTO(int bclikeSeq, int mSeq, int bcSeq, int pSeq) {
		this.bclikeSeq = bclikeSeq;
		this.mSeq = mSeq;
		this.bcSeq = bcSeq;
		this.pSeq = pSeq;
	}

	public int getBclikeSeq() {
		return bclikeSeq;
	}

	public void setBclikeSeq(int bclikeSeq) {
		this.bclikeSeq = bclikeSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getBcSeq() {
		return bcSeq;
	}

	public void setBcSeq(int bcSeq) {
		this.bcSeq = bcSeq;
	}

	public int getpSeq() {
		return pSeq;
	}

	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}
	
}
