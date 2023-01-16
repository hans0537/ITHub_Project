package com.ithub.memfollow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.mtomhit.MtomhitDTO;
//import com.ithub.mtomhit.MtomhitService;
import com.ithub.page.PageDTO;
import com.ithub.pagefollow.PageFollowService;

@Controller
public class MemFollowController {

	private MemberService memberService;
	private MemFollowService memFollowService;
	
	@Autowired
	private PageFollowService pageFollowService;
	
	@Autowired
//	private MtomhitService mtomhitService;
	
	public MemFollowController(MemberService memberService, MemFollowService memFollowService) {
		this.memberService = memberService;
		this.memFollowService = memFollowService;
	}

	
	@RequestMapping("/member/memFollow")
	public String follow(Model model, HttpServletRequest request) {
		
		int mySeq = (int)request.getSession().getAttribute("login");
		int otherSeq = Integer.parseInt(request.getParameter("mSeq"));		// 팔로우하는 회원 시퀀스
		MemFollowDTO dto = new MemFollowDTO();
		dto.setFollowSeq(mySeq);				// 내 시퀀스
		dto.setFollowerSeq(otherSeq);			// 팔로우하는 회원 시퀀스
		memFollowService.memFollow(dto);		// 팔로우
		
		List<Integer> followlist = memFollowService.mySelect(mySeq);		// 내가 팔로우한 회원 시퀀스
		model.addAttribute("followlist",followlist);
		
		List<Integer> flist = pageFollowService.selectm(mySeq);		// 내가 팔로우하는 페이지 시퀀스
		model.addAttribute("flist",flist);
		
		MemberDTO mdto = memberService.selectOne(mySeq);		// 내정보
		model.addAttribute("dto",mdto);
		
		List<MemberDTO> mlist = null;
		List<PageDTO> plist = null;
		
		String path = request.getParameter("path");				// 팔로워리스트로 가는지 팔로우리스트로 가는지( fr / fw)
		
		if("fr".equals(path)) {							// 팔로워리스트로 갈때
			
			String user = request.getParameter("user");		// 나or내가만든페이지의 팔로워를 보는지 다른사람or다른페이지의 팔로워를 보는지( me / other)
			String mp = request.getParameter("mp");					// 사람의 팔로워를 보는지 페이지의 팔로워를 보는지
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		//*조회하는 사람or페이지의 시퀀스(나,다른사람,내페이지,다른페이지 포함)
			
			if("me".equals(user)) {						// 나or내가만든페이지의 팔로워를 볼때
				
				if("m".equals(mp)) {					// 나의 팔로워를 볼때
					mlist = memFollowService.followerList(cSeq);		// 나를 팔로우한 회원 정보(cSeq가 mySeq)
				}else if("p".equals(mp)) {				// 내가만든페이지의 팔로워를 볼때
					mlist = memFollowService.pfollowerList(cSeq);		// 내가만든페이지를 팔로우한 회원 정보(cSeq가 pSeq)
				}
				
			}else if("other".equals(user)){				// 다른사람or다른페이지의 팔로워를 볼때
				
				if("m".equals(mp)) {							// 다른 사람의 팔로워를 볼때
					mlist = memFollowService.followerList(cSeq);		// 다른사람(지금 보고있는 회원)을 팔로우한 회원 정보
				}else if("p".equals(mp)) {						// 다른 페이지의 팔로워를 볼때
					mlist = memFollowService.pfollowerList(cSeq);		// 다른페이지(지금 보고있는 페이지)를 팔로우한 회원 정보
				}
				
			}
			model.addAttribute("user", user);
			model.addAttribute("mp", mp);
			model.addAttribute("cSeq", cSeq);
			model.addAttribute("mlist", mlist);
			
			return ViewPath.FOLLOW + "followerList.jsp";
			
		}else if("fw".equals(path)) {						// 팔로우리스트로 갈때
			
			String user = request.getParameter("user");					// 내 팔로우를 보는지 다른사람의 팔로우를 보는지( me / other)
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		// 지금 보고있는 회원의 시퀀스	//*조회하는 사람의 시퀀스(나, 다른사람)
			
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
			
		}else if("hit".equals(path)) {						// 조회자 리스트로 갈때
			
//			List<MtomhitDTO> hitList = mtomhitService.hitSelect(mySeq);	// 내 프로필을 본사람 리스트(조회자)
//			model.addAttribute("hitList", hitList);
			
			List<MemberDTO> list = memberService.selectAll();			// 모든 회원 리스트
			model.addAttribute("list", list);
			
			return ViewPath.MEMBER + "hitList.jsp";
		}
			
		List<MemberDTO> list = memberService.selectAll();		// 모든회원 리스트(userlist에서 필요)
		model.addAttribute("list",list);
		
		return ViewPath.MEMBER + "userList.jsp";
			
		
		
	}
	
