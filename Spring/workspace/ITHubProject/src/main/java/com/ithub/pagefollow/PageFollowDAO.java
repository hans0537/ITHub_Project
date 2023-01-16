package com.ithub.pagefollow;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PageFollowDAO {

	private SqlSession sqlSession;
	
	public PageFollowDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int memFollow(PageFollowDTO dto) {
		return sqlSession.insert("pagefollow.pageFollow", dto);
	}
	
	public int followCnt(int mSeq) {
		return sqlSession.selectOne("pagefollow.followCnt", mSeq);
	}
	
	public int followerCnt(int mSeq) {
		return sqlSession.selectOne("pagefollow.followerCnt", mSeq);
	}
	
	public List<Integer> selectm(int mSeq) {
		return sqlSession.selectList("pagefollow.selectm", mSeq);
	}
	
	public int unFollow(PageFollowDTO dto) {
		return sqlSession.delete("pagefollow.unfollow", dto);
	}
	
}
