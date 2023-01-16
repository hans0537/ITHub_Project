package com.ithub.jobpost;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.common.ViewPath;
import com.ithub.emptype.EmpTypeDTO;
import com.ithub.emptype.EmpTypeService;
import com.ithub.industry.IndustryDTO;
import com.ithub.industry.IndustryService;
import com.ithub.jobrank.JobRankDTO;
import com.ithub.jobrank.JobRankService;
import com.ithub.jpostsave.JpostSaveDTO;
import com.ithub.jpostsave.JpostSaveService;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.occupation.OccupationDTO;
import com.ithub.occupation.OccupationService;
import com.ithub.page.PageDTO;
import com.ithub.page.PageService;
import com.ithub.position.PositionDTO;
import com.ithub.position.PositionService;
import com.ithub.worktype.WorkTypeDTO;
import com.ithub.worktype.WorkTypeService;

@Controller
public class JobPostController {
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private EmpTypeService empTypeService;
	
	@Autowired
	private WorkTypeService workTypeService;
	
	@Autowired
	private IndustryService industryService;
	
	@Autowired
	private OccupationService occupationService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private JobRankService jobRankService;

	@Autowired
	private JpostSaveService jpostSaveService;
	
	public JobPostService jobPostService;
	
	public JobPostController(JobPostService jopPostService) {
		this.jobPostService = jopPostService;
	}
	
	
	@RequestMapping("/job/jobList")
	public String posts(Model model, HttpServletRequest request, JobPostDTO jDto, String type, String word) {
		
		int mSeq = (int)request.getSession().getAttribute("login");

		MemberDTO dto = memberService.selectOne(mSeq);
		model.addAttribute("dto", dto);
		
		//맵선언
//		Map<String,Object> map = new HashMap<String,Object>();
		//검색을 위한 type과 word 넣기
		
//		map.put("type", type);
//		map.put("word", word);
		//뽑아내기 위해 list에 map저장
		
		List<Map<String,Object>> list = jobPostService.selectPost();
		model.addAttribute("list", list);
		
		return ViewPath.JOB + "jobList.jsp";
	}
	
	@RequestMapping("/job/jobPost")
	public String postPage(HttpServletRequest request, Model model) {
		int mSeq = (int) request.getSession().getAttribute("login");
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		
		MemberDTO mdto = memberService.selectOne(mSeq);
		PageDTO pdto = pageService.selectOne(pSeq);
		
		model.addAttribute("mdto", mdto);
		model.addAttribute("pdto", pdto);
		
		List<EmpTypeDTO> elist = empTypeService.selectList();
		model.addAttribute("elist", elist);
		
		List<WorkTypeDTO> wlist = workTypeService.selectList();
		model.addAttribute("wlist", wlist);
		
		List<IndustryDTO> ilist = industryService.getIndustry();
		model.addAttribute("ilist", ilist);
		
		List<OccupationDTO> olist = occupationService.selectList();
		model.addAttribute("olist", olist);
		
		List<PositionDTO> plist = positionService.selectList();
		model.addAttribute("plist", plist);

		List<JobRankDTO> jlist = jobRankService.selectList();
		model.addAttribute("jlist", jlist);
		
		
		return ViewPath.JOB + "jobPost.jsp";
	}
	
	
	@RequestMapping("/job/jobUpload")
	public String postcheck(Model model, HttpServletRequest request, JobPostDTO jdto) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		jdto.setmSeq(mSeq);
		MemberDTO dto = memberService.selectOne(mSeq);
		int pSeq = jdto.getpSeq();
		PageDTO page = pageService.selectOne(pSeq);
		
		int check = jobPostService.insertPost(jdto);
		
		if(check == 0) {
			String msg = "채용 공고 올리기에 실패하였습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/ithub/page/myPage");
			
