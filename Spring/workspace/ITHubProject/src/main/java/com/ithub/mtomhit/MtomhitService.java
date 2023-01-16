package com.ithub.mtomhit;

import java.util.List;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class MtomhitService {

	public MtomhitDAO mtomhitDAO;
	
	public void setMtomhitDAO(MtomhitDAO mtomhitDAO) {
		this.mtomhitDAO = mtomhitDAO;
	}
	
	public int insert(MtomhitDTO dto) {
		return mtomhitDAO.insert(dto);
	}
	
	public int hitCheck(MtomhitDTO dto) {
		return mtomhitDAO.hitCheck(dto);
	}
	
	public int delete(MtomhitDTO dto) {
		return mtomhitDAO.delete(dto);
	}
	
	public List<MtomhitDTO> hitSelect(int mhitSeq) {
		return mtomhitDAO.hitSelect(mhitSeq);
	}
	
}
