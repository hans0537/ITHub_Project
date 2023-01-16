package com.ithub.servicecenter;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class ServiceCenterDAO {
	
	private SqlSession sqlSession;
	
	public ServiceCenterDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<ServiceCenterDTO> selectList() {
		return sqlSession.selectList("serviceCenter.selectList");
	}
}
