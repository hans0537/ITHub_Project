package com.ithub.memberqna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.board.BoardDTO;
import com.ithub.common.Paging;
import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.qnaanswer.QnaanswerService;
import com.ithub.qnapic.QnapicService;
import com.ithub.servicecategory.ServiceCategoryDTO;
import com.ithub.servicecategory.ServiceCategoryService;
import com.ithub.servicecenter.ServiceCenterDTO;
import com.ithub.servicecenter.ServiceCenterService;
import com.ithub.topic.TopicDTO;
import com.ithub.topic.TopicService;

@Controller
public class MemberqnaController {
	
	private MemberqnaService memberqnaService;
	private QnaanswerService qnaanswserService;
	private QnapicService qnapicService;
	private ServiceCategoryService serviceCategoryService; 
	private TopicService topicService;
	private ServiceCenterService serviceCenterService;
	private MemberService memberService;
	
	public MemberqnaController(MemberqnaService memberqnaService,QnaanswerService qnaanswserService,QnapicService qnapicService,
			ServiceCategoryService serviceCategoryService,TopicService topicService,ServiceCenterService serviceCenterService
			,MemberService memberService) {
		this.memberService = memberService;
		this.qnaanswserService = qnaanswserService;
		this.qnapicService = qnapicService;
		this.serviceCenterService = serviceCenterService;
		this.serviceCategoryService = serviceCategoryService;
		this.topicService = topicService;
		this.memberqnaService = memberqnaService;
	}
	
	@RequestMapping("/qna/qnaWriteForm")
	public String qnaPage(HttpServletRequest request) {
		int mSeq = (int) request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		request.setAttribute("dto", dto);
			
		List<ServiceCenterDTO> sclist = serviceCenterService.selectList();
		List<TopicDTO> tolist = topicService.selectList();		
		
		request.setAttribute("sclist", sclist);
		request.setAttribute("tolist", tolist);
		
		return ViewPath.SERVICE+"qnaWriteForm.jsp";
	}
	
	@RequestMapping("/qna/qnaCenter")
	public String qnaCenter(HttpServletRequest request, Integer page, String type, String word) {
		int mSeq = (int)request.getSession().getAttribute("login");
		// type이랑 ""랑 같냐? 참 null, 거짓 type
		type = "".equals(type) ? null : type;
		
		word = "".equals(word) ? null : word;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("type", type);
		map.put("word", word);
		map.put("mSeq", mSeq);
		
		if(page == null) {
			page = 1;
		}
		
		int qnaCount = 0;
		
		qnaCount = memberqnaService.getMyTotal(map);
		

		Paging paging = new Paging(page, qnaCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		// 5개씩 뽑아버리기
		List<Map<String,Object>> mqlist = memberqnaService.mySelect(map); 
		
		request.setAttribute("mqlist", mqlist);
		request.setAttribute("paging", paging);
		
		List<ServiceCategoryDTO> scatelist = serviceCategoryService.selectList();
		List<TopicDTO> tolist = topicService.selectList();		
		MemberDTO dto = memberService.selectOne(mSeq);
		
		
		request.setAttribute("scatelist", scatelist);
		request.setAttribute("tolist", tolist);
		request.setAttribute("mqlist", mqlist); 
		request.setAttribute("dto", dto);
		
		return ViewPath.SERVICE+"qnaCenter.jsp";
	}
	
//	@RequestMapping("/qna/list")
//	public String qnalist(HttpServletRequest request, Model model, Integer page, String type, String word) {
//
//		int mSeq = (int)request.getSession().getAttribute("login");
//		// type이랑 ""랑 같냐? 참 null, 거짓 type
//		type = "".equals(type) ? null : type;
//		
//		word = "".equals(word) ? null : word;
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("type", type);
//		map.put("word", word);
//		map.put("mSeq", mSeq);
//		
//		if(page == null) {
//			page = 1;
//		}
//		
//		int qnaCount = 0;
//		
//		qnaCount = memberqnaService.getMyTotal(map);
//		
//
//		Paging paging = new Paging(page, qnaCount);
//		
//		map.put("first", paging.getFirst());
//		map.put("last", paging.getLast());
//		
//		// 5개씩 뽑아버리기
//		List<Map<String,Object>> mqlist = memberqnaService.mySelect(map); 
//		
//		model.addAttribute("mqlist", mqlist);
//		model.addAttribute("paging", paging);
//		
//		
//		return ViewPath.SERVICE+"qnaCenter.jsp";
//	}
	
	@RequestMapping("/qna/qnaWrite")
	public String qnaWrite(HttpServletRequest request,MemberqnaDTO mqdto) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		mqdto.setmSeq(mSeq);
		
		memberqnaService.insert(mqdto);
		return "redirect:/qna/qnaCenter";
	}
	
	@RequestMapping("/qna/qnaUpdateForm")
	public String qnaUpdateForm(HttpServletRequest request) {
		
		int mqnaSeq = Integer.parseInt(request.getParameter("mqnaSeq"));
		MemberqnaDTO mqdto = memberqnaService.selectOne(mqnaSeq);
		List<ServiceCenterDTO> sclist = serviceCenterService.selectList();
		
		request.setAttribute("sclist", sclist);
		request.setAttribute("mqdto", mqdto);
		return ViewPath.SERVICE+"qnaUpdateForm.jsp";
	}
	
	@RequestMapping("/qna/qnaUpdate")
	public String qnaUpdate(HttpServletRequest request,MemberqnaDTO mqdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		int mqnaSeq = Integer.parseInt(request.getParameter("mqnaSeq"));
		
		
		mqdto.setMqnaSeq(mqnaSeq);
		mqdto.setmSeq(mSeq);
		
		memberqnaService.update(mqdto);
		return ViewPath.SERVICE+"qnaCenter.jsp";
	}
	
	@RequestMapping("/qna/qnaDelete")
	public String qnaDelete(HttpServletRequest request,MemberqnaDTO mqdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		int mqnaSeq = Integer.parseInt(request.getParameter("mqnaSeq"));

		mqdto.setMqnaSeq(mqnaSeq);
		mqdto.setmSeq(mSeq);
		
		memberqnaService.delete(mqdto);
		
		return ViewPath.SERVICE+"qnaCenter.jsp";
	}
	
}
