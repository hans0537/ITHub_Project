package com.ithub.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ithub.admindept.AdminDeptDTO;
import com.ithub.board.BoardDTO;
import com.ithub.member.MemberDTO;
import com.ithub.memberqna.MemberqnaDTO;
import com.ithub.page.PageDTO;
import com.ithub.qnaanswer.QnaanswerDTO;

public class AdminDAO {

	private SqlSession sqlSession;
	
	public AdminDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<AdminDTO> selectAdminAll() {
		return sqlSession.selectList("admin.selectAdminAll");
	}
	
	public List<PageDTO> selectPageAll() {
		return sqlSession.selectList("admin.selectPageAll");
	}
	
	public List<PageDTO> pTypeList(int pType) {
		return sqlSession.selectList("admin.pTypeList", pType);
	}
	
	public List<MemberDTO> selectMemAll() {
		return sqlSession.selectList("admin.selectMemAll");
	}
	
	public int checkLogin(AdminDTO dto) {
		return sqlSession.selectOne("admin.checkLogin", dto);
	}
	
	public AdminDTO selectOne(int adminSeq) {
		return sqlSession.selectOne("admin.selectOne", adminSeq);
	}

	public List<BoardDTO> boardmList(Map<String, Object> map) {
		return sqlSession.selectList("admin.boardmList", map);
	}
	
	public int boardmTotal(Map<String, Object> map) {
		return sqlSession.selectOne("admin.boardmTotal", map);
	}

	public List<BoardDTO> boardpList(Map<String, Object> map) {
		return sqlSession.selectList("admin.boardpList", map);
	}
	
	public int boardpTotal(Map<String, Object> map) {
		return sqlSession.selectOne("admin.boardpTotal", map);
	}
	
	public List<AdminDeptDTO> deptList() {
		return sqlSession.selectList("admin.deptList");
	}
	
	public int boardDelete(int boardSeq) throws Exception{
		return sqlSession.delete("admin.boardDelete", boardSeq);
	}
	
	public int pageDelete(int pSeq) throws Exception{
		return sqlSession.delete("admin.pageDelete", pSeq);
	}
	
	public int memDelete(int mSeq) throws Exception{
		return sqlSession.delete("admin.memDelete", mSeq);
	}
	
	public List<Map<String,Object>> memQnAList(Map<String, Object> map){
		return sqlSession.selectList("admin.memQnAList", map);
	}
	
	public int qnaCnt(Map<String, Object> map) {
		return sqlSession.selectOne("admin.qnaCnt", map);
	}
	
	public MemberqnaDTO qnaSelect(int mqnaSeq) {
		return sqlSession.selectOne("admin.qnaSelect", mqnaSeq);
	}

	public int qnaAns(QnaanswerDTO qadto) {
		return sqlSession.insert("admin.qnaAns", qadto);
	}
	
	public int qnaState(int mqnaSeq) {
		return sqlSession.update("admin.qnaState", mqnaSeq);
	}
	
	public int qnaDelete(int mqnaSeq) {
		return sqlSession.delete("admin.qnaDelete", mqnaSeq);
	}
}
