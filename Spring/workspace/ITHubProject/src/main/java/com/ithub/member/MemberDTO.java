package com.ithub.member;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {

	private int mSeq;
	private String mEmail;
	private String mPw;
	private String mFirstname;
	private String mLastname;
	private String mHp;
	private String mIntro;
	private String mPic;
	private String mBackpic;
	private String mOpen;
	private String mLink;
	private String mHashtag;
	private int cSeq;
	private int ciSeq;
	
	private MultipartFile filePic;
	private MultipartFile fileBackPic;
	
	private int following;
	private int follower;
	
	public MemberDTO() {}
	
	public MemberDTO(int mSeq, String mEmail, String mPw, String mFirstname, String mLastname, String mHp,
			String mIntro, String mPic, String mBackpic, String mOpen, String mLink, String mHashtag, int cSeq,
			int ciSeq, MultipartFile filePic, MultipartFile fileBackPic) {
		super();
		this.mSeq = mSeq;
		this.mEmail = mEmail;
		this.mPw = mPw;
		this.mFirstname = mFirstname;
		this.mLastname = mLastname;
		this.mHp = mHp;
		this.mIntro = mIntro;
		this.mPic = mPic;
		this.mBackpic = mBackpic;
		this.mOpen = mOpen;
		this.mLink = mLink;
		this.mHashtag = mHashtag;
		this.cSeq = cSeq;
		this.ciSeq = ciSeq;
		this.filePic = filePic;
		this.fileBackPic = fileBackPic;
	}
	
	public MemberDTO(int mSeq, String mEmail, String mPw, String mFirstname, String mLastname, String mHp,
			String mIntro, String mPic, String mBackpic, String mOpen, String mLink, String mHashtag, int cSeq,
			int ciSeq, MultipartFile filePic, MultipartFile fileBackPic, int following, int follower) {
		super();
		this.mSeq = mSeq;
		this.mEmail = mEmail;
		this.mPw = mPw;
		this.mFirstname = mFirstname;
		this.mLastname = mLastname;
		this.mHp = mHp;
		this.mIntro = mIntro;
		this.mPic = mPic;
		this.mBackpic = mBackpic;
		this.mOpen = mOpen;
		this.mLink = mLink;
		this.mHashtag = mHashtag;
		this.cSeq = cSeq;
		this.ciSeq = ciSeq;
		this.filePic = filePic;
		this.fileBackPic = fileBackPic;
		this.following = following;
		this.follower = follower;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
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

	public String getmHp() {
		return mHp;
	}

	public void setmHp(String mHp) {
		this.mHp = mHp;
	}

	public String getmIntro() {
		return mIntro;
	}

	public void setmIntro(String mIntro) {
		this.mIntro = mIntro;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}

	public String getmBackpic() {
		return mBackpic;
	}

	public void setmBackpic(String mBackpic) {
		this.mBackpic = mBackpic;
	}

	public String getmOpen() {
		return mOpen;
	}

	public void setmOpen(String mOpen) {
		this.mOpen = mOpen;
	}

	public String getmLink() {
		return mLink;
	}

	public void setmLink(String mLink) {
		this.mLink = mLink;
	}

	public String getmHashtag() {
		return mHashtag;
	}

	public void setmHashtag(String mHashtag) {
		this.mHashtag = mHashtag;
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

	public MultipartFile getFilePic() {
		return filePic;
	}

	public void setFilePic(MultipartFile filePic) {
		this.filePic = filePic;
	}

	public MultipartFile getFileBackPic() {
		return fileBackPic;
	}

	public void setFileBackPic(MultipartFile fileBackPic) {
		this.fileBackPic = fileBackPic;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}
}
