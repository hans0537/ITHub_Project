package com.ithub.memfollow;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class MemFollowDAO {

	private SqlSession sqlSession;
	
	public MemFollowDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int memFollow(MemFollowDTO dto) {
		return sqlSession.insert("memfollow.memFollow", dto);
	}
	
	public int followCnt(int mSeq) {
		return sqlSession.selectOne("memfollow.followCnt", mSeq);
	}
	
	public int followerCnt(int mSeq) {
		return sqlSession.selectOne("memfollow.followerCnt", mSeq);
	}
	
	public List<Integer> mySelect(int mSeq) {
		return sqlSession.selectList("memfollow.myselect", mSeq);
	}
	
	public int unFollow(MemFollowDTO dto) {
		return sqlSession.delete("memfollow.unfollow", dto);
	}

	public List<MemberDTO> followList(int mSeq) {
		return sqlSession.selectList("memfollow.followList", mSeq);
	}
	
	public List<MemberDTO> followerList(int mSeq) {
		return sqlSession.selectList("memfollow.followerList", mSeq);
	}

	public List<PageDTO> pfollowList(int mSeq) {
		return sqlSession.selectList("memfollow.pfollowList", mSeq);
	}
	
	public List<MemberDTO> pfollowerList(int mSeq) {
		return sqlSession.selectList("memfollow.pfollowerList", mSeq);
	}
	
}
