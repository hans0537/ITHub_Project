package com.ithub.memfollow;

import java.util.List;

import com.ithub.member.MemberDTO;
import com.ithub.page.PageDTO;

public class MemFollowService {

	public MemFollowDAO memFollowDAO;
	
	public void setMemFollowDAO(MemFollowDAO memFollowDAO) {
		this.memFollowDAO = memFollowDAO;
	}
	
	public int memFollow(MemFollowDTO dto) {
		return memFollowDAO.memFollow(dto);
	}
	
	public int followCnt(int mSeq) {
		return memFollowDAO.followCnt(mSeq);
	}

	public int followerCnt(int mSeq) {
		return memFollowDAO.followerCnt(mSeq);
	}
	
	public List<Integer> mySelect(int mSeq) {
		return memFollowDAO.mySelect(mSeq);
	}
	
	public int unFollow(MemFollowDTO dto) {
		return memFollowDAO.unFollow(dto);
	}

	public List<MemberDTO> followList(int mSeq) {
		return memFollowDAO.followList(mSeq);
	}
	
	public List<MemberDTO> followerList(int mSeq) {
		return memFollowDAO.followerList(mSeq);
	}

	public List<PageDTO> pfollowList(int mSeq) {
		return memFollowDAO.pfollowList(mSeq);
	}
	
	public List<MemberDTO> pfollowerList(int mSeq) {
		return memFollowDAO.pfollowerList(mSeq);
	}
}
