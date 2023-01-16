package com.ithub.ptomhit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class PtomhitDAO {

	private SqlSession sqlSession;
	
	public PtomhitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(PtomhitDTO dto) {
		return sqlSession.insert("ptomhit.insert", dto);
	}
	
	public int hitCheck(PtomhitDTO dto) {
		return sqlSession.selectOne("ptomhit.hitCheck", dto);
	}
	
	public int delete(PtomhitDTO dto) {
		return sqlSession.delete("ptomhit.delete", dto);
	}
	
	public List<PtomhitDTO> hitSelect(int pSeq) {
		return sqlSession.selectList("ptomhit.hitSelect", pSeq);
	}
	
	
}
