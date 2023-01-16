package com.ithub.page;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ithub.common.ViewPath;
import com.ithub.industry.IndustryDTO;
import com.ithub.industry.IndustryService;
import com.ithub.jobpost.JobPostService;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.pagefollow.PageFollowService;
import com.ithub.pagetype.PagetypeDTO;
import com.ithub.pagetype.PagetypeService;
import com.ithub.ptomhit.PtomhitDTO;
import com.ithub.ptomhit.PtomhitService;

@Controller
public class PageController {

	private PageService pageService;
	private IndustryService industryService;
	private PagetypeService pagetypeService;
	private MemberService memberService;
	private PageFollowService pageFollowService;
	private PtomhitService ptomhitService;
	
	@Autowired // 자동 주입
	private ServletContext application;

	@Autowired // 자동 주입
	private JobPostService jobPostService;

	public PageController(PageService pageService, IndustryService industryService, PagetypeService pagetypeService, MemberService memberService, PageFollowService pageFollowService, PtomhitService ptomhitService) {
		this.pageService = pageService;
		this.industryService = industryService;
		this.pagetypeService = pagetypeService;
		this.memberService = memberService;
		this.pageFollowService = pageFollowService;
		this.ptomhitService = ptomhitService;
		
	}

	// 페이지 생성 폼
	@RequestMapping("/page/pageForm")
	public String pageForm(Model model, HttpServletRequest request) {

		int mSeq = (int)request.getSession().getAttribute("login");
		
		MemberDTO dto = memberService.selectOne(mSeq);
		
		List<IndustryDTO> industry = industryService.getIndustry();
		model.addAttribute("industry", industry);
		 
		List<PagetypeDTO> pagetype = pagetypeService.getPagetype();
		model.addAttribute("pagetype", pagetype);
 
		model.addAttribute("dto", dto);

		return ViewPath.PAGE + "pageForm.jsp";
	}

