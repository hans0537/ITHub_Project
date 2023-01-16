package com.ithub.position;

import java.util.List;

public class PositionService {

	public PositionDAO positionDAO;
	
	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	
	public List<PositionDTO> selectList(){
		return positionDAO.selectList();
	}
}
