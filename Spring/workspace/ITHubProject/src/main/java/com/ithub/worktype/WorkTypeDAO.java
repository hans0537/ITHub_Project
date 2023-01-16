package com.ithub.worktype;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class WorkTypeDAO {

	private SqlSession sqlSession;
	
	public WorkTypeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<WorkTypeDTO> selectList() {
		return sqlSession.selectList("worktype.selectList");
	}
}
