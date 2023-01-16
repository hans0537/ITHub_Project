package com.ithub.member;

import java.util.List;

public class MemberService {

	public MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public int insert(MemberDTO dto) {
		return memberDAO.insert(dto);
	}
	
	public List<MemberDTO> selectAll(){
		return memberDAO.selectAll();
	}
	
	public MemberDTO selectOne(int mSeq) {
		return memberDAO.selectOne(mSeq);
	}
	
	public String getmEmail(int mSeq) {
		return memberDAO.getmEmail(mSeq);
	}
	
	public int checkLogin(MemberDTO dto) {
		return memberDAO.checkLogin(dto);
	}
	
	public int update(MemberDTO dto) {
		return memberDAO.update(dto);
	}
	
	public int delete(int mSeq) {
		return memberDAO.delete(mSeq);
	}
	
	public String getName(int mSeq) {
		return memberDAO.getId(mSeq);
	}
	
	public String getId(int mSeq) {
		return memberDAO.getName(mSeq);
	}

	public MemberDTO getAll(int mSeq) {
		return memberDAO.getAll(mSeq);
	}
	
	public String findEmail(MemberDTO dto) {
		return memberDAO.findEmail(dto);
	}
	
	public String findPw(MemberDTO dto) {
		return memberDAO.findPw(dto);
	}

	public int backPicUpdate(MemberDTO dto) {
		return memberDAO.backPicUpdate(dto);
	}

	public int mPicUpdate(MemberDTO dto) {
		return memberDAO.mPicUpdate(dto);
	}

	public int introUpdate(MemberDTO dto) {
		return memberDAO.introUpdate(dto);
	}
}
