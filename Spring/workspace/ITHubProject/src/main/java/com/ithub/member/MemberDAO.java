package com.ithub.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {

	private SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MemberDTO dto) {
		int su = 0;
		try {
			su = sqlSession.insert("member.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return su;
	}
	
	public List<MemberDTO> selectAll() {
		return sqlSession.selectList("member.selectAll");
	}
	
	public MemberDTO selectOne(int mSeq) {
		return sqlSession.selectOne("member.selectOne", mSeq);
	}
	
	public String getmEmail(int mSeq) {
		return sqlSession.selectOne("member.getmEmail", mSeq);
	}
	
	public int checkLogin(MemberDTO dto) {
		int no = 0;
		try {
			no = sqlSession.selectOne("member.checkLogin", dto);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return no;
	}
	
	public String getName(int mSeq) {
		return sqlSession.selectOne("member.getName",mSeq);
	}
	
	public String getId(int mSeq) {
		return sqlSession.selectOne("member.getId", mSeq);
	}
	
	public MemberDTO getAll(int mSeq) {
		return sqlSession.selectOne("member.getAll",mSeq);
	}
	
	public int update(MemberDTO dto) {
		return sqlSession.update("member.update", dto);
	}
	
	public int delete(int mSeq) {
		return sqlSession.delete("member.delete",mSeq);
	}
	
	public String findEmail(MemberDTO dto) {
		return sqlSession.selectOne("member.findEmail",dto);
	}
	
	public String findPw(MemberDTO dto) {
		return sqlSession.selectOne("member.findPw",dto);
	}
	
	public int backPicUpdate(MemberDTO dto) {
		return sqlSession.update("member.backPicUpdate", dto);
	}

	public int mPicUpdate(MemberDTO dto) {
		return sqlSession.update("member.mPicUpdate", dto);
	}

	public int introUpdate(MemberDTO dto) {
		return sqlSession.update("member.introUpdate", dto);
	}
}
