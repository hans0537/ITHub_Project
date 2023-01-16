package com.ithub.memfollow;

import java.sql.Date;

public class MemFollowDTO {

	private int mfSeq;
	private int followSeq;
	private int followerSeq;
	private Date mfDate;
	
	public MemFollowDTO() {}
	
	public MemFollowDTO(int mfSeq, int followSeq, int followerSeq, Date mfDate) {
		super();
		this.mfSeq = mfSeq;
		this.followSeq = followSeq;
		this.followerSeq = followerSeq;
		this.mfDate = mfDate;
	}

	public int getMfSeq() {
		return mfSeq;
	}

	public void setMfSeq(int mfSeq) {
		this.mfSeq = mfSeq;
	}

	public int getFollowSeq() {
		return followSeq;
	}

	public void setFollowSeq(int followSeq) {
		this.followSeq = followSeq;
	}

	public int getFollowerSeq() {
		return followerSeq;
	}

	public void setFollowerSeq(int followerSeq) {
		this.followerSeq = followerSeq;
	}

	public Date getMfDate() {
		return mfDate;
	}

	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}
}
