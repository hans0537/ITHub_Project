package com.ithub.servicecategory;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class ServiceCategoryDAO {

	public SqlSession sqlSession;
	
	public ServiceCategoryDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<ServiceCategoryDTO> selectList() {
		return sqlSession.selectList("serviceCategory.selectList");
	}
	
}
