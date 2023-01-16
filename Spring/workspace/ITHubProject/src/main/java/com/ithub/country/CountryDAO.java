package com.ithub.country;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ithub.city.CityDTO;

public class CountryDAO {

	private SqlSession sqlSession;
	
	public CountryDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<CityDTO> getCity() {
		
		List<CityDTO> list = sqlSession.selectList("country.getCity");
		System.out.println(list);
		return list;
	}

	public List<CountryDTO> getCountry() {

		List<CountryDTO> list= sqlSession.selectList("country.getCountry");
		System.out.println(list);
		return list;
	}
}
