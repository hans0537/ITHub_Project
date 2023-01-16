package com.ithub.jpostsave;

import org.springframework.web.multipart.MultipartFile;

public class JpostSaveDTO {

	private int jpostsaveSeq;
	private int mSeq;
	private int jpostSeq;
	
	private String jpostName;
	private String posName;
	private String wtypeName;
	
	private String pName;
	private String pPic;
	
	private String fileSave;
	private MultipartFile file;
	
	public JpostSaveDTO() {}
	
	public JpostSaveDTO(int jpostsaveSeq, int mSeq, int jpostSeq, String fileSave, MultipartFile file) {
		super();
		this.jpostsaveSeq = jpostsaveSeq;
		this.mSeq = mSeq;
		this.jpostSeq = jpostSeq;
		this.fileSave = fileSave;
		this.file = file;
	}


	public JpostSaveDTO(int jpostsaveSeq, int mSeq, int jpostSeq, String jpostName, String posName, String wtypeName,
			String pName, String pPic, String fileSave, MultipartFile file) {
		super();
		this.jpostsaveSeq = jpostsaveSeq;
		this.mSeq = mSeq;
		this.jpostSeq = jpostSeq;
		this.jpostName = jpostName;
		this.posName = posName;
		this.wtypeName = wtypeName;
		this.pName = pName;
		this.pPic = pPic;
		this.fileSave = fileSave;
		this.file = file;
	}

	public JpostSaveDTO(int jpostsaveSeq, int mSeq, int jpostSeq) {
		super();
		this.jpostsaveSeq = jpostsaveSeq;
		this.mSeq = mSeq;
		this.jpostSeq = jpostSeq;
	}

	public int getJpostsaveSeq() {
		return jpostsaveSeq;
	}

	public void setJpostsaveSeq(int jpostsaveSeq) {
		this.jpostsaveSeq = jpostsaveSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getJpostSeq() {
		return jpostSeq;
	}

	public void setJpostSeq(int jpostSeq) {
		this.jpostSeq = jpostSeq;
	}

	public String getFileSave() {
		return fileSave;
	}

	public void setFileSave(String fileSave) {
		this.fileSave = fileSave;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getJpostName() {
		return jpostName;
	}

	public void setJpostName(String jpostName) {
		this.jpostName = jpostName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getWtypeName() {
		return wtypeName;
	}

	public void setWtypeName(String wtypeName) {
		this.wtypeName = wtypeName;
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
