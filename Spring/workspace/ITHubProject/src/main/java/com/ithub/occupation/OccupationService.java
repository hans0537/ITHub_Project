package com.ithub.occupation;

import java.util.List;

public class OccupationService {
	
	public OccupationDAO occupationDAO;
	
	public void setOccupationDAO(OccupationDAO occupationDAO) {
		this.occupationDAO = occupationDAO;
	}

	public List<OccupationDTO> selectList(){
		return occupationDAO.selectList();
	}
}
