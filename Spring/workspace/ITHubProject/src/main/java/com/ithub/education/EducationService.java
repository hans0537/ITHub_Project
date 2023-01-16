package com.ithub.education;

import java.util.List;

public class EducationService {
	
	public EducationDAO educationDAO;
	
	public void setEducationDAO(EducationDAO educationDAO) {
		this.educationDAO = educationDAO;
	}
	
	public int insert(EducationDTO dto) {
		return educationDAO.insert(dto);
	}
	
	public List<EducationDTO> myEdu(int mSeq) {
		return educationDAO.myEdu(mSeq);
	}

}
