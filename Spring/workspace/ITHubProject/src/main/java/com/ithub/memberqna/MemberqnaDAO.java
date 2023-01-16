package com.ithub.memberqna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MemberqnaDAO {

	private SqlSession sqlSession;
	
	public MemberqnaDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MemberqnaDTO mqdto) {
		return sqlSession.insert("memberqna.insert",mqdto);
	}
	public MemberqnaDTO selectOne(int mqnaSeq) {
		return sqlSession.selectOne("memberqna.selectOne",mqnaSeq);
	}
	
	public List<Map<String,Object>> mySelect(Map<String, Object> map){
		return sqlSession.selectList("memberqna.mySelect", map);
	}
	
	public int update(MemberqnaDTO mqdto) {
		return sqlSession.update("memberqna.update",mqdto);
	}
	
	public int delete(MemberqnaDTO mqdto) {
		return sqlSession.delete("memberqna.delete",mqdto);
	}
	
	public int getMyTotal(Map<String, Object> map) {
		return sqlSession.selectOne("memberqna.getMyTotal", map);
	}
}

