package com.ithub.blike;

public class BlikeDTO {
	
	private int blikeSeq;
	private int boardSeq;
	private int mSeq;
	private int pSeq;
	
	private int check;
	
	public BlikeDTO() {}
	
	
	public BlikeDTO(int blikeSeq, int boardSeq, int mSeq, int pSeq, int check) {
		super();
		this.blikeSeq = blikeSeq;
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.check = check;
	}

	public int getBlikeSeq() {
		return blikeSeq;
	}
	
	public void setBlikeSeq(int blikeSeq) {
		this.blikeSeq = blikeSeq;
	}
	
	public int getBoardSeq() {
		return boardSeq;
	}
	
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	
	public int getmSeq() {
		return mSeq;
	}
	
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	
	public int getpSeq() {
		return pSeq;
	}
	
	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
	
}
