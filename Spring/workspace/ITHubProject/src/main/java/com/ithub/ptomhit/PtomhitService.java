package com.ithub.ptomhit;

import java.util.List;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class PtomhitService {

	public PtomhitDAO ptomhitDAO;
	
	public void setPtomhitDAO(PtomhitDAO ptomhitDAO) {
		this.ptomhitDAO = ptomhitDAO;
	}
	
	public int insert(PtomhitDTO dto) {
		return ptomhitDAO.insert(dto);
	}
	
	public int hitCheck(PtomhitDTO dto) {
		return ptomhitDAO.hitCheck(dto);
	}
	
	public int delete(PtomhitDTO dto) {
		return ptomhitDAO.delete(dto);
	}
	
	public List<PtomhitDTO> hitSelect(int pSeq) {
		return ptomhitDAO.hitSelect(pSeq);
	}
	
}
