package com.ithub.career;

import java.util.List;

public class CareerService {
	
	public CareerDAO careerDAO;
	
	public void setCareerDAO(CareerDAO careerDAO) {
		this.careerDAO = careerDAO;
	}
	
	public int insert(CareerDTO dto) {
		return careerDAO.insert(dto);
	}
	
	public List<CareerDTO> selectList() {
		return careerDAO.selectList();
	}
	
	public List<CareerDTO> myCareer(int mSeq) {
		return careerDAO.myCareer(mSeq);
	}

	public int delete(CareerDTO dto) {
		return careerDAO.delete(dto);
	}
}
