package com.ithub.jobpost;

import java.sql.Date;

public class JobPostDTO {

	private int jpostSeq;
	private String jpostName; 
	private int jpostCnt;
	private String jpostExplain;
	private int etypeSeq;
	private int wtypeSeq;
	private int iSeq;
	private int occSeq;
	private int posSeq;
	private int jrankSeq;
	private int pSeq;
	private int mSeq;
	private Date jpostDate;
	private int jpostApply;
	
	private int hisdate;
	
	private String etypeName;
	private String wtypeName;
	private String iName;
	private String occName;
	private String posName;
	private String jrankName;
	
	private String pName;
	private String pPic;
	
	public JobPostDTO() {}
	
	public JobPostDTO(int jpostSeq, String jpostName, int jpostCnt, String jpostExplain, int etypeSeq, int wtypeSeq,
			int iSeq, int occSeq, int posSeq, int jrankSeq, int pSeq, Date jpostDate, String etypeName, String wtypeName,
			String iName, String occName, String posName, String jrankName, int jpostApply, int hisdate, int mSeq, String pName, String pPic) {
		super();
		this.jpostSeq = jpostSeq;
		this.jpostName = jpostName;
		this.jpostCnt = jpostCnt;
		this.jpostExplain = jpostExplain;
		this.etypeSeq = etypeSeq;
		this.wtypeSeq = wtypeSeq;
		this.iSeq = iSeq;
		this.occSeq = occSeq;
		this.posSeq = posSeq;
		this.jrankSeq = jrankSeq;
		this.pSeq = pSeq;
		this.jpostDate = jpostDate;
		this.etypeName = etypeName;
		this.wtypeName = wtypeName;
		this.iName = iName;
		this.occName = occName;
		this.posName = posName;
		this.jrankName = jrankName;
		this.jpostApply = jpostApply;
		this.hisdate = hisdate;
		this.mSeq = mSeq;
		this.pName = pName;
		this.pPic = pPic;
	}
	


	public JobPostDTO(int jpostSeq, String jpostName, int jpostCnt, String jpostExplain, int etypeSeq, int wtypeSeq,
			int iSeq, int occSeq, int posSeq, int jrankSeq, int pSeq, Date jpostDate) {
		super();
		this.jpostSeq = jpostSeq;
		this.jpostName = jpostName;
		this.jpostCnt = jpostCnt;
		this.jpostExplain = jpostExplain;
		this.etypeSeq = etypeSeq;
		this.wtypeSeq = wtypeSeq;
		this.iSeq = iSeq;
		this.occSeq = occSeq;
		this.posSeq = posSeq;
		this.jrankSeq = jrankSeq;
		this.pSeq = pSeq;
		this.jpostDate = jpostDate;
	}

	public int getJpostSeq() {
		return jpostSeq;
	}

	public void setJpostSeq(int jpostSeq) {
		this.jpostSeq = jpostSeq;
	}

	public String getJpostName() {
		return jpostName;
	}

	public void setJpostName(String jpostName) {
		this.jpostName = jpostName;
	}

	public int getJpostCnt() {
		return jpostCnt;
	}

	public void setJpostCnt(int jpostCnt) {
		this.jpostCnt = jpostCnt;
	}

	public String getJpostExplain() {
		return jpostExplain;
	}

	public void setJpostExplain(String jpostExplain) {
		this.jpostExplain = jpostExplain;
	}

	public int getEtypeSeq() {
		return etypeSeq;
	}

	public void setEtypeSeq(int etypeSeq) {
		this.etypeSeq = etypeSeq;
	}

	public int getWtypeSeq() {
		return wtypeSeq;
	}

	public void setWtypeSeq(int wtypeSeq) {
		this.wtypeSeq = wtypeSeq;
	}

	public int getiSeq() {
		return iSeq;
	}

	public void setiSeq(int iSeq) {
		this.iSeq = iSeq;
	}

	public int getOccSeq() {
		return occSeq;
	}

	public void setOccSeq(int occSeq) {
		this.occSeq = occSeq;
	}

	public int getPosSeq() {
		return posSeq;
	}

	public void setPosSeq(int posSeq) {
		this.posSeq = posSeq;
	}

	public int getJrankSeq() {
		return jrankSeq;
	}

	public void setJrankSeq(int jrankSeq) {
		this.jrankSeq = jrankSeq;
	}

	public int getpSeq() {
		return pSeq;
	}

	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}

	public Date getJpostDate() {
		return jpostDate;
	}

	public void setJpostDate(Date jpostDate) {
		this.jpostDate = jpostDate;
	}

	public String getEtypeName() {
		return etypeName;
	}

	public void setEtypeName(String etypeName) {
		this.etypeName = etypeName;
	}

	public String getWtypeName() {
		return wtypeName;
	}

	public void setWtypeName(String wtypeName) {
		this.wtypeName = wtypeName;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getOccName() {
		return occName;
	}

	public void setOccName(String occName) {
		this.occName = occName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getJrankName() {
		return jrankName;
	}

	public void setJrankName(String jrankName) {
		this.jrankName = jrankName;
	}

	public int getJpostApply() {
		return jpostApply;
	}

	public void setJpostApply(int jpostApply) {
		this.jpostApply = jpostApply;
	}

	public int getHisdate() {
		return hisdate;
	}

	public void setHisdate(int hisdate) {
		this.hisdate = hisdate;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpPic() {
		return pPic;
	}

	public void setpPic(String pPic) {
		this.pPic = pPic;
	}
	
}