	// 페이지 insert & 내 페이지 프로필
	@RequestMapping("/page/create")
	public String create(PageDTO pdto, HttpServletRequest request) {

		// mSeq(회원 시퀀스)
		int mSeq = (int)request.getSession().getAttribute("login");

		pdto.setmSeq(mSeq);

		// pPic(페이지 로고)
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		MultipartFile logo = pdto.getLogo();

		String logoName = null;

		if (!logo.isEmpty() || logo==null) {
			logoName = logo.getOriginalFilename();
			logoName = mSeq + "pageLogo" + logoName.substring(logoName.lastIndexOf("."),logoName.length());
			
			// File 객체 생성
			File saveFile = new File(savePath, logoName);

			if (!saveFile.exists()) { // 경로에 파일이 없으면
				saveFile.mkdirs();
			} else { // 있으면
				long time = System.currentTimeMillis();

				logoName = String.format("%s%d%s", logoName.substring(0, logoName.lastIndexOf(".")), time,
						logoName.substring(logoName.lastIndexOf(".")));

				saveFile = new File(savePath, logoName);
			}

			// 업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시저장소에 저장되어 있다...
			// 파일이 일정시간이 지나면 사라지기때문에 내가 지정한 경로로 복사해준다...
			try {
				logo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			pdto.setpPic(logoName);
		}

		int su = pageService.insert(pdto);
		
		pdto = pageService.selectOne(pdto);
		
		return "redirect:/jump?mSeq="+mSeq+"&pSeq="+pdto.getpSeq();
	}
	
	// 한다리 걸치기
	@RequestMapping("/jump")
	public ModelAndView jump(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		
		int mSeq = Integer.parseInt(request.getParameter("mSeq"));
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		
		List<PtomhitDTO> hitList = ptomhitService.hitSelect(pSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> mlist = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("mlist", mlist);	
		
		MemberDTO dto = memberService.selectOne(mSeq);
		PageDTO pdto = pageService.selectOne(pSeq);
		
		int flr = pageFollowService.followerCnt(pSeq);
		
		pdto.setpFollower(flr);
		
		mv.addObject("dto", dto);
		mv.addObject("page", pdto);
		
		mv.setViewName(ViewPath.PAGE + "myPage.jsp");
		
		return mv;
	}
	
	// 내 페이지 프로필
	@RequestMapping("/page/myPage")
	public String myPage(Model model, HttpServletRequest request) {
		
		int mSeq = (Integer) request.getSession().getAttribute("login");
		
		int pSeq = Integer.parseInt(request.getParameter("pSeq").replaceAll("\'", ""));
		
		List<PtomhitDTO> hitList = ptomhitService.hitSelect(pSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> mlist = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("mlist", mlist);	

		MemberDTO dto = memberService.selectOne(mSeq);
		PageDTO pdto = pageService.selectOne(pSeq);
		
		List<Map<String,Object>> jplist = jobPostService.mySelectPost(pSeq);
		
		int flr = pageFollowService.followerCnt(pSeq);
		
		pdto.setpFollower(flr);
		
		model.addAttribute("dto",dto);
		model.addAttribute("page",pdto);
		model.addAttribute("jplist",jplist);
		
		return ViewPath.PAGE + "myPage.jsp";
	}

	// 다른 페이지 프로필
	@RequestMapping("/page/pageProfile")
	public String pageProfile(Model model, HttpServletRequest request) {
		
		int mSeq = (Integer) request.getSession().getAttribute("login");
		
		int pSeq = Integer.parseInt(request.getParameter("pSeq").replaceAll("\'", ""));
		
		// 조회 insert
		PtomhitDTO hit = new PtomhitDTO();
		hit.setpSeq(pSeq);		//조회한 페이지 프로필
		hit.setmSeq(mSeq);		//본사람
		
		ptomhitService.delete(hit);		
		ptomhitService.insert(hit);		//중복이면 최신화
		
		List<PtomhitDTO> hitList = ptomhitService.hitSelect(pSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> list = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("list", list);	
		
		MemberDTO dto = memberService.selectOne(mSeq);
		PageDTO pdto = pageService.selectOne(pSeq);
		
		int flr = pageFollowService.followerCnt(pSeq);
		
		pdto.setpFollower(flr);
		
		model.addAttribute("dto",dto);
		model.addAttribute("page",pdto);
		
		return ViewPath.PAGE + "pageProfile.jsp";
	}
	
	// 페이지 Text 수정
//	@RequestMapping("/page/update")
//	public String updateText(PageDTO dto, HttpServletRequest request) {
//		
//		int mSeq = (Integer) request.getSession().getAttribute("login");
//		
//		List<PageDTO> myPage = pageService.getPage(mSeq);
//		
//		request.setAttribute("myPage", myPage);
//		
//		String pText = dto.getpText().replaceAll("\r\n", "<br>");
//		
//		dto.setpText(pText);
//		
//		pageService.updateText(dto);
////		pageService.updateFound(dto.getpFounddate());
//		
//		request.setAttribute("page", dto);
//		
//		
//		return ViewPath.PAGE + "myPage.jsp";
//	}

	@RequestMapping("/page/pageList")
	public String pageList(Model model, HttpServletRequest request) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		int mSeq = (Integer) request.getSession().getAttribute("login");
		int pType = Integer.parseInt(request.getParameter("pType"));
		
		map.put("mSeq", mSeq);
		map.put("pType", pType);
		
		List<PageDTO> list = pageService.pTypeList(map);
		request.setAttribute("list", list);
		
		List<Integer> flist = pageFollowService.selectm(mSeq);
		
		MemberDTO dto = memberService.selectOne(mSeq);
		request.setAttribute("dto", dto);
		
		model.addAttribute("flist",flist);
		
		return ViewPath.PAGE + "pageList.jsp";
	}

	@RequestMapping("/page/update")
	@ResponseBody
	public PageDTO update(@RequestBody PageDTO dto){
		
		if(dto.getpText() != null) {
			String pText = dto.getpText().replaceAll("\r\n", "<br>");
			dto.setpText(pText);
		}

		pageService.update(dto);
		
		return dto;
	}	
}
