package com.ithub.bcomment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class BcommentDAO {
	
	private SqlSession sqlSession;
	
	public BcommentDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BcommentDTO dto) {
		return sqlSession.insert("bcomment.insert", dto);
	}
	
	public List<BcommentDTO> selectAll() {
		return sqlSession.selectList("bcomment.selectAll");
	}
	
	public List<BcommentDTO> selectGroup(int groupno) {
		return sqlSession.selectList("bcomment.selectGroup", groupno);
	}
	
	public List<BcommentDTO> selectDepth(int groupno) {
		return sqlSession.selectList("bcomment.selectDepth", groupno);
	}
	
	public BcommentDTO selectOne(Map<String, Object> map) {
		return sqlSession.selectOne("bcomment.selectOne", map);
	}
	
	public int updateOrderno(BcommentDTO dto) {
		return sqlSession.update("bcomment.updateOrderno", dto);
	}
}
