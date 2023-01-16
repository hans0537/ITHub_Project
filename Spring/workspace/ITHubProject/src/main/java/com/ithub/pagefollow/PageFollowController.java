package com.ithub.pagefollow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.memfollow.MemFollowService;
import com.ithub.page.PageDTO;
import com.ithub.page.PageService;

@Controller
public class PageFollowController {

	private MemberService memberService;
	private PageService pageService;
	private PageFollowService pageFollowService;
	
	@Autowired
	private MemFollowService memFollowService;
	
	public PageFollowController(MemberService memberService, PageService pageService, PageFollowService pageFollowService) {
		this.memberService = memberService;
		this.pageService = pageService;
		this.pageFollowService = pageFollowService;
	}

	
	@RequestMapping("/page/pageFollow")
	public String follow(Model model, HttpServletRequest request) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		PageFollowDTO dto = new PageFollowDTO();
		
		int mySeq = (int)request.getSession().getAttribute("login");
		int pageSeq = Integer.parseInt(request.getParameter("pSeq"));
		int pType = Integer.parseInt(request.getParameter("pType"));
		dto.setFollowmSeq(mySeq);
		dto.setFollowerpSeq(pageSeq);

		pageFollowService.pageFollow(dto);
		
		List<Integer> followlist = memFollowService.mySelect(mySeq);	// 내가 팔로우하는 회원 시퀀스
		model.addAttribute("followlist",followlist);	
		
		List<Integer> flist = pageFollowService.selectm(mySeq);		// 내가 팔로우하는 페이지 시퀀스
		model.addAttribute("flist",flist);

		MemberDTO mdto = memberService.selectOne(mySeq);		// 내 정보
		model.addAttribute("dto",mdto);
		
		List<MemberDTO> mlist = null;
		List<PageDTO> plist = null;
		
		String path = request.getParameter("path");
		if("fw".equals(path)) {
			
			String user = request.getParameter("user");
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		
			
			if("me".equals(user)) {							// 나의 팔로우를 볼때
				
				mlist = memFollowService.followList(cSeq);			// 내가 팔로우한 회원 정보(cSeq -> mySeq)
				plist = memFollowService.pfollowList(cSeq);		// 내가 팔로우한 페이지 정보(cSeq -> mySeq)
				
			}else if("other".equals(user)) {							// 다른사람의 팔로우를 볼때
				
				mlist = memFollowService.followList(cSeq);		// 다른사람(지금 보고있는 회원)이 팔로우한 회원 정보(cSeq -> otherSeq)
				plist = memFollowService.pfollowList(cSeq);		// 다른사람(지금 보고있는 회원)이 팔로우한 페이지 정보(cSeq -> otherSeq)
				
			}
			
			model.addAttribute("user", user);
			model.addAttribute("cSeq", cSeq);
			model.addAttribute("mlist", mlist);
			model.addAttribute("plist", plist);
			
			return ViewPath.FOLLOW + "followList.jsp";
		}
		
		map.put("mSeq", mySeq);
		map.put("pType", pType);
		List<PageDTO> list = pageService.pTypeList(map);
		model.addAttribute("list",list);
		
		
		return ViewPath.PAGE + "pageList.jsp";
	}
	
	@RequestMapping("/page/pageunFollow")
	public String unfollow(Model model, HttpServletRequest request) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		PageFollowDTO dto = new PageFollowDTO();
		
		int mySeq = (int)request.getSession().getAttribute("login");
		int pageSeq = Integer.parseInt(request.getParameter("pSeq"));
		int pType = Integer.parseInt(request.getParameter("pType"));
		dto.setFollowmSeq(mySeq);
		dto.setFollowerpSeq(pageSeq);
		
		pageFollowService.unFollow(dto);	// 페이지 언팔
		
		List<Integer> followlist = memFollowService.mySelect(mySeq);	// 내가 팔로우하는 회원 시퀀스
		model.addAttribute("followlist",followlist);	
		
		List<Integer> flist = pageFollowService.selectm(mySeq);		// 내가 팔로우하는 페이지 시퀀스
		model.addAttribute("flist",flist);

		MemberDTO mdto = memberService.selectOne(mySeq);		// 내 정보
		model.addAttribute("dto",mdto);
		
		List<MemberDTO> mlist = null;
		List<PageDTO> plist = null;
		
		String path = request.getParameter("path");
		if("fw".equals(path)) {
			
			String user = request.getParameter("user");
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		
			
			if("me".equals(user)) {							// 나의 팔로우를 볼때
				
				mlist = memFollowService.followList(cSeq);			// 내가 팔로우한 회원 정보(cSeq -> mySeq)
				plist = memFollowService.pfollowList(cSeq);		// 내가 팔로우한 페이지 정보(cSeq -> mySeq)
				
			}else if("other".equals(user)) {							// 다른사람의 팔로우를 볼때
				
				mlist = memFollowService.followList(cSeq);		// 다른사람(지금 보고있는 회원)이 팔로우한 회원 정보(cSeq -> otherSeq)
				plist = memFollowService.pfollowList(cSeq);		// 다른사람(지금 보고있는 회원)이 팔로우한 페이지 정보(cSeq -> otherSeq)
				
			}
			
			model.addAttribute("user", user);
			model.addAttribute("cSeq", cSeq);
			model.addAttribute("mlist", mlist);
			model.addAttribute("plist", plist);
			
			return ViewPath.FOLLOW + "followList.jsp";
		}
		
		map.put("mSeq", mySeq);
		map.put("pType", pType);
		List<PageDTO> list = pageService.pTypeList(map);
		model.addAttribute("list",list);
		
		return ViewPath.PAGE + "pageList.jsp";
	}

}
