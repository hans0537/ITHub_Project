package com.ithub.bcomment;

import java.util.List;
import java.util.Map;

import com.ithub.member.MemberDAO;

public class BcommentService {
	
	public BcommentDAO bcommentDAO;
	
	public void setBcommentDAO(BcommentDAO bcommentDAO) {
		this.bcommentDAO = bcommentDAO;
	}
	
	public int insert(BcommentDTO dto) {
		
		if(dto.getGroupno() != 0) {
			bcommentDAO.updateOrderno(dto);
		}
		int check = bcommentDAO.insert(dto);
				
		return check;
	}
	
	public List<BcommentDTO> selectAll() {
		return bcommentDAO.selectAll();
	}
	
	public List<BcommentDTO> selectGroup(int groupno) {
		return bcommentDAO.selectGroup(groupno);
	}
	
	public List<BcommentDTO> selectDepth(int groupno) {
		return bcommentDAO.selectDepth(groupno);
	}
	
	public BcommentDTO selectOne(Map<String, Object> map) {
		return bcommentDAO.selectOne(map);
	}
	
}
