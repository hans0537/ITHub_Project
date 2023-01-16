package com.ithub.qnaanswer;

import org.apache.ibatis.session.SqlSession;

public class QnaanswerDAO {

private SqlSession sqlSession;
	
	public QnaanswerDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
