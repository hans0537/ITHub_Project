package com.ithub.industry;

import java.util.List;

public class IndustryService {
	
	private IndustryDAO industryDAO;
	
	public void setIndustryDAO(IndustryDAO industryDAO) {
		this.industryDAO = industryDAO;
	}
	
	public List<IndustryDTO> getIndustry() {
		return industryDAO.getIndustry();
	}

}
