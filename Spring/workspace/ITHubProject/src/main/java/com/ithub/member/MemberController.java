package com.ithub.member;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithub.board.BoardService;
import com.ithub.career.CareerDTO;
import com.ithub.career.CareerService;
import com.ithub.city.CityDTO;
import com.ithub.common.ViewPath;
import com.ithub.country.CountryDTO;
import com.ithub.country.CountryService;
import com.ithub.education.EducationDTO;
import com.ithub.education.EducationService;
import com.ithub.jpostsave.JpostSaveService;
import com.ithub.memfollow.MemFollowService;
import com.ithub.mtomhit.MtomhitDTO;
import com.ithub.mtomhit.MtomhitService;
import com.ithub.page.PageService;
import com.ithub.pagefollow.PageFollowService;
import com.ithub.ptomhit.PtomhitDTO;
import com.ithub.ptomhit.PtomhitService;

@Controller
public class MemberController {

	private MemberService memberService;
	
	@Autowired // 자동 주입
	private CountryService countryService;
	@Autowired // 자동 주입
	private PageService pageService;
	@Autowired // 자동 주입
	private ServletContext application;
	@Autowired // 자동 주입
	private MemFollowService memFollowService;
	@Autowired // 자동 주입
	private PageFollowService pageFollowService;
	@Autowired // 자동 주입
	private MtomhitService mtomhitService;
	@Autowired // 자동 주입
	private PtomhitService ptomhitService;
	@Autowired // 자동 주입
	private BoardService boardService;
	@Autowired // 자동 주입
	private CareerService careerService;
	@Autowired // 자동 주입
	private EducationService educationService;

	@Autowired // 자동 주입
	private JpostSaveService jpostSaveService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 로그인 
	@RequestMapping("/login/loginForm")
	public String loginForm(HttpServletRequest request) {
		
		String mEmail = request.getParameter("mEmail");
		
		boolean check = false;
		if(mEmail == null) {
			Cookie[] cks = request.getCookies();
			if(cks !=null) {
				for(Cookie ck :cks) {
					if(ck.getName().equals("ckid")) {
						mEmail = ck.getValue();
						check = true;
						break;
					}
				}
			}
			if(mEmail == null) {
				mEmail = "";
			}
		}
		request.setAttribute("mEmail", mEmail);
		request.setAttribute("check", check);
		
		return ViewPath.MAIN;
	}
	
