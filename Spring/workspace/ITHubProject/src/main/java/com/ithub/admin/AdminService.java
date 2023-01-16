package com.ithub.admin;

import java.util.List;
import java.util.Map;

import com.ithub.admindept.AdminDeptDTO;
import com.ithub.board.BoardDTO;
import com.ithub.member.MemberDTO;
import com.ithub.memberqna.MemberqnaDTO;
import com.ithub.page.PageDTO;
import com.ithub.qnaanswer.QnaanswerDTO;

public class AdminService {
	
	public AdminDAO adminDAO;
	
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	public List<AdminDTO> selectAdminAll(){
		return adminDAO.selectAdminAll();
	}

	public List<PageDTO> selectPageAll(){
		return adminDAO.selectPageAll();
	}
	
	public List<PageDTO> pTypeList(int pType){
		return adminDAO.pTypeList(pType);
	}
	
	public List<MemberDTO> selectMemAll(){
		return adminDAO.selectMemAll();
	}
	
	public int checkLogin(AdminDTO dto) {
		return adminDAO.checkLogin(dto);
	}

	public AdminDTO selectOne(int adminSeq) {
		return adminDAO.selectOne(adminSeq);
	}

	public List<BoardDTO> boardmList(Map<String, Object> map) {
		return adminDAO.boardmList(map);
	}
	
	public int boardmTotal(Map<String, Object> map) {
		return adminDAO.boardmTotal(map);
	}

	public List<BoardDTO> boardpList(Map<String, Object> map) {
		return adminDAO.boardpList(map);
	}
	
	public int boardpTotal(Map<String, Object> map) {
		return adminDAO.boardpTotal(map);
	}

	public List<AdminDeptDTO> deptList() {
		return adminDAO.deptList();
	}
	
	public int boardDelete(int boardSeq) throws Exception {
		return adminDAO.boardDelete(boardSeq);
	}
	
	public int pageDelete(int pSeq) throws Exception{
		return adminDAO.pageDelete(pSeq);
	}

	public int memDelete(int mSeq) throws Exception{
		return adminDAO.memDelete(mSeq);
	}
	
	public List<Map<String,Object>> memQnAList(Map<String, Object> map){
		return adminDAO.memQnAList(map);
	}
	
	public int qnaCnt(Map<String, Object> map) {
		return adminDAO.qnaCnt(map);
	}

	public MemberqnaDTO qnaSelect(int mqnaSeq) {
		return adminDAO.qnaSelect(mqnaSeq);
	}
	
	public int qnaAns(QnaanswerDTO qadto) {
		return adminDAO.qnaAns(qadto);
	}
	
	public int qnaState(int mqnaSeq) {
		return adminDAO.qnaState(mqnaSeq);
	}
	
	public int qnaDelete(int mqnaSeq) {
		return adminDAO.qnaDelete(mqnaSeq);
	}
}