			return ViewPath.MEMBER + "result.jsp";
		}
		
		
		List<Map<String,Object>> list = jobPostService.mySelectPost(pSeq);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		
		return ViewPath.PAGE + "myPage.jsp";
	}
	
	@RequestMapping("/job/jobUpdate")
	public String updatePost(HttpServletRequest request, Model model) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		//로그인 상태 아니면 벤
		MemberDTO dto = memberService.selectOne(mSeq);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		JobPostDTO jdto = jobPostService.selectOne(jpostSeq);
		
		model.addAttribute("jdto", jdto);
		model.addAttribute("dto", dto);
		
		List<EmpTypeDTO> elist = empTypeService.selectList();
		model.addAttribute("elist", elist);
		
		List<WorkTypeDTO> wlist = workTypeService.selectList();
		model.addAttribute("wlist", wlist);
		
		List<IndustryDTO> ilist = industryService.getIndustry();
		model.addAttribute("ilist", ilist);
		
		List<OccupationDTO> olist = occupationService.selectList();
		model.addAttribute("olist", olist);
		
		List<PositionDTO> plist = positionService.selectList();
		model.addAttribute("plist", plist);

		List<JobRankDTO> jlist = jobRankService.selectList();
		model.addAttribute("jlist", jlist);
		
		return ViewPath.JOB +"jobUpdate.jsp";
	}
	
	@RequestMapping("/job/checkUpdate")
	public String checkUpdate(Model model, HttpServletRequest request, JobPostDTO jDto) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		jDto.setmSeq(mSeq);
		MemberDTO dto = memberService.selectOne(mSeq);
		
		PageDTO page = pageService.selectOne(jDto.getpSeq());
		
		int updateOne = jobPostService.updatePost(jDto);
		
		if(updateOne == 0) {
			System.out.println("업데이트 실패");
		}
		
		List<Map<String,Object>> list = jobPostService.mySelectPost(jDto.getpSeq());

		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		
		return ViewPath.PAGE + "myPage.jsp";
	}
	
	@RequestMapping("/job/jobDelete")
	public String deletePost(Model model, HttpServletRequest request) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		
		JobPostDTO jdto = new JobPostDTO();
		jdto.setmSeq(mSeq);
		jdto.setJpostSeq(jpostSeq);
		
		boolean check = false;
		
		check = jobPostService.deletePost(jdto);
		if(check) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		List<Map<String,Object>> list = jobPostService.mySelectPost(pSeq);
		
		PageDTO page = pageService.selectOne(pSeq);
		
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		
		return ViewPath.PAGE + "myPage.jsp";
	}
	
	@RequestMapping("/job/jobDetails")
	public String jobDetails(Model model, HttpServletRequest request) {
		
		String check = request.getParameter("check");
		model.addAttribute("check", check);
		
		int mSeq = (int)request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		model.addAttribute("dto", dto);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq")) ;
		JobPostDTO jdto = jobPostService.selectOneDetail(jpostSeq);
		
		model.addAttribute("jdto",jdto);
		return ViewPath.JOB + "jobDetails.jsp";
	}
	
	@RequestMapping("/job/applyForm")
	public String jobApplyForm(Model model, HttpServletRequest request) {
		int mSeq = (int)request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		JobPostDTO jdto = jobPostService.selectOneDetail(jpostSeq);
		
		model.addAttribute("jdto", jdto);
		model.addAttribute("dto", dto);
		
		return ViewPath.JOB + "jobApplyForm.jsp";
	}
	
	@RequestMapping("/job/deleteResume")
	public String deleteResume(Model model, HttpServletRequest request) {
		int jsSeq = Integer.parseInt(request.getParameter("jsSeq"));
		jpostSaveService.deleteResume(jsSeq);
		
		return "redirect:/myProfile.go";
	}
	
	@RequestMapping("/job/updateResumeForm")
	public String updateResumeForm(Model model, HttpServletRequest request) {
		int mSeq = (int)request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		JobPostDTO jdto = jobPostService.selectOneDetail(jpostSeq);
		
		int jsSeq = Integer.parseInt(request.getParameter("jsSeq"));
		JpostSaveDTO jsdto = jpostSaveService.selectOne(jsSeq);
		
		model.addAttribute("jdto", jdto);
		model.addAttribute("dto", dto);
		model.addAttribute("jsdto", jsdto);
		
		return ViewPath.JOB+"updateResumeForm.jsp";
	}
	
	@RequestMapping("/job/applylist")
	public String applylist(Model model, HttpServletRequest request) {
		int mSeq = (int)request.getSession().getAttribute("login");
		MemberDTO dto = memberService.selectOne(mSeq);
		
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		List<MemberDTO> amlist = jpostSaveService.applyList(jpostSeq);
		
		model.addAttribute("dto",dto);
		model.addAttribute("amlist", amlist);
		
		return ViewPath.JOB + "applyList.jsp";
	}
	
	
}