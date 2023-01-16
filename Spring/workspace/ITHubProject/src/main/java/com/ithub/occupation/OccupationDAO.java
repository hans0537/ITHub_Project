package com.ithub.occupation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class OccupationDAO {
	
	private SqlSession sqlSession;
		
	public OccupationDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<OccupationDTO> selectList() {
		return sqlSession.selectList("occupation.selectList");
	}
}
