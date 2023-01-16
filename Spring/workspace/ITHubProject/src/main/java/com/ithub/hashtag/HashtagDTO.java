package com.ithub.hashtag;

public class HashtagDTO {

	private int htagSeq;
	private String htagName;
	
	public HashtagDTO() {}
	
	public HashtagDTO(int htagSeq, String htagName) {
		super();
		this.htagSeq = htagSeq;
		this.htagName = htagName;
	}

	public int getHtagSeq() {
		return htagSeq;
	}

	public void setHtagSeq(int htagSeq) {
		this.htagSeq = htagSeq;
	}

	public String getHtagName() {
		return htagName;
	}

	public void setHtagName(String htagName) {
		this.htagName = htagName;
	}
	
}
