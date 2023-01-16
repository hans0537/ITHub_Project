package com.ithub.position;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class PositionDAO {

	private SqlSession sqlSession;
	
	public PositionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PositionDTO> selectList() {
		return sqlSession.selectList("position.selectList");
	}
}
