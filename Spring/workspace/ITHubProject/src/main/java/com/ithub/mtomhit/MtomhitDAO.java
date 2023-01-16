package com.ithub.mtomhit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class MtomhitDAO {

	private SqlSession sqlSession;
	
	public MtomhitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MtomhitDTO dto) {
		return sqlSession.insert("mtomhit.insert", dto);
	}
	
	public int hitCheck(MtomhitDTO dto) {
		return sqlSession.selectOne("mtomhit.hitCheck", dto);
	}
	
	public int delete(MtomhitDTO dto) {
		return sqlSession.delete("mtomhit.delete", dto);
	}
	
	public List<MtomhitDTO> hitSelect(int mhitSeq) {
		return sqlSession.selectList("mtomhit.hitSelect", mhitSeq);
	}
	
	
}