	// 로그인 체크
	@RequestMapping("/login/checkLogin")
	public String checkLogin(Model model, HttpServletRequest request, HttpServletResponse response, MemberDTO dto, Integer page, String type, String word) {
		int mSeq = memberService.checkLogin(dto);
		
		String msg = "";
		boolean check = false;
		if(mSeq != 0) {
			dto = memberService.selectOne(mSeq);
			msg = dto.getmFirstname() + "님이 어서오시고~";
			check = true;
			
			request.getSession().setAttribute("login",mSeq);
			
			String ckid = request.getParameter("ckid");
			Cookie ck = null;
			Cookie[] cks = request.getCookies();
			
			if(cks != null) {
				for(Cookie c : cks) {
					if(c.getName().equals("ckid")) {
						ck = c;
						break;
					}
				}
			}
			if(ckid != null) {
				if(ck == null) {
					ck = new Cookie("ckid",dto.getmEmail());
					ck.setPath("/");
					ck.setMaxAge(60*60*24);
					response.addCookie(ck);
				}else {
					if(!ck.getValue().equals(dto.getmEmail())){
						ck.setValue(dto.getmEmail());
						response.addCookie(ck);
					}
				}
			}else{
				if(ck !=null) {
					if(ck.getValue().equals(dto.getmEmail())) {
						ck.setMaxAge(0);
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			}
			
		}else {
			msg = "아이디 혹은 비번이 틀렸습니다";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/ithub/");
			
			return ViewPath.MEMBER + "result.jsp";
		}
		
		return "redirect:/main.go";
	}
	
	@RequestMapping("/member/logout")
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("url", "/ithub/");
		
		return ViewPath.MEMBER + "result.jsp";
	}

	@RequestMapping("/member/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response,String mEmail, String mPw) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		MemberDTO dto = memberService.selectOne(mSeq);
		
		String msg = "";
		String url = "";
		
		if(!dto.getmEmail().equals(mEmail)) {
			msg = "이메일이 틀렸는데요? ㅋㅋㅋㅋㅋ";
			url = "/ithub/member/accountSetting";
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return ViewPath.MEMBER + "result.jsp";
		}
		
		if(!dto.getmPw().equals(mPw)) {
			msg = "비밀번호 틀렸는데요? ㅋㅋㅋㅋㅋ";
			url = "/ithub/member/accountSetting";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return ViewPath.MEMBER + "result.jsp";
		} 
		
		System.out.println("됨1?");
		int check = memberService.delete(mSeq);
		System.out.println("됨2?");
//			System.out.println(check);
		
		if(check != 0) {
			System.out.println("됨3?");
			Cookie[] cks = request.getCookies();
			System.out.println("됨4?");
			if(cks != null) {
				System.out.println("됨?5");
				for(Cookie ck : cks) {
					System.out.println("됨?6");
					if(ck.getName().equals("ckid")) {
						System.out.println("됨?7");
						if(ck.getValue().equals(dto.getmEmail())) {
							System.out.println("됨?8");
							ck.setMaxAge(0);
							ck.setPath("/");
							response.addCookie(ck);
							break;
						}
					}
				}
			}
			System.out.println("됨?9");
			request.getSession().invalidate();
			System.out.println("됨?10");
			msg = "탈퇴되었습니다. 다음에 또 봐요~";
			url = "/ithub/";
			System.out.println("됨11?");
		} else {
			msg = "탈퇴에 실패하였습니다. 가지마요..";
			url = "/ithub/member/accountSetting";
			System.out.println("됨12?");
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		System.out.println("됨?13");
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	// 내프로필 조회
	@RequestMapping("/member/profile")
	public String profile(Model model, HttpServletRequest request) {
		return "redirect:/myProfile.go";
	}

	// 상대 프로필 조회
	@RequestMapping("/member/userProfile")
	public String userProfile(Model model, HttpServletRequest request) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		int otherSeq = Integer.parseInt(request.getParameter("otherSeq"));
		
		// 조회 insert
		MtomhitDTO hit = new MtomhitDTO();
		hit.setMhitSeq(otherSeq);		//조회한 프로필
		hit.setmSeq(mSeq);				//본사람
		
		mtomhitService.delete(hit);		
		mtomhitService.insert(hit);		//중복이면 최신화
		
		List<MtomhitDTO> hitList = mtomhitService.hitSelect(otherSeq);	// 조회한 프로필을 본사람 리스트(조회자)
		model.addAttribute("hitList", hitList);
		
		List<MemberDTO> list = memberService.selectAll();				// 모든 회원 리스트
		model.addAttribute("list", list);								//.......그냥해본거....
		
		MemberDTO dto = memberService.selectOne(mSeq);
		MemberDTO otherDto = memberService.selectOne(otherSeq);
		int flw = memFollowService.followCnt(otherDto.getmSeq());
		int flr = memFollowService.followerCnt(otherDto.getmSeq());
		int pflw = pageFollowService.followCnt(otherDto.getmSeq());
		
		otherDto.setFollowing((flw + pflw));
		otherDto.setFollower(flr);
		model.addAttribute("dto",dto);
		model.addAttribute("otherDto",otherDto);
		
		return ViewPath.MEMBER + "userProfile.jsp";
	}
	
	@RequestMapping("/member/findForm")
	public String findForm() {
		return ViewPath.MEMBER + "findForm.jsp";
	}
	
	@RequestMapping("/member/find")
	public String find(Model model, MemberDTO dto, String mode) {
		
		String find = null;
		if(dto.getmEmail() == null){
			find = memberService.findEmail(dto);
		}else{
			find = memberService.findPw(dto);	
		}
		
		boolean check = false;
		if(find != null){
			check = true;
			String re = "";
			for(int i = 0; i < find.length(); i++){
				if(i < 4){
					re += find.charAt(i);
				}else{
					re += "*";
				}
			}
			
			if(mode.equals("email")){
				model.addAttribute("mEmail", find);
			}else{
				model.addAttribute("mPw", re);	
			}
			
		}
		
		model.addAttribute("check", check);
		
		return ViewPath.MEMBER + "findResult.jsp";
	}
	
	@RequestMapping("/member/joinForm") 
	public String joinForm(Model model, HttpServletRequest request) {
		List<CountryDTO> country = countryService.getCountry();
		List<CityDTO> city = countryService.getCity();

		for (int i = 0; i < country.size(); i++) {
			for (int j = 0; j < city.size(); j++) {
				if(city.get(j).getcSeq() == country.get(i).getcSeq()) {
					country.get(i).getCity().add(city.get(j));
				}
			}
		}
		
		String e = request.getParameter("e");
		String f = request.getParameter("f");
		String l = request.getParameter("l");
		String h = request.getParameter("h");
		String idx = request.getParameter("idx");
		
		model.addAttribute("e", e);
		model.addAttribute("f", f);
		model.addAttribute("l", l);
		model.addAttribute("h", h);
		model.addAttribute("idx", idx);
		model.addAttribute("country", country);
		return ViewPath.MEMBER + "joinForm.jsp";
	}
	
	
	@RequestMapping("/member/join")
	public String join(Model model, MemberDTO dto) {
		int su = memberService.insert(dto);
//		System.out.println(su);
		String msg = null;
		String url = null;
		
		
		if(su != 0) {
			msg = "축하드립니다! 회원가입이 완료되었습니다.";
//			url = "/ithub?email=" + dto.getmEmail();
			url = "/ithub/";
		} else {
			msg = "이메일이 중복 됩니다.";
			url = "/ithub/member/joinForm";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	@RequestMapping("/member/accountSetting")
	public String accountSetting(Model model, HttpServletRequest request) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		MemberDTO dto = memberService.selectOne(mSeq);
		
		model.addAttribute("dto",dto);
		return ViewPath.MEMBER + "accountSetting.jsp";
	}

	@RequestMapping("/member/introUpdate")
	public String introUpdate(Model model, HttpServletRequest request, MemberDTO dto) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		
		dto.setmSeq(mSeq);

		memberService.introUpdate(dto);
		
		return "redirect:/myProfile.go";
	}

	@RequestMapping("/member/userList")
	public String userList(Model model, HttpServletRequest request) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		
		List<MemberDTO> list = memberService.selectAll();
		List<Integer> followlist = memFollowService.mySelect(mSeq);
		
		MemberDTO dto = memberService.selectOne(mSeq);
		
		model.addAttribute("dto",dto);
		model.addAttribute("list",list);
		model.addAttribute("followlist",followlist);
		
		return ViewPath.MEMBER + "userList.jsp";
	}
	
	
	@RequestMapping("/member/hitList")
	public String hitList(Model model, HttpServletRequest request) {
		
		int mSeq = (int)request.getSession().getAttribute("login");
		String pSeq = request.getParameter("pSeq");
		
		List<Integer> followlist = memFollowService.mySelect(mSeq);
		model.addAttribute("followlist",followlist);
		
		List<MemberDTO> list = memberService.selectAll();			// 모든 회원 리스트
		model.addAttribute("list", list);
		
		if(pSeq != null) {
			List<PtomhitDTO> hitList = ptomhitService.hitSelect(Integer.parseInt(pSeq));	// 내 페이지를 본 사람 리스트
			model.addAttribute("hitList", hitList);
		}else {
			List<MtomhitDTO> hitList = mtomhitService.hitSelect(mSeq);	// 내 프로필을 본사람 리스트(조회자)
			model.addAttribute("hitList", hitList);
		}
		
		return ViewPath.MEMBER + "hitList.jsp";
	}
	
	
	@RequestMapping("/career/insert")
	@ResponseBody
	public List<CareerDTO> carInsert(@RequestBody CareerDTO dto, Model model, HttpServletRequest request){
		
		int mSeq = (Integer)request.getSession().getAttribute("login");
		
		dto.setmSeq(mSeq);
		
		careerService.insert(dto);
		
		List<CareerDTO> myCareer = careerService.myCareer(mSeq);
		
		return myCareer;
	}
	
	@RequestMapping("/career/delete")
	@ResponseBody
	public List<CareerDTO> carDelete(@RequestBody CareerDTO dto, Model model, HttpServletRequest request){
		
		int mSeq = (Integer)request.getSession().getAttribute("login");
		
		careerService.delete(dto);
		
		List<CareerDTO> myCareer = careerService.myCareer(mSeq);
		
		return myCareer;
	}
	
	@RequestMapping("/edu/insert")
	@ResponseBody
	public List<EducationDTO> eduInsert(@RequestBody EducationDTO dto, Model model, HttpServletRequest request){
		
		int mSeq = (Integer)request.getSession().getAttribute("login");
		
		dto.setmSeq(mSeq);
		
		educationService.insert(dto);
		
		List<EducationDTO> myEdu = educationService.myEdu(mSeq);
		
		return myEdu;
	}
}
