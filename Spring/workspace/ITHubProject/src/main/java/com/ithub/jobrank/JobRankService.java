package com.ithub.jobrank;

import java.util.List;

public class JobRankService {

	public JobRankDAO jobRankDAO;
	
	public void setJobRankDAO(JobRankDAO jobRankDAO) {
		this.jobRankDAO = jobRankDAO;
	}
	
	public List<JobRankDTO> selectList(){
		return jobRankDAO.selectList();
	}
}
