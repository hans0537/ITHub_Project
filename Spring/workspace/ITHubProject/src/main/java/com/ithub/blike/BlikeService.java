package com.ithub.blike;

import java.util.List;
import java.util.Map;

import com.ithub.member.MemberDAO;

public class BlikeService {
	
	public BlikeDAO blikeDAO;
	
	public void setBlikeDAO(BlikeDAO blikeDAO) {
		this.blikeDAO = blikeDAO;
	}
	
	public int insert(BlikeDTO dto) {
		return blikeDAO.insert(dto);
	}
	
	public int delete(BlikeDTO dto) {
		return blikeDAO.delete(dto);
	}
	
	public List<BlikeDTO> myLike(int mSeq) {
		return blikeDAO.myLike(mSeq);
	}
	
	public List<BlikeDTO> myLikeBoard(int mSeq) {
		return blikeDAO.myLikeBoard(mSeq);
	}
	
}
