package com.increpas.ithub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ithub.bcomment.BcommentDTO;
import com.ithub.bcomment.BcommentService;
import com.ithub.blike.BlikeDTO;
import com.ithub.blike.BlikeService;
import com.ithub.board.BoardDTO;
import com.ithub.board.BoardService;
import com.ithub.common.Paging;
import com.ithub.common.ViewPath;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.memfollow.MemFollowService;
import com.ithub.pagefollow.PageFollowService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemFollowService memFollowService;

	@Autowired
	private PageFollowService pageFollowService;

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BcommentService bcommentService;

	@Autowired
	private BlikeService blikeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, Integer page, String type, String word) {
		try {
			if(request.getSession().getAttribute("login") != null) {
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
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return ViewPath.MAIN + "index.jsp";
	}
}
