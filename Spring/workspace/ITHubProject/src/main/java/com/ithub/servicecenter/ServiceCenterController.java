package com.ithub.servicecenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.servicecategory.ServiceCategoryDTO;
import com.ithub.servicecategory.ServiceCategoryService;
import com.ithub.topic.TopicDTO;
import com.ithub.topic.TopicService;

@Controller
public class ServiceCenterController {
	
	private ServiceCenterService serviceCenterService;
	private ServiceCategoryService serviceCategoryService;
	private TopicService topicService;
	
	@Autowired
	private MemberService memberService;
	
	public ServiceCenterController(ServiceCenterService serviceCenterService,ServiceCategoryService serviceCategoryService,TopicService topicService) {
		this.serviceCenterService = serviceCenterService;
		this.serviceCategoryService = serviceCategoryService;
		this.topicService = topicService;
	}
	
	@RequestMapping("/service/help")
	public String serviceCenterForm(HttpServletRequest request) {
		int mSeq = (int) request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		request.setAttribute("dto", dto);
		
		List<ServiceCategoryDTO> scatelist = serviceCategoryService.selectList();
		List<TopicDTO> tolist = topicService.selectList();		
		
		request.setAttribute("scatelist", scatelist);
		request.setAttribute("tolist", tolist);
		
		return ViewPath.SERVICE + "serviceCenter.jsp";
	}
	
	
	
}
