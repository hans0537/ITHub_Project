package com.ithub.career;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CareerDAO {

	private SqlSession sqlSession;
	
	public CareerDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(CareerDTO dto) {
		return sqlSession.insert("career.insert",dto);
	}
	
	public List<CareerDTO> selectList() {
		return sqlSession.selectList("career.selectList");
	}
	
	public List<CareerDTO> myCareer(int mSeq) {
		return sqlSession.selectList("career.myCareer", mSeq);
	}
	
	public int delete(CareerDTO dto) {
		return sqlSession.delete("career.delete",dto);
	}
}
