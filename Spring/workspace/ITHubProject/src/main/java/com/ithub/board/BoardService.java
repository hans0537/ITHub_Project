package com.ithub.board;

import java.util.List;
import java.util.Map;

import com.ithub.member.MemberDAO;

public class BoardService {
	
	public BoardDAO boardDAO;
	public MemberDAO memberDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public BoardDTO selectOne(int boardSeq) {
		return boardDAO.selectOne(boardSeq);
	}
	
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> list = boardDAO.selectList(map);
		
		if(list.isEmpty()) {
			list = null;
		}
		return list;
	}
	
	public int getTotal(Map<String, Object> map) {
		return boardDAO.getTotal(map);
	}

	public int getMyTotal(Map<String, Object> map) {
		return boardDAO.getMyTotal(map);
	}
	
	public int insert(BoardDTO dto) {
		return boardDAO.insert(dto);
	}
	
	public int pinsert(BoardDTO dto) {
		return boardDAO.pinsert(dto);
	}
	
	public int update(BoardDTO dto) {
		return boardDAO.update(dto);
	}
	
	public int delete(int boardSeq) throws Exception {
		
		return boardDAO.delete(boardSeq);
	}

	public BoardDTO selectBoard(int boardSeq) {
		return boardDAO.selectBoard(boardSeq);
	}
	
	public List<BoardDTO> bcCount() {
		return boardDAO.bcCount();
	}
	
	public List<BoardDTO> likeCount() {
		return boardDAO.likeCount();
	}
	
	
}
