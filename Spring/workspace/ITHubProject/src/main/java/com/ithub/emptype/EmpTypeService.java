package com.ithub.emptype;

import java.util.List;

public class EmpTypeService {
	
	public EmpTypeDAO empTypeDAO;
	
	public void setEmpTypeDAO(EmpTypeDAO empTypeDAO) {
		this.empTypeDAO = empTypeDAO;
	}
	
	public List<EmpTypeDTO> selectList() {
		return empTypeDAO.selectList();
	}

}
