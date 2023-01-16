package com.ithub.servicecenter;

import java.util.List;


public class ServiceCenterService {
	
	public ServiceCenterDAO serviceCenterDAO;
	
	public void setServiceCenterDAO(ServiceCenterDAO serviceCenterDAO) {
		this.serviceCenterDAO = serviceCenterDAO;
	}
	public List<ServiceCenterDTO> selectList() {
		return serviceCenterDAO.selectList();
	}
	
}
