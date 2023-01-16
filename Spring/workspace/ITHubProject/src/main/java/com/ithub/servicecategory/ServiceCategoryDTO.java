package com.ithub.servicecategory;

public class ServiceCategoryDTO {

	private int scateSeq;
	private int topicSeq;
	private String scateName;
	
	public ServiceCategoryDTO() {}
	
	public ServiceCategoryDTO(int scateSeq, int topicSeq, String scateName) {
		super();
		this.scateSeq = scateSeq;
		this.topicSeq = topicSeq;
		this.scateName = scateName;
	}

	public int getScateSeq() {
		return scateSeq;
	}

	public void setScateSeq(int scateSeq) {
		this.scateSeq = scateSeq;
	}

	public int getTopicSeq() {
		return topicSeq;
	}

	public void setTopicSeq(int topicSeq) {
		this.topicSeq = topicSeq;
	}

	public String getScateName() {
		return scateName;
	}

	public void setScateName(String scateName) {
		this.scateName = scateName;
	}
	
}
