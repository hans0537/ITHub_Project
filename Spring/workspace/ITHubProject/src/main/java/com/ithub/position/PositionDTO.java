package com.ithub.position;

public class PositionDTO {

	private int posSeq;
	private String posName;
	
	public PositionDTO() {}
	
	public PositionDTO(int posSeq, String posName) {
		super();
		this.posSeq = posSeq;
		this.posName = posName;
	}

	public int getPosSeq() {
		return posSeq;
	}

	public void setPosSeq(int posSeq) {
		this.posSeq = posSeq;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
	
}
