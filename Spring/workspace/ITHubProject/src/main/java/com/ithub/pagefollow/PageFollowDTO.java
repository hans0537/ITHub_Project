package com.ithub.pagefollow;

import java.sql.Date;

public class PageFollowDTO {

	private int pfSeq;
	private int followmSeq;		// 팔로우를 건 회원 시퀀스
	private int followerpSeq;		// 팔로우를 받은 페이지 시퀀스
	private Date pfDate;
	
	public PageFollowDTO() {}
	
	public PageFollowDTO(int pfSeq, int followmSeq, int followerpSeq, Date pfDate) {
		super();
		this.pfSeq = pfSeq;
		this.followmSeq = followmSeq;
		this.followerpSeq = followerpSeq;
		this.pfDate = pfDate;
	}

	public int getPfSeq() {
		return pfSeq;
	}

	public void setPfSeq(int pfSeq) {
		this.pfSeq = pfSeq;
	}

	public int getFollowmSeq() {
		return followmSeq;
	}

	public void setFollowmSeq(int followmSeq) {
		this.followmSeq = followmSeq;
	}

	public int getFollowerpSeq() {
		return followerpSeq;
	}

	public void setFollowerpSeq(int followerpSeq) {
		this.followerpSeq = followerpSeq;
	}

	public Date getPfDate() {
		return pfDate;
	}

	public void setPfDate(Date pfDate) {
		this.pfDate = pfDate;
	}
	
}
