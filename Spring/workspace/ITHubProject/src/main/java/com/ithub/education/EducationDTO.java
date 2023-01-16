package com.ithub.education;

public class EducationDTO {

	private int eduSeq;
	private int mSeq;
	private int pSeq;
	private String eduDegree;
	private String eduMajor;
	private String eduStart;
	private String eduEnd;
	private String eduCredit;
	private String eduActivity;
	private String eduContent;
	
	private String pName;
	
	public EducationDTO() {}

	public EducationDTO(int eduSeq, int mSeq, int pSeq, String eduDegree, String eduMajor, String eduStart, String eduEnd,
			String eduCredit, String eduActivity, String eduContent, String pName) {
		super();
		this.eduSeq = eduSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.eduDegree = eduDegree;
		this.eduMajor = eduMajor;
		this.eduStart = eduStart;
		this.eduEnd = eduEnd;
		this.eduCredit = eduCredit;
		this.eduActivity = eduActivity;
		this.eduContent = eduContent;
		this.pName = pName;
	}

	public int getEduSeq() {
		return eduSeq;
	}

	public void setEduSeq(int eduSeq) {
		this.eduSeq = eduSeq;
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

	public String getEduDegree() {
		return eduDegree;
	}

	public void setEduDegree(String eduDegree) {
		this.eduDegree = eduDegree;
	}

	public String getEduMajor() {
		return eduMajor;
	}

	public void setEduMajor(String eduMajor) {
		this.eduMajor = eduMajor;
	}

	public String getEduStart() {
		return eduStart;
	}

	public void setEduStart(String eduStart) {
		this.eduStart = eduStart;
	}

	public String getEduEnd() {
		return eduEnd;
	}

	public void setEduEnd(String eduEnd) {
		this.eduEnd = eduEnd;
	}

	public String getEduCredit() {
		return eduCredit;
	}

	public void setEduCredit(String eduCredit) {
		this.eduCredit = eduCredit;
	}

	public String getEduActivity() {
		return eduActivity;
	}

	public void setEduActivity(String eduActivity) {
		this.eduActivity = eduActivity;
	}

	public String getEduContent() {
		return eduContent;
	}

	public void setEduContent(String eduContent) {
		this.eduContent = eduContent;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	
}
