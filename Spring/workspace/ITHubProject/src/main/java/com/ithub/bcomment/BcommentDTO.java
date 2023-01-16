package com.ithub.bcomment;

import java.sql.Date;

public class BcommentDTO {
	
	private int bcSeq;
	private int boardSeq;
	private int mSeq;
	private int pSeq;
	private String bcContent;
	private Date bcDate;
	private int groupno;
	private int orderno;
	private int depthno;
	
	private String mFirstname;
	private String mLastname;
	private String mPic;
	private String bcDateS;
	
	public BcommentDTO() {}
	
	public BcommentDTO(int bcSeq, int boardSeq, int mSeq, int pSeq, String bcContent, Date bcDate, int groupno,
			int orderno, int depthno, String mFirstname, String mLastname, String mPic, String bcDateS) {
		super();
		this.bcSeq = bcSeq;
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.bcContent = bcContent;
		this.bcDate = bcDate;
		this.groupno = groupno;
		this.orderno = orderno;
		this.depthno = depthno;
		this.mFirstname = mFirstname;
		this.mLastname = mLastname;
		this.mPic = mPic;
		this.bcDateS = bcDateS;
	}

	public BcommentDTO(int bcSeq, int boardSeq, int mSeq, int pSeq, String bcContent, Date bcDate, int groupno,
			int orderno, int depthno) {
		super();
		this.bcSeq = bcSeq;
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.bcContent = bcContent;
		this.bcDate = bcDate;
		this.groupno = groupno;
		this.orderno = orderno;
		this.depthno = depthno;
	}

	public int getBcSeq() {
		return bcSeq;
	}

	public void setBcSeq(int bcSeq) {
		this.bcSeq = bcSeq;
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

	public String getBcContent() {
		return bcContent;
	}

	public void setBcContent(String bcContent) {
		this.bcContent = bcContent;
	}

	public Date getBcDate() {
		return bcDate;
	}

	public void setBcDate(Date bcDate) {
		this.bcDate = bcDate;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getDepthno() {
		return depthno;
	}

	public void setDepthno(int depthno) {
		this.depthno = depthno;
	}

	public String getmFirstname() {
		return mFirstname;
	}

	public void setmFirstname(String mFirstname) {
		this.mFirstname = mFirstname;
	}

	public String getmLastname() {
		return mLastname;
	}

	public void setmLastname(String mLastname) {
		this.mLastname = mLastname;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}

	public String getBcDateS() {
		return bcDateS;
	}

	public void setBcDateS(String bcDateS) {
		this.bcDateS = bcDateS;
	}
	
}