	@RequestMapping("/member/memunFollow")
	public String unfollow(Model model, HttpServletRequest request) {
		
		int mySeq = (int)request.getSession().getAttribute("login");
		int otherSeq = Integer.parseInt(request.getParameter("mSeq"));		// 언팔하는 회원 시퀀스
		MemFollowDTO dto = new MemFollowDTO();
		dto.setFollowSeq(mySeq);			// 내 시퀀스
		dto.setFollowerSeq(otherSeq);		// 언팔하는 회원 시퀀스
		memFollowService.unFollow(dto);				// 회원 언팔
		
		List<Integer> followlist = memFollowService.mySelect(mySeq);		// 내가 팔로우한 회원 시퀀스
		model.addAttribute("followlist",followlist);
		
		List<Integer> flist = pageFollowService.selectm(mySeq);		// 내가 팔로우하는 페이지 시퀀스
		model.addAttribute("flist",flist);
		
		MemberDTO mdto = memberService.selectOne(mySeq);		// 내정보
		model.addAttribute("dto",mdto);
		
		List<MemberDTO> mlist = null;
		List<PageDTO> plist = null;
		
		String path = request.getParameter("path");				// 팔로워리스트로 가는지 팔로우리스트로 가는지( fr / fw)
		
		if("fr".equals(path)) {							// 팔로워리스트로 갈때
			
			String user = request.getParameter("user");		// 나or내가만든페이지의 팔로워를 보는지 다른사람or다른페이지의 팔로워를 보는지( me / other)
			String mp = request.getParameter("mp");					// 사람의 팔로워를 보는지 페이지의 팔로워를 보는지
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		//*조회하는 사람or페이지의 시퀀스(나,다른사람,내페이지,다른페이지 포함)
			
			if("me".equals(user)) {						// 나or내가만든페이지의 팔로워를 볼때
				
				if("m".equals(mp)) {					// 나의 팔로워를 볼때
					mlist = memFollowService.followerList(cSeq);		// 나를 팔로우한 회원 정보(cSeq가 mySeq)
				}else if("p".equals(mp)) {				// 내가만든페이지의 팔로워를 볼때
					mlist = memFollowService.pfollowerList(cSeq);		// 내가만든페이지를 팔로우한 회원 정보(cSeq가 pSeq)
				}
				
			}else if("other".equals(user)){				// 다른사람or다른페이지의 팔로워를 볼때
				
				if("m".equals(mp)) {							// 다른 사람의 팔로워를 볼때
					mlist = memFollowService.followerList(cSeq);		// 다른사람(지금 보고있는 회원)을 팔로우한 회원 정보
				}else if("p".equals(mp)) {						// 다른 페이지의 팔로워를 볼때
					mlist = memFollowService.pfollowerList(cSeq);		// 다른페이지(지금 보고있는 페이지)를 팔로우한 회원 정보
				}
				
			}
			model.addAttribute("user", user);
			model.addAttribute("mp", mp);
			model.addAttribute("cSeq", cSeq);
			model.addAttribute("mlist", mlist);
			
			return ViewPath.FOLLOW + "followerList.jsp";
			
		}else if("fw".equals(path)) {						// 팔로우리스트로 갈때
			
			String user = request.getParameter("user");					// 내 팔로우를 보는지 다른사람의 팔로우를 보는지( me / other)
			int cSeq = Integer.parseInt(request.getParameter("cSeq"));		// 지금 보고있는 회원의 시퀀스	//*조회하는 사람의 시퀀스(나, 다른사람)
			
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
			
		}else if("hit".equals(path)) {						// 조회자 리스트로 갈때
			
//			List<MtomhitDTO> hitList = mtomhitService.hitSelect(mySeq);	// 내 프로필을 본사람 리스트(조회자)
//			model.addAttribute("hitList", hitList);
			
			List<MemberDTO> list = memberService.selectAll();			// 모든 회원 리스트
			model.addAttribute("list", list);
			
			return ViewPath.MEMBER + "hitList.jsp";
		}
			
		List<MemberDTO> list = memberService.selectAll();		// 모든회원 리스트(userlist에서 필요)
		model.addAttribute("list",list);
		
		return ViewPath.MEMBER + "userList.jsp";
			
		
		
	}
	
