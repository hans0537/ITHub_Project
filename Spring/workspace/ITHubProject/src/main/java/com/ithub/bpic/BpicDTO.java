package com.ithub.bpic;

public class BpicDTO {

	private int bpicSeq;
	private int boardSeq;
	private int bpicPic;
	
	public BpicDTO() {}
	
	public BpicDTO(int bpicSeq, int boardSeq, int bpicPic) {
		super();
		this.bpicSeq = bpicSeq;
		this.boardSeq = boardSeq;
		this.bpicPic = bpicPic;
	}

	public int getBpicSeq() {
		return bpicSeq;
	}

	public void setBpicSeq(int bpicSeq) {
		this.bpicSeq = bpicSeq;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public int getBpicPic() {
		return bpicPic;
	}

	public void setBpicPic(int bpicPic) {
		this.bpicPic = bpicPic;
	}
	
}
