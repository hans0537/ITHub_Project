package com.ithub.industry;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class IndustryDAO {

	private SqlSession sqlSession;
	
	public IndustryDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<IndustryDTO> getIndustry() {
		
		List<IndustryDTO> list = sqlSession.selectList("industry.getIndustry");
		
		System.out.println(list);
		
		return list;
	}
	
}