	@RequestMapping("/follow/followList") 
	public String mfollowList(Model model, HttpServletRequest request) {
		
		int mySeq = (int)request.getSession().getAttribute("login");
		
		List<Integer> followlist = memFollowService.mySelect(mySeq);		// 내가 팔로우한 회원 시퀀스
		model.addAttribute("followlist",followlist);
		
		List<Integer> flist = pageFollowService.selectm(mySeq);		// 내가 팔로우하는 페이지 시퀀스
		model.addAttribute("flist",flist);
		
		MemberDTO mdto = memberService.selectOne(mySeq);		// 내정보
		model.addAttribute("dto",mdto);	

		List<MemberDTO> mlist = null;
		List<PageDTO> plist = null;
		
		String user = request.getParameter("user");			// 나의 팔로우를 보는지 다른사람의 팔로우를 보는지( me / other)
		int cSeq = Integer.parseInt(request.getParameter("cSeq"));
		if("me".equals(user)) {						// 나의 팔로우를 볼때
			
			mlist = memFollowService.followList(cSeq);				// 내가 팔로우한 회원 정보
			plist = memFollowService.pfollowList(cSeq);			// 내가 팔로우한 페이지 정보
			
		}else if("other".equals(user)) {			// 다른사람의 팔로우를 볼때
			
			mlist = memFollowService.followList(cSeq);			// 지금 보고있는 회원이 팔로우한 회원 정보
			plist = memFollowService.pfollowList(cSeq);			// 지금 보고있는 회원이 팔로우한 페이지 정보
		}
		model.addAttribute("user", user);
		model.addAttribute("cSeq", cSeq);
		model.addAttribute("mlist", mlist);
		model.addAttribute("plist", plist);
		return ViewPath.FOLLOW + "followList.jsp";
	}

	@RequestMapping("/follow/followerList") 
	public String mfollowerList(Model model, HttpServletRequest request) {
		
		int mySeq = (int)request.getSession().getAttribute("login");

		List<Integer> followlist = memFollowService.mySelect(mySeq);		// 내가 팔로우한 회원 시퀀스
		model.addAttribute("followlist",followlist);
		
		MemberDTO mdto = memberService.selectOne(mySeq);		// 내정보
		model.addAttribute("dto",mdto);							
		
		List<MemberDTO> mlist = null;
		
		String user = request.getParameter("user");				// 나or내가만든페이지의 팔로워를 보는지 다른사람or다른페이지의 팔로워를 보는지( me / other)
		String mp = request.getParameter("mp");
		int cSeq = Integer.parseInt(request.getParameter("cSeq"));
		if("me".equals(user)) {							// 나or내가만든페이지의 팔로워를 볼때
			
			if("m".equals(mp)) {					// 나의 팔로워를 볼때
				mlist = memFollowService.followerList(cSeq);		// 나를 팔로우한 회원 정보(cSeq가 mySeq)
			}else if("p".equals(mp)) {				// 내가만든페이지의 팔로워를 볼때
				mlist = memFollowService.pfollowerList(cSeq);		// 내가만든페이지를 팔로우한 회원 정보(cSeq가 pSeq)
			}
			
		}else if("other".equals(user)) {				// 다른사람or다른페이지의 팔로워를 볼때
			
			if("m".equals(mp)) {							// 다른 사람의 팔로워를 볼때
				mlist = memFollowService.followerList(cSeq);		// 다른사람(지금 보고있는 회원)을 팔로우한 회원 정보
			}else if("p".equals(mp)) {						// 다른 페이지의 팔로워를 볼때
				mlist = memFollowService.pfollowerList(cSeq);		// 다른페이지(지금 보고있는 페이지)를 팔로우한 회원 정보
			}
			
		}
		model.addAttribute("user", user);
		model.addAttribute("mp", mp);
		model.addAttribute("cSeq", cSeq);
		model.addAttribute("mlist", mlist);
		
		return ViewPath.FOLLOW + "followerList.jsp";
	}

}
