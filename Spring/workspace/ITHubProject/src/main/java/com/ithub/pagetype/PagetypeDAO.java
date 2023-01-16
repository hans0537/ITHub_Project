package com.ithub.pagetype;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PagetypeDAO {

	private SqlSession sqlSession;
	
	public PagetypeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<PagetypeDTO> getPagetype() {
		
		List<PagetypeDTO> list = sqlSession.selectList("pagetype.getPagetype");
		
		System.out.println(list);
		
		return list;
	}
	
}
