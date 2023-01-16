package com.ithub.topic;

import java.util.List;


public class TopicService {
	
	public TopicDAO topicDAO;
	
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	
	public List<TopicDTO> selectList() {
		return topicDAO.selectList();
	}

}
