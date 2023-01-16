package com.ithub.website;

public class WebsiteDTO {

	private int wSeq;
	private String wLink;
	private int mSeq;
	private int wtSeq;
	
	public WebsiteDTO() {}
	
	public WebsiteDTO(int wSeq, String wLink, int mSeq, int wtSeq) {
		super();
		this.wSeq = wSeq;
		this.wLink = wLink;
		this.mSeq = mSeq;
		this.wtSeq = wtSeq;
	}

	public int getwSeq() {
		return wSeq;
	}

	public void setwSeq(int wSeq) {
		this.wSeq = wSeq;
	}

	public String getwLink() {
		return wLink;
	}

	public void setwLink(String wLink) {
		this.wLink = wLink;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getWtSeq() {
		return wtSeq;
	}

	public void setWtSeq(int wtSeq) {
		this.wtSeq = wtSeq;
	}
	
}
