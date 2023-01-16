package com.ithub.jobpost;

import java.util.List;
import java.util.Map;

import com.ithub.member.MemberDTO;


public class JobPostService {
	public JobPostDAO jobPostDao;
	
	public void setJobPostDAO(JobPostDAO jobPostDao) {
		this.jobPostDao = jobPostDao;
	}
	
	public List<Map<String,Object>> selectPost(){
		List<Map<String,Object>> list = jobPostDao.selectPost();
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}

	public List<Map<String,Object>> mySelectPost(int pSeq){
		List<Map<String,Object>> list = jobPostDao.mySelectPost(pSeq);
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}
	
	public JobPostDTO selectOneDetail(int jpostSeq) {
		return jobPostDao.selectOneDetail(jpostSeq);
	}
	
	public int insertPost(JobPostDTO jDto) {
		int check = jobPostDao.insertPost(jDto);
		return check;
	}
	
	public int updatePost(JobPostDTO jDto) {
		int flag = jobPostDao.updatePost(jDto);
		return flag;
	}
	
	public JobPostDTO selectOne(int jpostSeq) {
		return jobPostDao.selectOne(jpostSeq);
	}
	
	public boolean deletePost(JobPostDTO jDto) {
		int del = jobPostDao.deletePost(jDto);
		boolean point = false;
		if(del != 0) {
			return point = true;
		}else {
			return point;
		}
	}
	
}
