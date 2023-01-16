package com.ithub.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.scheduling.config.ExecutorBeanDefinitionParser;

public class BoardDAO {
	
	private SqlSession sqlSession;
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BoardDTO dto) {
		return sqlSession.insert("board.insert", dto);
	}

	public int pinsert(BoardDTO dto) {
		return sqlSession.insert("board.pinsert", dto);
	}
	
	public BoardDTO selectOne(int boardSeq) {
		return sqlSession.selectOne("board.selectOne", boardSeq);
	}
	
	public List<BoardDTO> selectList(Map<String, Object> map){
		return sqlSession.selectList("board.selectList", map);
	}
	
	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("board.getTotal", map);
	}

	public int getMyTotal(Map<String, Object> map) {
		return sqlSession.selectOne("board.getMyTotal", map);
	}
	
	public List<BoardDTO> myBoard(int mSeq) {
		return sqlSession.selectList("board.myBoard", mSeq);
	}
	
	public int update(BoardDTO dto) {
		return sqlSession.update("board.update", dto);
	}
	
	public int delete(int boardSeq) throws Exception{
		return sqlSession.delete("board.delete", boardSeq);
	}
	
	public BoardDTO selectBoard(int boardSeq) {
		return sqlSession.selectOne("board.selectBoard", boardSeq);
	}
	
	public List<BoardDTO> bcCount() {
		return sqlSession.selectList("board.bcCount");
	}
	
	public List<BoardDTO> likeCount() {
		return sqlSession.selectList("board.likeCount");
	}
}
