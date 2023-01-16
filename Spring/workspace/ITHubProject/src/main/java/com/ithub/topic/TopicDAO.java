package com.ithub.topic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class TopicDAO {
	private SqlSession sqlSession;
	
	public TopicDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<TopicDTO> selectList() {
		return sqlSession.selectList("topic.selectList");
	}
}
