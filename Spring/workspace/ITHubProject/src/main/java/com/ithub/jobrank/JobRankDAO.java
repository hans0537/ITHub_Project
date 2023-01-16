package com.ithub.jobrank;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class JobRankDAO {

	private SqlSession sqlSession;
	
	public JobRankDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<JobRankDTO> selectList() {
		return sqlSession.selectList("jobrank.selectList");
	}
}
