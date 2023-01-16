package com.ithub.city;

public class CityDTO{
	
	private int ciSeq;
	private int ciCode;
	private String ciName;
	private int cSeq;

	public CityDTO() {}

	public CityDTO(int ciSeq, int ciCode, String ciName, int cSeq) {
		super();
		this.ciSeq = ciSeq;
		this.ciCode = ciCode;
		this.ciName = ciName;
		this.cSeq = cSeq;
	}

	public int getCiSeq() {
		return ciSeq;
	}

	public void setCiSeq(int ciSeq) {
		this.ciSeq = ciSeq;
	}

	public int getCiCode() {
		return ciCode;
	}

	public void setCiCode(int ciCode) {
		this.ciCode = ciCode;
	}

	public String getCiName() {
		return ciName;
	}

	public void setCiName(String ciName) {
		this.ciName = ciName;
	}

	public int getcSeq() {
		return cSeq;
	}

	public void setcSeq(int cSeq) {
		this.cSeq = cSeq;
	}
	
	
	
}
