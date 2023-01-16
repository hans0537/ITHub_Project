package com.ithub.page;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PageDTO {

	private int pSeq;
	private int mSeq;
	private int pType;
	private String pName;
	private String pPic;
	private String pBackpic;
	private String pInfo;
	private int pEmpcnt;
	private String pText;
	private String pLink;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date pFounddate;
	private String pTel;
	private String pAddr;
	private int pPostcode;
	private int iSeq;
	private int ptypeSeq;
	private int cSeq;
	private int ciSeq;
	
	private MultipartFile logo;
	private MultipartFile backPic;
	
	private int pFollower;
	
	public PageDTO() {}

	public PageDTO(int pSeq, int mSeq, int pType, String pName, String pPic, String pBackpic, String pInfo, int pEmpcnt,
			String pText, String pLink, Date pFounddate, String pTel, String pAddr, int pPostcode, int iSeq,
			int ptypeSeq, int cSeq, int ciSeq, MultipartFile logo, MultipartFile backPic, int pFollower) {
		super();
		this.pSeq = pSeq;
		this.mSeq = mSeq;
		this.pType = pType;
		this.pName = pName;
		this.pPic = pPic;
		this.pBackpic = pBackpic;
		this.pInfo = pInfo;
		this.pEmpcnt = pEmpcnt;
		this.pText = pText;
		this.pLink = pLink;
		this.pFounddate = pFounddate;
		this.pTel = pTel;
		this.pAddr = pAddr;
		this.pPostcode = pPostcode;
		this.iSeq = iSeq;
		this.ptypeSeq = ptypeSeq;
		this.cSeq = cSeq;
		this.ciSeq = ciSeq;
		this.logo = logo;
		this.backPic = backPic;
		this.pFollower = pFollower;
	}



	public PageDTO(int pSeq, int mSeq, int pType, String pName, String pPic, String pBackpic, String pInfo, int pEmpcnt,
			String pText, String pLink, Date pFounddate, String pTel, String pAddr, int pPostcode, int iSeq,
			int ptypeSeq, int cSeq, int ciSeq) {
		super();
		this.pSeq = pSeq;
		this.mSeq = mSeq;
		this.pType = pType;
		this.pName = pName;
		this.pPic = pPic;
		this.pBackpic = pBackpic;
		this.pInfo = pInfo;
		this.pEmpcnt = pEmpcnt;
		this.pText = pText;
		this.pLink = pLink;
		this.pFounddate = pFounddate;
		this.pTel = pTel;
		this.pAddr = pAddr;
		this.pPostcode = pPostcode;
		this.iSeq = iSeq;
		this.ptypeSeq = ptypeSeq;
		this.cSeq = cSeq;
		this.ciSeq = ciSeq;
	}

	public int getpSeq() {
		return pSeq;
	}

	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getpType() {
		return pType;
	}

	public void setpType(int pType) {
		this.pType = pType;
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

	public String getpBackpic() {
		return pBackpic;
	}

	public void setpBackpic(String pBackpic) {
		this.pBackpic = pBackpic;
	}

	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}

	public int getpEmpcnt() {
		return pEmpcnt;
	}

	public void setpEmpcnt(int pEmpcnt) {
		this.pEmpcnt = pEmpcnt;
	}

	public String getpText() {
		return pText;
	}

	public void setpText(String pText) {
		this.pText = pText;
	}

	public String getpLink() {
		return pLink;
	}

	public void setpLink(String pLink) {
		this.pLink = pLink;
	}

	public Date getpFounddate() {
		return pFounddate;
	}

	public void setpFounddate(Date pFounddate) {
		this.pFounddate = pFounddate;
	}

	public String getpTel() {
		return pTel;
	}

	public void setpTel(String pTel) {
		this.pTel = pTel;
	}

	public String getpAddr() {
		return pAddr;
	}

	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}

	public int getpPostcode() {
		return pPostcode;
	}

	public void setpPostcode(int pPostcode) {
		this.pPostcode = pPostcode;
	}

	public int getiSeq() {
		return iSeq;
	}

	public void setiSeq(int iSeq) {
		this.iSeq = iSeq;
	}

	public int getPtypeSeq() {
		return ptypeSeq;
	}

	public void setPtypeSeq(int ptypeSeq) {
		this.ptypeSeq = ptypeSeq;
	}

	public int getcSeq() {
		return cSeq;
	}

	public void setcSeq(int cSeq) {
		this.cSeq = cSeq;
	}

	public int getCiSeq() {
		return ciSeq;
	}

	public void setCiSeq(int ciSeq) {
		this.ciSeq = ciSeq;
	}

	public MultipartFile getLogo() {
		return logo;
	}

	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}

	public MultipartFile getBackPic() {
		return backPic;
	}

	public void setBackPic(MultipartFile backPic) {
		this.backPic = backPic;
	}

	public int getpFollower() {
		return pFollower;
	}

	public void setpFollower(int pFollower) {
		this.pFollower = pFollower;
	}

	
}
