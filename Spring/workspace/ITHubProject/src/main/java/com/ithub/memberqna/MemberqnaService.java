package com.ithub.memberqna;

import java.util.List;
import java.util.Map;

public class MemberqnaService {
	
	public MemberqnaDAO memberqnaDAO;
	
	public void setMemberqnaDAO(MemberqnaDAO memberqnaDAO) {
		this.memberqnaDAO = memberqnaDAO;
	}
	
	public int insert(MemberqnaDTO mqdto) {
		return memberqnaDAO.insert(mqdto);
	}
	
	public MemberqnaDTO selectOne(int mqnaSeq) {
		return memberqnaDAO.selectOne(mqnaSeq);
	}
	
	public List<Map<String,Object>> mySelect(Map<String,Object> map){
		List<Map<String,Object>> mqlist = memberqnaDAO.mySelect(map);
		if(mqlist.isEmpty()) {
			System.out.println(mqlist);
			mqlist=null;
		}
		System.out.println("야옹1");
		return mqlist;
	}
	
	public int update(MemberqnaDTO mqdto) {
		return memberqnaDAO.update(mqdto);
	}
	
	public int delete(MemberqnaDTO mqdto) {
		return memberqnaDAO.delete(mqdto);
	}
	
	public int getMyTotal(Map<String, Object> map) {
		return memberqnaDAO.getMyTotal(map);
	}
}
