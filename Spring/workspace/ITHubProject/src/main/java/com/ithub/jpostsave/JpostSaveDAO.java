package com.ithub.jpostsave;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ithub.member.MemberDTO;

public class JpostSaveDAO {

	private SqlSession sqlSession;
	
	public JpostSaveDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public JpostSaveDTO selectOne(int jsSeq) {
		return sqlSession.selectOne("jpostsave.selectOne", jsSeq);
	}
	
	public int check(JpostSaveDTO jsdto) {
		return sqlSession.selectOne("jpostsave.check", jsdto);
	}

	public List<MemberDTO> applyList(int jpostSeq) {
		return sqlSession.selectList("jpostsave.applyList", jpostSeq);
	}
	
	public int insertResume(JpostSaveDTO jsdto) {
		return sqlSession.insert("jpostsave.insertResume", jsdto);
	}
	
	public List<JpostSaveDTO> myApplies(int mSeq) {
		return sqlSession.selectList("jpostsave.myApplies", mSeq);
	}
	
	public int updateResume(JpostSaveDTO jsdto) {
		return sqlSession.update("jpostsave.updateResume", jsdto);
	}
	
	public int deleteResume(int jsSeq) {
		return sqlSession.delete("jpostsave.deleteResume", jsSeq);
	}
}
