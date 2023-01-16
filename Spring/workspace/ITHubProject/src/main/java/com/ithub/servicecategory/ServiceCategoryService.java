package com.ithub.servicecategory;

import java.util.List;

import com.ithub.emptype.EmpTypeDTO;

public class ServiceCategoryService {

	public ServiceCategoryDAO serviceCategoryDAO;
	
	public void setServiceCategoryDAO(ServiceCategoryDAO serviceCategoryDAO){
		this.serviceCategoryDAO = serviceCategoryDAO;
	}
	
	public List<ServiceCategoryDTO> selectList() {
		return serviceCategoryDAO.selectList();
	}

	
}
