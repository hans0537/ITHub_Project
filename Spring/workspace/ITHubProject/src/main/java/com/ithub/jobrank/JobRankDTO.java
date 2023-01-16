package com.ithub.jobrank;

public class JobRankDTO {

	private int jrankSeq;
	private String jrankName;
	private int jrankYear;
	
	public JobRankDTO() {}
	
	public JobRankDTO(int jrankSeq, String jrankName, int jrankYear) {
		super();
		this.jrankSeq = jrankSeq;
		this.jrankName = jrankName;
		this.jrankYear = jrankYear;
	}

	public int getJrankSeq() {
		return jrankSeq;
	}

	public void setJrankSeq(int jrankSeq) {
		this.jrankSeq = jrankSeq;
	}

	public String getJrankName() {
		return jrankName;
	}

	public void setJrankName(String jrankName) {
		this.jrankName = jrankName;
	}

	public int getJrankYear() {
		return jrankYear;
	}

	public void setJrankYear(int jrankYear) {
		this.jrankYear = jrankYear;
	}
	
	
}
