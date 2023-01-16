package com.ithub.topic;

public class TopicDTO {

	private int topicSeq;
	private String topicName;
	
	public TopicDTO() {}
	
	public TopicDTO(int topicSeq, String topicName) {
		super();
		this.topicSeq = topicSeq;
		this.topicName = topicName;
	}

	public int getTopicSeq() {
		return topicSeq;
	}

	public void setTopicSeq(int topicSeq) {
		this.topicSeq = topicSeq;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
