package com.ithub.pagetype;

import java.util.List;

public class PagetypeService {
	
	private PagetypeDAO pagetypeDAO;
	
	public void setPagetypeDAO(PagetypeDAO pagetypeDAO) {
		this.pagetypeDAO = pagetypeDAO;
	}
	
	public List<PagetypeDTO> getPagetype() {
		return pagetypeDAO.getPagetype();
	}

}
