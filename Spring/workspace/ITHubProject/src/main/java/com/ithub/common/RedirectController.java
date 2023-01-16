package com.ithub.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.admin.AdminDTO;
import com.ithub.admin.AdminService;
import com.ithub.admindept.AdminDeptDTO;
import com.ithub.bcomment.BcommentDTO;
import com.ithub.bcomment.BcommentService;
import com.ithub.blike.BlikeDTO;
import com.ithub.blike.BlikeService;
import com.ithub.board.BoardDTO;
import com.ithub.board.BoardService;
import com.ithub.career.CareerDTO;
import com.ithub.career.CareerService;
import com.ithub.city.CityDTO;
import com.ithub.country.CountryDTO;
import com.ithub.country.CountryService;
import com.ithub.education.EducationDTO;
import com.ithub.education.EducationService;
import com.ithub.emptype.EmpTypeDTO;
import com.ithub.emptype.EmpTypeService;
import com.ithub.industry.IndustryDTO;
import com.ithub.industry.IndustryService;
import com.ithub.jpostsave.JpostSaveDTO;
import com.ithub.jpostsave.JpostSaveService;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.memfollow.MemFollowService;
import com.ithub.mtomhit.MtomhitDTO;
import com.ithub.mtomhit.MtomhitService;
import com.ithub.page.PageDTO;
import com.ithub.page.PageService;
import com.ithub.pagefollow.PageFollowService;
import com.ithub.position.PositionDTO;
import com.ithub.position.PositionService;
import com.ithub.ptomhit.PtomhitService;

@Controller
public class RedirectController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemFollowService memFollowService;
	@Autowired
	private PageFollowService pageFollowService;
	@Autowired
	private BoardService boardService;
	@Autowired // 자동 주입
	private PageService pageService;
	@Autowired // 자동 주입
	private MtomhitService mtomhitService;
	@Autowired // 자동 주입
	private PtomhitService ptomhitService;
	@Autowired // 자동 주입
	private JpostSaveService jpostSaveService;
	@Autowired
	private BcommentService bcommentService;
	@Autowired
	private BlikeService blikeService;
	@Autowired
	private CareerService careerService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private EmpTypeService empTypeService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private EducationService educationService;

	@RequestMapping("/adminMain.go")
	public String adminMain(Model model, HttpServletRequest request, Integer page, String type, String word) {
		try {
			if(request.getSession().getAttribute("admin") != null) {

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

				int boardCount = adminService.boardmTotal(map);
				Paging paging = new Paging(page, boardCount);

				map.put("first", paging.getFirst());
				map.put("last", paging.getLast());

				// 5개씩 뽑아버리기
				List<BoardDTO> list2 = adminService.boardmList(map);

				model.addAttribute("list2", list2);
				model.addAttribute("paging", paging);

				// 댓글부분
				List<BcommentDTO> bclist = bcommentService.selectAll();
				model.addAttribute("bclist",bclist);

				// 댓글 갯수
				List<BoardDTO> bcCount = boardService.bcCount();
				model.addAttribute("bcCount",bcCount);
				return ViewPath.ADMIN + "adminMain.jsp";
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return ViewPath.ADMIN + "adminLogin.jsp";
	}


	@RequestMapping("/main.go")
	public String main(Model model, HttpServletRequest request, Integer page, String type, String word) {
		int mSeq = (int)request.getSession().getAttribute("login");

		MemberDTO dto = memberService.selectOne(mSeq);
		int flw = memFollowService.followCnt(dto.getmSeq());
		int flr = memFollowService.followerCnt(dto.getmSeq());
		int pflw = pageFollowService.followCnt(dto.getmSeq());

		dto.setFollowing((flw + pflw));
		dto.setFollower(flr);
		model.addAttribute("dto",dto);

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

		int boardCount = boardService.getTotal(map);
		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		// 5개씩 뽑아버리기
		List<BoardDTO> list2 = boardService.selectList(map);

		model.addAttribute("list2", list2);
		model.addAttribute("paging", paging);

		// 댓글부분
		List<BcommentDTO> bclist = bcommentService.selectAll();
		model.addAttribute("bclist",bclist);

		// 댓글 갯수
		List<BoardDTO> bcCount = boardService.bcCount();
		model.addAttribute("bcCount",bcCount);
		
		// 좋아요
		List<BlikeDTO> myLike = blikeService.myLike(mSeq);
		model.addAttribute("myLike", myLike);
		
		List<BoardDTO> likeCount = boardService.likeCount();
		model.addAttribute("likeCount", likeCount);
		return ViewPath.MAIN + "main/main.jsp";
	}

	@RequestMapping("/myProfile.go")
	public String myProfile(Model model, HttpServletRequest request, Integer page, String type, String word) {

		int mSeq = (int)request.getSession().getAttribute("login");

		MemberDTO dto = memberService.selectOne(mSeq);

		List<PageDTO> myPage = pageService.getPage(mSeq);
		model.addAttribute("myPage",myPage);

		List<MtomhitDTO> hitList = mtomhitService.hitSelect(mSeq);	// 내 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);

		List<MemberDTO> list = memberService.selectAll();			// 모든 회원 리스트
		model.addAttribute("list", list);

		int flw = memFollowService.followCnt(dto.getmSeq());
		int flr = memFollowService.followerCnt(dto.getmSeq());
		int pflw = pageFollowService.followCnt(dto.getmSeq());

		dto.setFollowing((flw + pflw));
		dto.setFollower(flr);

		model.addAttribute("dto",dto);

		List<JpostSaveDTO> myJoblist = jpostSaveService.myApplies(mSeq);
		model.addAttribute("myJoblist", myJoblist);

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

		int boardCount = boardService.getMyTotal(map);
		Paging paging = new Paging(page, boardCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		// 5개씩 뽑아버리기
		List<BoardDTO> list2 = boardService.selectList(map);

		model.addAttribute("list2", list2);
		model.addAttribute("paging", paging);
		
		// 커리어
		List<CareerDTO> myCareer = careerService.myCareer(mSeq);
		model.addAttribute("myCareer", myCareer);
		
		List<PositionDTO> position = positionService.selectList();
		model.addAttribute("position", position);
		List<EmpTypeDTO> emptype = empTypeService.selectList();
		model.addAttribute("emptype", emptype);
		List<IndustryDTO> industry = industryService.getIndustry();
		model.addAttribute("industry", industry);
		
		List<CountryDTO> country = countryService.getCountry();
		List<CityDTO> city = countryService.getCity();

		for (int i = 0; i < country.size(); i++) {
			for (int j = 0; j < city.size(); j++) {
				if(city.get(j).getcSeq() == country.get(i).getcSeq()) {
					country.get(i).getCity().add(city.get(j));
				}
			}
		}
		
		model.addAttribute("country", country);
		
		List<PageDTO> eduList = pageService.pTypeAll(1);
		model.addAttribute("eduList", eduList);
		
		List<EducationDTO> myEdu = educationService.myEdu(mSeq);
		model.addAttribute("myEdu", myEdu);
		
		return ViewPath.MEMBER + "myProfile.jsp";
	}


}
