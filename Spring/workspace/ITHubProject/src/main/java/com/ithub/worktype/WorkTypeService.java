package com.ithub.worktype;

import java.util.List;

public class WorkTypeService {

	public WorkTypeDAO workTypeDAO;
	
	public void setWorkTypeDAO(WorkTypeDAO workTypeDAO) {
		this.workTypeDAO = workTypeDAO;
	}
	
	public List<WorkTypeDTO> selectList(){
		return workTypeDAO.selectList();
	}
}
