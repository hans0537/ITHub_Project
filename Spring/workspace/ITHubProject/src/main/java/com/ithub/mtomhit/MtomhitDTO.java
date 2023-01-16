package com.ithub.mtomhit;

import java.sql.Date;

public class MtomhitDTO {

	private int mtmhitSeq;
	private int mhitSeq;
	private int mSeq;
	private Date hitDate;
	
	public MtomhitDTO() {}
	
	public MtomhitDTO(int mtmhitSeq, int mhitSeq, int mSeq, Date hitDate) {
		super();
		this.mtmhitSeq = mtmhitSeq;
		this.mhitSeq = mhitSeq;
		this.mSeq = mSeq;
		this.hitDate = hitDate;
	}

	public int getMtmhitSeq() {
		return mtmhitSeq;
	}

	public void setMtmhitSeq(int mtmhitSeq) {
		this.mtmhitSeq = mtmhitSeq;
	}

	public int getMhitSeq() {
		return mhitSeq;
	}

	public void setMhitSeq(int mhitSeq) {
		this.mhitSeq = mhitSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public Date getHitDate() {
		return hitDate;
	}

	public void setHitDate(Date hitDate) {
		this.hitDate = hitDate;
	}

}
