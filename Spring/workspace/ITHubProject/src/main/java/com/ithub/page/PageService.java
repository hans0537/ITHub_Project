package com.ithub.page;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class PageService {

	public PageDAO pageDAO;
	
	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}
	
	public int insert(PageDTO dto) {
		return pageDAO.insert(dto);
	}
	
	public List<PageDTO> getPage(int mSeq) {
		return pageDAO.getPage(mSeq);
	}
	
	public PageDTO selectOne(int pSeq) {
		return pageDAO.selectOne(pSeq);
	}
	
	public PageDTO selectOne(PageDTO pdto) {
		return pageDAO.selectOne(pdto);
	}
	
	public int updateText(PageDTO dto) {
		return pageDAO.updateText(dto);
	}
	
	public int updateFound(PageDTO dto) {
		return pageDAO.updateFound(dto);
	}
	
	public int updateEmpcnt(PageDTO dto) {
		return pageDAO.updateEmpcnt(dto);
	}
	
	public int updateAddr(PageDTO dto) {
		return pageDAO.updateAddr(dto);
	}

	public int pPicUpdate(PageDTO dto) {
		return pageDAO.pPicUpdate(dto);
	}

	public int pBackpicUpdate(PageDTO dto) {
		return pageDAO.pBackpicUpdate(dto);
	}

	public List<PageDTO> pTypeList(Map<String, Integer> map) {
		return pageDAO.pTypeList(map);
	}
	
	public List<PageDTO> pTypeAll(int pType) {
		return pageDAO.pTypeAll(pType);
	}
	
	public int update(PageDTO dto) {
		return pageDAO.update(dto);
	}
}
