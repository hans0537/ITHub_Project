package com.ithub.education;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class EducationDAO {

	private SqlSession sqlSession;
	
	public EducationDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(EducationDTO dto) {
		return sqlSession.insert("education.insert", dto);
	}
	
	public List<EducationDTO> myEdu(int mSeq) {
		return sqlSession.selectList("education.myEdu", mSeq);
	}
	
	
}
