package com.ithub.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.admindept.AdminDeptDTO;
import com.ithub.bcomment.BcommentDTO;
import com.ithub.bcomment.BcommentService;
import com.ithub.board.BoardDTO;
import com.ithub.board.BoardService;
import com.ithub.common.Paging;
import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.memberqna.MemberqnaDTO;
import com.ithub.memfollow.MemFollowService;
import com.ithub.mtomhit.MtomhitDTO;
import com.ithub.mtomhit.MtomhitService;
import com.ithub.page.PageDTO;
import com.ithub.page.PageService;
import com.ithub.pagefollow.PageFollowService;
import com.ithub.ptomhit.PtomhitDTO;
import com.ithub.ptomhit.PtomhitService;
import com.ithub.qnaanswer.QnaanswerDTO;
import com.ithub.servicecategory.ServiceCategoryDTO;
import com.ithub.servicecategory.ServiceCategoryService;
import com.ithub.topic.TopicDTO;
import com.ithub.topic.TopicService;

@Controller
public class AdminController {

	private AdminService adminService;
	
	@Autowired // 자동 주입
	private ServletContext application;
	@Autowired // 자동 주입
	private BcommentService bcommentService;
	@Autowired // 자동 주입
	private BoardService boardService;
	@Autowired // 자동 주입
	private ServiceCategoryService serviceCategoryService;
	@Autowired // 자동 주입
	private TopicService topicService;
	@Autowired // 자동 주입
	private MemFollowService memFollowService;
	@Autowired // 자동 주입
	private PageFollowService pageFollowService;
	@Autowired // 자동 주입
	private MtomhitService mtomhitService;
	@Autowired // 자동 주입
	private PtomhitService ptomhitService;
	@Autowired // 자동 주입
	private MemberService memberService;
	@Autowired // 자동 주입
	private PageService pageService;
	
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	// 관리자 로그인 
	@RequestMapping("/admin/adminLogin")
	public String adminLogin() {
		return ViewPath.ADMIN + "adminLogin.jsp";
	}
	
	// 관리자 로그인 체크
	@RequestMapping("/admin/checkLogin")
	public String checkLogin(Model model, HttpServletRequest request, HttpServletResponse response, AdminDTO dto, Integer page, String type, String word) {
		int adminSeq = adminService.checkLogin(dto);
		
		String msg = "";
		boolean check = false;
		if(adminSeq != 0) {
			dto = adminService.selectOne(adminSeq);
			msg = dto.getAdminName() + "님이 어서오시고~";
			check = true;
			
			request.getSession().setAttribute("admin",adminSeq);
			
			String ckid = request.getParameter("adckid");
			Cookie ck = null;
			Cookie[] cks = request.getCookies();
			
			if(cks != null) {
				for(Cookie c : cks) {
					if(c.getName().equals("adckid")) {
						ck = c;
						break;
					}
				}
			}
			if(ckid != null) {
				if(ck == null) {
					ck = new Cookie("adckid",dto.getAdminId());
					ck.setPath("/");
					ck.setMaxAge(60*60*24);
					response.addCookie(ck);
				}else {
					if(!ck.getValue().equals(dto.getAdminId())){
						ck.setValue(dto.getAdminId());
						response.addCookie(ck);
					}
				}
			}else{
				if(ck !=null) {
					if(ck.getValue().equals(dto.getAdminId())) {
						ck.setMaxAge(0);
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			}
			
		}else {
			msg = "아이디 혹은 비번이 틀렸습니다";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/ithub/admin/adminLogin");
			
			return ViewPath.MEMBER + "result.jsp";
		}
		
		return "redirect:/adminMain.go";
	}
	
	// 관리자 로그아웃
	@RequestMapping("/admin/logout")
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("url", "/ithub/");
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	// 관리자 권한 게시글 삭제
	@RequestMapping("/admin/boardDelete")
	public String delete(HttpServletRequest request) throws Exception{
		
		int boardSeq = Integer.parseInt(request.getParameter("boardSeq"));
		
		adminService.boardDelete(boardSeq);
		
		request.setAttribute("msg", "해당 게시물은 영구 삭제 되었습니다.");
		request.setAttribute("url", "/ithub/adminMain.go");
		
		return ViewPath.MEMBER + "result.jsp";
		
	}

	// 관리자 페이지 게시글 관리
	@RequestMapping("/admin/adminpMain")
	public String adminpMain(Model model, HttpServletRequest request, Integer page, String type, String word){
		
		int adminSeq = (int)request.getSession().getAttribute("admin");

		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);

		List<AdminDeptDTO> adlist = adminService.deptList();
		model.addAttribute("adlist", adlist);

		List<AdminDTO> alist = adminService.selectAdminAll();
		for (int i = 0; i < alist.size(); i++) {
			alist.get(i).setDeptName(adlist.get(alist.get(i).getDeptSeq() - 1).getDeptName());
		}
		model.addAttribute("alist", alist);
		
		// type이랑 ""랑 같냐? 참 null, 거짓 type
		type = "".equals(type) ? null : type;

		word = "".equals(word) ? null : word;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("type", type);
		map.put("word", word);

		if(page == null) {
			page = 1;
		}

		int boardCount = adminService.boardpTotal(map);
		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		// 5개씩 뽑아버리기
		List<BoardDTO> list2 = adminService.boardpList(map);

		List<PageDTO> plist = adminService.selectPageAll();
		for (int i = 0; i < list2.size(); i++) {
			for (int j = 0; j < plist.size(); j++) {
				if(plist.get(j).getpSeq() == list2.get(i).getpSeq()) {
					list2.get(i).setpPic(plist.get(j).getpPic());
					list2.get(i).setpName(plist.get(j).getpName());
				}
			}
		}
		
		model.addAttribute("list2", list2);
		model.addAttribute("paging", paging);
		
		// 댓글부분
		List<BcommentDTO> bclist = bcommentService.selectAll();
		model.addAttribute("bclist",bclist);

		// 댓글 갯수
		List<BoardDTO> bcCount = boardService.bcCount();
		model.addAttribute("bcCount",bcCount);
		return ViewPath.ADMIN + "adminpMain.jsp";
		
	}
	
	// 페이지 리스트
	@RequestMapping("/admin/adminPageList")
	public String pageList(Model model, HttpServletRequest request) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		int pType = Integer.parseInt(request.getParameter("pType"));
		
		List<PageDTO> list = adminService.pTypeList(pType);
		request.setAttribute("list", list);
		request.setAttribute("pType", pType);
		
		return ViewPath.ADMIN + "adminPageList.jsp";
	}
	
