package com.ithub.blike;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.scheduling.config.ExecutorBeanDefinitionParser;

public class BlikeDAO {
	
	private SqlSession sqlSession;
	
	public BlikeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BlikeDTO dto) {
		return sqlSession.insert("blike.insert", dto);
	}
	
	public int delete(BlikeDTO dto) {
		return sqlSession.delete("blike.delete", dto);
	}
	
	public List<BlikeDTO> myLike(int mSeq) {
		return sqlSession.selectList("blike.myLike", mSeq);
	}
	
	public List<BlikeDTO> myLikeBoard(int mSeq) {
		return sqlSession.selectList("blike.myLikeBoard", mSeq);
	}
	
}
