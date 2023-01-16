package com.ithub.emptype;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpTypeDAO {

	private SqlSession sqlSession;
	
	public EmpTypeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<EmpTypeDTO> selectList() {
		return sqlSession.selectList("emptype.selectList");
	}
}
