package com.ithub.qnapic;

import org.apache.ibatis.session.SqlSession;

public class QnapicDAO {

	private SqlSession sqlSession;
	
	public QnapicDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
