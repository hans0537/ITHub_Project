package com.ithub.jobpost;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ithub.member.MemberDTO;

public class JobPostDAO {
	
	private SqlSession sqlSession;
	
	public JobPostDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Map<String,Object>> selectPost(){
		return sqlSession.selectList("jobPost.selectPost");
	}

	public List<Map<String,Object>> mySelectPost(int pSeq){
		return sqlSession.selectList("jobPost.mySelectPost", pSeq);
	}
	
	public JobPostDTO selectOneDetail(int jpostSeq) {
		return sqlSession.selectOne("jobPost.selectOneDetail", jpostSeq);
	}
	
	public int insertPost(JobPostDTO jDto) {
		return sqlSession.insert("jobPost.insertPost", jDto);
	}
	
	public int updatePost(JobPostDTO jDto) {
		return sqlSession.update("jobPost.updatePost", jDto);
	}
	
	public JobPostDTO selectOne(int jpostSeq) {
		return sqlSession.selectOne("jobPost.selectOne",jpostSeq);
	}
	
	public int deletePost(JobPostDTO jdto) {
		return sqlSession.delete("jobPost.deletePost", jdto);
	}

}
