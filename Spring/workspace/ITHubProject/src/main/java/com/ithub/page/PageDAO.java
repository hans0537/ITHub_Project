package com.ithub.page;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PageDAO {

	private SqlSession sqlSession;
	
	public PageDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(PageDTO dto) {
		return sqlSession.insert("page.insert",dto);
	}
	
	public List<PageDTO> getPage(int mSeq) {
		List<PageDTO> list = sqlSession.selectList("page.getPage",mSeq);
		return list;
	}
	
	public PageDTO selectOne(int pSeq) {
		return sqlSession.selectOne("page.selectOne", pSeq);
	}

	public PageDTO selectOne(PageDTO pdto) {
		return sqlSession.selectOne("page.selectOne1", pdto);
	}
	
	public int updateText(PageDTO dto) {
		return sqlSession.update("page.updateText", dto);
	}
	
	public int updateFound(PageDTO dto) {
		return sqlSession.update("page.updateFound", dto);
	}
	
	public int updateEmpcnt(PageDTO dto) {
		return sqlSession.update("page.updateEmpcnt", dto);
	}
	
	public int updateAddr(PageDTO dto) {
		return sqlSession.update("page.updateAddr", dto);
	}
	
	public int pPicUpdate(PageDTO dto) {
		return sqlSession.update("page.pPicUpdate", dto);
	}

	public int pBackpicUpdate(PageDTO dto) {
		return sqlSession.update("page.pBackpicUpdate", dto);
	}
	
	public List<PageDTO> pTypeList(Map<String, Integer> map) {
		return sqlSession.selectList("page.pTypeList", map);
	}

	public List<PageDTO> pTypeAll(int pType) {
		return sqlSession.selectList("page.pTypeAll", pType);
	}
	
	public int update(PageDTO dto) {
		return sqlSession.update("page.update", dto);
	}
}
