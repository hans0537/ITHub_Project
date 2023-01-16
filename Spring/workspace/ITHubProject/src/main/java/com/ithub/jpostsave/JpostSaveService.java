package com.ithub.jpostsave;

import java.util.List;

import com.ithub.member.MemberDTO;

public class JpostSaveService {
	public JpostSaveDAO jpostSaveDAO;
	
	public void setJpostSaveDAO(JpostSaveDAO jpostSaveDAO) {
		this.jpostSaveDAO = jpostSaveDAO;
	}
	
	public JpostSaveDTO selectOne(int jsSeq) {
		return jpostSaveDAO.selectOne(jsSeq);
	}
	
	public int check(JpostSaveDTO jsdto) {
		return jpostSaveDAO.check(jsdto);
	}

	public int insertResume(JpostSaveDTO jsdto) {
		return jpostSaveDAO.insertResume(jsdto);
	}
	
	public List<MemberDTO> applyList(int jpostSeq) {
		return jpostSaveDAO.applyList(jpostSeq);
	}
	
	public List<JpostSaveDTO> myApplies(int mSeq) {
		return jpostSaveDAO.myApplies(mSeq);
	}
	
	public int updateResume(JpostSaveDTO jsdto) {
		return jpostSaveDAO.updateResume(jsdto);
	}
	
	public int deleteResume(int jsSeq) {
		return jpostSaveDAO.deleteResume(jsSeq);
	}
}
