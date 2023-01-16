package com.ithub.ptomhit;

import java.sql.Date;

public class PtomhitDTO {

	private int ptmhitSeq;
	private int mSeq;
	private int pSeq;
	private Date phitDate;
	
	public PtomhitDTO() {}
	
	public PtomhitDTO(int ptmhitSeq, int mSeq, int pSeq, Date phitDate) {
		super();
		this.ptmhitSeq = ptmhitSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.phitDate = phitDate;
	}

	public int getPtmhitSeq() {
		return ptmhitSeq;
	}

	public void setPtmhitSeq(int ptmhitSeq) {
		this.ptmhitSeq = ptmhitSeq;
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

	public Date getPhitDate() {
		return phitDate;
	}

	public void setPhitDate(Date phitDate) {
		this.phitDate = phitDate;
	}
	
}
