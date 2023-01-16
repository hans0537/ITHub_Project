package com.ithub.career;

public class CareerDTO {
	private int carSeq;
	private int mSeq;
	private int pSeq;
	private int posSeq;
	private int etypeSeq;
	private String carStart;
	private String carEnd;
	private int iSeq;
	private String carContent;
	
	private String posName;
	private String etypeName;
	
	public CareerDTO() {}
	
	public CareerDTO(int carSeq, int mSeq, int pSeq, int posSeq, int etypeSeq, String carStart, String carEnd, int iSeq,
			String carContent, String posName, String etypeName) {
		super();
		this.carSeq = carSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.posSeq = posSeq;
		this.etypeSeq = etypeSeq;
		this.carStart = carStart;
		this.carEnd = carEnd;
		this.iSeq = iSeq;
		this.carContent = carContent;
		this.posName = posName;
		this.etypeName = etypeName;
	}

	public int getCarSeq() {
		return carSeq;
	}

	public void setCarSeq(int carSeq) {
		this.carSeq = carSeq;
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

	public int getPosSeq() {
		return posSeq;
	}

	public void setPosSeq(int posSeq) {
		this.posSeq = posSeq;
	}

	public int getEtypeSeq() {
		return etypeSeq;
	}

	public void setEtypeSeq(int etypeSeq) {
		this.etypeSeq = etypeSeq;
	}

	public String getCarStart() {
		return carStart;
	}

	public void setCarStart(String carStart) {
		this.carStart = carStart;
	}

	public String getCarEnd() {
		return carEnd;
	}

	public void setCarEnd(String carEnd) {
		this.carEnd = carEnd;
	}

	public int getiSeq() {
		return iSeq;
	}

	public void setiSeq(int iSeq) {
		this.iSeq = iSeq;
	}

	public String getCarContent() {
		return carContent;
	}

	public void setCarContent(String carContent) {
		this.carContent = carContent;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getEtypeName() {
		return etypeName;
	}

	public void setEtypeName(String etypeName) {
		this.etypeName = etypeName;
	}
	
	
	
}














































