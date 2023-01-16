package com.ithub.pagefollow;

import java.util.List;

public class PageFollowService {

	public PageFollowDAO pageFollowDAO;
	
	public void setPageFollowDAO(PageFollowDAO pageFollowDAO) {
		this.pageFollowDAO = pageFollowDAO;
	}
	
	public int pageFollow(PageFollowDTO dto) {
		return pageFollowDAO.memFollow(dto);
	}
	
	public int followCnt(int mSeq) {
		return pageFollowDAO.followCnt(mSeq);
	}

	public int followerCnt(int mSeq) {
		return pageFollowDAO.followerCnt(mSeq);
	}
	
	public List<Integer> selectm(int mSeq) {
		return pageFollowDAO.selectm(mSeq);
	}
	
	public int unFollow(PageFollowDTO dto) {
		return pageFollowDAO.unFollow(dto);
	}
}