	// 관리자 권한 페이지(회사) 삭제
	@RequestMapping("/admin/pageDelete")
	public String pageDelete(HttpServletRequest request) throws Exception{
		
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		int pType = Integer.parseInt(request.getParameter("pType"));
		adminService.pageDelete(pSeq);
		
		String url = "/ithub/admin/adminPageList?pType=" + pType;
		
		request.setAttribute("msg", "해당 페이지(회사)는 영구 삭제 되었습니다.");
		request.setAttribute("url", url);
		
		return ViewPath.MEMBER + "result.jsp";
		
	}
	
	// 페이지 리스트
	@RequestMapping("/admin/adminUserList")
	public String userList(Model model, HttpServletRequest request) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		List<MemberDTO> list = adminService.selectMemAll();
		request.setAttribute("list", list);
		
		return ViewPath.ADMIN + "adminUserList.jsp";
	}
	

	// 관리자 권한 페이지(회사) 삭제
	@RequestMapping("/admin/userDelete")
	public String userDelete(HttpServletRequest request) throws Exception{
		
		int mSeq = Integer.parseInt(request.getParameter("mSeq"));
		adminService.memDelete(mSeq);
		
		request.setAttribute("msg", "해당 회원은 영구 삭제 되었습니다.");
		request.setAttribute("url", "/ithub/admin/adminUserList");
		
		return ViewPath.MEMBER + "result.jsp";
		
	}

	// 채용정보 리스트
	@RequestMapping("/admin/adminJobList")
	public String jobList(Model model, HttpServletRequest request) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		
		return ViewPath.ADMIN + "adminJobList.jsp";
		
	}

	// 
	@RequestMapping("/admin/adminServiceCenter")
	public String ServiceCenter(Model model, HttpServletRequest request) {
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		List<ServiceCategoryDTO> scatelist = serviceCategoryService.selectList();
		List<TopicDTO> tolist = topicService.selectList();		
		
		request.setAttribute("scatelist", scatelist);
		request.setAttribute("tolist", tolist);
		
		return ViewPath.ADMIN + "adminServiceCenter.jsp";
	}
	
	// 채용정보 리스트
	@RequestMapping("/admin/adminQnACenter")
	public String QnACenter(Model model, HttpServletRequest request, Integer page, String type, String word) {
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		// type이랑 ""랑 같냐? 참 null, 거짓 type
		type = "".equals(type) ? null : type;
		
		word = "".equals(word) ? null : word;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("type", type);
		map.put("word", word);
		
		if(page == null) {
			page = 1;
		}
		
		int qnaCount = 0;
		
		qnaCount = adminService.qnaCnt(map);
		

		Paging paging = new Paging(page, qnaCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		// 5개씩 뽑아버리기
		List<Map<String,Object>> qnaList = adminService.memQnAList(map);
		
		request.setAttribute("mqlist", qnaList);
		request.setAttribute("paging", paging);
		
		List<ServiceCategoryDTO> scatelist = serviceCategoryService.selectList();
		List<TopicDTO> tolist = topicService.selectList();		
		
		request.setAttribute("scatelist", scatelist);
		request.setAttribute("tolist", tolist);
		request.setAttribute("mqlist", qnaList); 
		request.setAttribute("dto", dto);
		
		request.setAttribute("scatelist", scatelist);
		request.setAttribute("tolist", tolist);
		
		return ViewPath.ADMIN + "adminQnACenter.jsp";
	}
	
	@RequestMapping("/admin/qnaAnswer")
	public String qnaWrite(HttpServletRequest request, Model model) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		int mqnaSeq = Integer.parseInt(request.getParameter("mqnaSeq"));
		MemberqnaDTO mqdto = adminService.qnaSelect(mqnaSeq);
		model.addAttribute("mqdto",mqdto);
		
		return ViewPath.ADMIN + "adminQnAans.jsp";
	}
	
	@RequestMapping("/admin/qnaAns")
	public String qnaWrite(HttpServletRequest request, QnaanswerDTO qadto, Model model) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		qadto.setAdminSeq(adminSeq);
		
		adminService.qnaAns(qadto);
		adminService.qnaState(qadto.getMqnaSeq());
		
		return "redirect:/admin/adminQnACenter";
	}
	
	@RequestMapping("/admin/qnaDelete")
	public String qnaDelete(HttpServletRequest request,MemberqnaDTO mqdto) {
		int mqnaSeq = Integer.parseInt(request.getParameter("mqnaSeq"));

		adminService.qnaDelete(mqnaSeq);
		
		return "redirect:/admin/adminQnACenter";
	}
	
	// 페이지 프로필
	@RequestMapping("/admin/adminPageProfile")
	public String pageProfile(Model model, HttpServletRequest request) {
		
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		int pSeq = Integer.parseInt(request.getParameter("pSeq").replaceAll("\'", ""));
		
		List<PtomhitDTO> hitList = ptomhitService.hitSelect(pSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> list = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("list", list);	
		
		PageDTO pdto = pageService.selectOne(pSeq);
		
		int flr = pageFollowService.followerCnt(pSeq);
		
		pdto.setpFollower(flr);
		
		model.addAttribute("page",pdto);
		
		return ViewPath.ADMIN + "adminPageProfile.jsp";
	}
		
	// 유저 프로필 조회
	@RequestMapping("/admin/adminUserProfile")
	public String userProfile(Model model, HttpServletRequest request) {
		int adminSeq = (int)request.getSession().getAttribute("admin");
		AdminDTO dto = adminService.selectOne(adminSeq);
		model.addAttribute("dto",dto);
		
		
		int otherSeq = Integer.parseInt(request.getParameter("otherSeq"));
		
		List<MtomhitDTO> hitList = mtomhitService.hitSelect(otherSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> list = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("list", list);								//.......그냥해본거....
		
		MemberDTO otherDto = memberService.selectOne(otherSeq);
		int flw = memFollowService.followCnt(otherDto.getmSeq());
		int flr = memFollowService.followerCnt(otherDto.getmSeq());
		int pflw = pageFollowService.followCnt(otherDto.getmSeq());
		
		otherDto.setFollowing((flw + pflw));
		otherDto.setFollower(flr);
		model.addAttribute("dto",dto);
		model.addAttribute("otherDto",otherDto);
		
		return ViewPath.ADMIN + "adminUserProfile.jsp";
	}
}
