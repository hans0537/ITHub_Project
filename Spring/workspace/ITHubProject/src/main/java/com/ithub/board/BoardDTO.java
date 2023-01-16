package com.ithub.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	
	private int boardSeq;
	private int mSeq;
	private int pSeq;
	private String boardContent;
	private String boardFile;
	private String boardFilename;
	private int eventSeq;
	private int jpostSeq;
	private int boardHit;
	private Date boardDate;
	private int boardOpen;
	private int boardPossible;
	private int boardUpdatecheck;
	
	private MultipartFile file;
	
	private String mEmail;
	private String mFirstname;
	private String mLastname;
	private String mPic;
	
	private String pPic;
	private String pName;
	
	private int bcCount;
	private int likeCount;
	
	
	public BoardDTO() {}
	
	
	public BoardDTO(int boardSeq, int mSeq, int pSeq, String boardContent, String boardFile, String boardFilename,
			int eventSeq, int jpostSeq, int boardHit, Date boardDate, int boardOpen, int boardPossible,
			int boardUpdatecheck, MultipartFile file, String mEmail, String mFirstname, String mLastname, String mPic,
			String pPic, String pName, int bcCount, int likeCount) {
		super();
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.boardContent = boardContent;
		this.boardFile = boardFile;
		this.boardFilename = boardFilename;
		this.eventSeq = eventSeq;
		this.jpostSeq = jpostSeq;
		this.boardHit = boardHit;
		this.boardDate = boardDate;
		this.boardOpen = boardOpen;
		this.boardPossible = boardPossible;
		this.boardUpdatecheck = boardUpdatecheck;
		this.file = file;
		this.mEmail = mEmail;
		this.mFirstname = mFirstname;
		this.mLastname = mLastname;
		this.mPic = mPic;
		this.pPic = pPic;
		this.pName = pName;
		this.bcCount = bcCount;
		this.likeCount = likeCount;
	}


	public BoardDTO(int boardSeq, int mSeq, int pSeq, String boardContent, String boardFile, String boardFilename,
			int eventSeq, int jpostSeq, int boardHit, Date boardDate, int boardOpen, int boardPossible,
			int boardUpdatecheck, MultipartFile photo, String mEmail, String mFirstname, String mLastname) {
		super();
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.boardContent = boardContent;
		this.boardFile = boardFile;
		this.boardFilename = boardFilename;
		this.eventSeq = eventSeq;
		this.jpostSeq = jpostSeq;
		this.boardHit = boardHit;
		this.boardDate = boardDate;
		this.boardOpen = boardOpen;
		this.boardPossible = boardPossible;
		this.boardUpdatecheck = boardUpdatecheck;
		this.mEmail = mEmail;
		this.mFirstname = mFirstname;
		this.mLastname = mLastname;
	}


	public BoardDTO(int boardSeq, int mSeq, int pSeq, String boardContent, String boardFile, String boardFilename,
			int eventSeq, int jpostSeq, int boardHit, Date boardDate, int boardOpen, int boardPossible,
			int boardUpdatecheck) {
		super();
		this.boardSeq = boardSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.boardContent = boardContent;
		this.boardFile = boardFile;
		this.boardFilename = boardFilename;
		this.eventSeq = eventSeq;
		this.jpostSeq = jpostSeq;
		this.boardHit = boardHit;
		this.boardDate = boardDate;
		this.boardOpen = boardOpen;
		this.boardPossible = boardPossible;
		this.boardUpdatecheck = boardUpdatecheck;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
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

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardFile() {
		return boardFile;
	}

	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}

	public String getBoardFilename() {
		return boardFilename;
	}

	public void setBoardFilename(String boardFilename) {
		this.boardFilename = boardFilename;
	}

	public int getEventSeq() {
		return eventSeq;
	}

	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}

	public int getJpostSeq() {
		return jpostSeq;
	}

	public void setJpostSeq(int jpostSeq) {
		this.jpostSeq = jpostSeq;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardOpen() {
		return boardOpen;
	}

	public void setBoardOpen(int boardOpen) {
		this.boardOpen = boardOpen;
	}

	public int getBoardPossible() {
		return boardPossible;
	}

	public void setBoardPossible(int boardPossible) {
		this.boardPossible = boardPossible;
	}

	public int getBoardUpdatecheck() {
		return boardUpdatecheck;
	}

	public void setBoardUpdatecheck(int boardUpdatecheck) {
		this.boardUpdatecheck = boardUpdatecheck;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmFirstname() {
		return mFirstname;
	}

	public void setmFirstname(String mFirstname) {
		this.mFirstname = mFirstname;
	}

	public String getmLastname() {
		return mLastname;
	}

	public void setmLastname(String mLastname) {
		this.mLastname = mLastname;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}

	public String getpPic() {
		return pPic;
	}

	public void setpPic(String pPic) {
		this.pPic = pPic;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getBcCount() {
		return bcCount;
	}


	public void setBcCount(int bcCount) {
		this.bcCount = bcCount;
	}


	public int getLikeCount() {
		return likeCount;
	}


	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
	

}
