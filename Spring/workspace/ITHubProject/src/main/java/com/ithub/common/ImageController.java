package com.ithub.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ithub.jpostsave.JpostSaveDTO;
import com.ithub.jpostsave.JpostSaveService;
import com.ithub.member.MemberDTO;
import com.ithub.member.MemberService;
import com.ithub.page.PageDTO;
import com.ithub.page.PageService;

@Controller
public class ImageController {

	@Autowired // 자동 주입
	private MemberService memberService;
	@Autowired // 자동 주입
	private ServletContext application;
	@Autowired
	private PageService pageService;
	@Autowired
	private JpostSaveService jpostSaveService;
	

	@RequestMapping("/member/backPic")
	public String backPic(Model model, HttpServletRequest request, MemberDTO dto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		dto.setmSeq(mSeq);
		
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		MultipartFile fileBackPic = dto.getFileBackPic();
		String mBackpic = null;
		
		if(!fileBackPic.isEmpty() || fileBackPic==null) {
			mBackpic = fileBackPic.getOriginalFilename();
			mBackpic = mSeq + "userBackPic" + mBackpic.substring(mBackpic.lastIndexOf("."),mBackpic.length());
			File saveFile = new File(savePath, mBackpic);

			//업로드된 파일 저장할 때 코드
			if(!saveFile.exists()) {//경로에 파일이 없다면
				saveFile.mkdir();
			}else {
				long time = System.currentTimeMillis();
				mBackpic = String.format("%s%d%s", mBackpic.substring(0,mBackpic.lastIndexOf(".")),time,mBackpic.substring(mBackpic.lastIndexOf(".")));
				saveFile = new File(savePath,mBackpic);
			}
			
			try {
				fileBackPic.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setmBackpic(mBackpic);
		}
		memberService.backPicUpdate(dto);
		
		dto = memberService.selectOne(mSeq);
		
		return "redirect:/myProfile.go";
	}
	
	@RequestMapping("/member/mPic")
	public String mPic(Model model, HttpServletRequest request, MemberDTO dto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		dto.setmSeq(mSeq);
		
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		MultipartFile filePic = dto.getFilePic();
		String mPic = null;
		
		if(!filePic.isEmpty()) {
			mPic = filePic.getOriginalFilename();
			mPic = mSeq + "usermPic" + mPic.substring(mPic.lastIndexOf("."),mPic.length());
			File saveFile = new File(savePath, mPic);
			
			//업로드된 파일 저장할 때 코드
			if(!saveFile.exists()) {//경로에 파일이 없다면
				saveFile.mkdir();
			}else {
				long time = System.currentTimeMillis();
				mPic = String.format("%s%d%s", mPic.substring(0,mPic.lastIndexOf(".")),time,mPic.substring(mPic.lastIndexOf(".")));
				saveFile = new File(savePath,mPic);
			}
			
			try {
				filePic.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setmPic(mPic);
		}
		memberService.mPicUpdate(dto);
		
		dto = memberService.selectOne(mSeq);
		
		return "redirect:/myProfile.go";
	}

	@RequestMapping("/page/backPic")
	public String pbackPic(Model model, HttpServletRequest request, PageDTO pdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		
		pdto.setpSeq(pSeq);
		
		// pPic(페이지 로고)
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		
		MultipartFile backPic = pdto.getBackPic();

		String backName = null;

		if (!backPic.isEmpty() || backPic==null) {
			backName = backPic.getOriginalFilename();
			backName = mSeq + "pageLogo" + backName.substring(backName.lastIndexOf("."),backName.length());
			
			// File 객체 생성
			File saveFile = new File(savePath, backName);

			if (!saveFile.exists()) { // 경로에 파일이 없으면
				saveFile.mkdirs();
			} else { // 있으면
				long time = System.currentTimeMillis();

				backName = String.format("%s%d%s", backName.substring(0, backName.lastIndexOf(".")), time,
						backName.substring(backName.lastIndexOf(".")));

				saveFile = new File(savePath, backName);
			}

			// 업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시저장소에 저장되어 있다...
			// 파일이 일정시간이 지나면 사라지기때문에 내가 지정한 경로로 복사해준다...
			try {
				backPic.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			pdto.setpBackpic(backName);
		}
		
		pageService.pBackpicUpdate(pdto);
		
		pdto = pageService.selectOne(pdto.getpSeq());
		
		MemberDTO dto = memberService.selectOne(mSeq);
		List<PageDTO> myPage = pageService.getPage(mSeq);
		
		model.addAttribute("page", pdto);
		model.addAttribute("dto", dto);
		model.addAttribute("myPage", myPage);
		
		return ViewPath.PAGE + "myPage.jsp";
	}
	
	@RequestMapping("/page/pPic")
	public String pPic(Model model, HttpServletRequest request, PageDTO pdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		int pSeq = Integer.parseInt(request.getParameter("pSeq"));
		System.out.println(pSeq);
		
		pdto.setpSeq(pSeq);
		
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
		
		pageService.pPicUpdate(pdto);
		
		pdto = pageService.selectOne(pdto.getpSeq());
		
		MemberDTO dto = memberService.selectOne(mSeq);
		List<PageDTO> myPage = pageService.getPage(mSeq);
		
		model.addAttribute("page", pdto);
		model.addAttribute("dto", dto);
		model.addAttribute("myPage", myPage);
		
		List<JpostSaveDTO> myJoblist = jpostSaveService.myApplies(mSeq);
		model.addAttribute("myJoblist", myJoblist);
		
		return ViewPath.PAGE + "myPage.jsp";
	}
	
	@RequestMapping("/job/jobApply")
	public String jobApply(Model model, HttpServletRequest request, JpostSaveDTO jsdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		MultipartFile file = jsdto.getFile();
		String fileSave = null;
		
		if(!file.isEmpty() || file==null) {
			fileSave = file.getOriginalFilename();
			fileSave = mSeq + "userResume" + fileSave.substring(fileSave.lastIndexOf("."),fileSave.length());
			File saveFile = new File(savePath, fileSave);

			//업로드된 파일 저장할 때 코드
			if(!saveFile.exists()) {//경로에 파일이 없다면
				saveFile.mkdir();
			}else {
				long time = System.currentTimeMillis();
				fileSave = String.format("%s%d%s", fileSave.substring(0,fileSave.lastIndexOf(".")),time,fileSave.substring(fileSave.lastIndexOf(".")));
				saveFile = new File(savePath,fileSave);
			}
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jsdto.setFileSave(fileSave);
		}
		int check = jpostSaveService.check(jsdto);
		
		if(check >= 1) {
			String msg = "이미 지원중인 공고 입니다";
			String url = "/ithub/job/jobList";
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			
			return ViewPath.MEMBER + "result.jsp";
		}
		jpostSaveService.insertResume(jsdto);
		
		return "redirect:/myProfile.go";
	}
	
	@RequestMapping("/job/updateResume")
	public String updateResume(Model model, HttpServletRequest request, JpostSaveDTO jsdto) {
		int mSeq = (int)request.getSession().getAttribute("login");
		int jpostSeq = Integer.parseInt(request.getParameter("jpostSeq"));
		jsdto.setmSeq(mSeq);
		jsdto.setJpostSeq(jpostSeq);
		
		//String savePath = application.getRealPath("/resources/upload/");
		String savePath = "/var/lib/tomcat9/file_repo/";
		
		MultipartFile file = jsdto.getFile();
		String fileSave = null;
		System.out.println(file);
		if(!file.isEmpty() || file==null) {
			fileSave = file.getOriginalFilename();
			fileSave = mSeq + "userResume" + fileSave.substring(fileSave.lastIndexOf("."),fileSave.length());
			File saveFile = new File(savePath, fileSave);

			//업로드된 파일 저장할 때 코드
			if(!saveFile.exists()) {//경로에 파일이 없다면
				saveFile.mkdir();
			}else {
				long time = System.currentTimeMillis();
				fileSave = String.format("%s%d%s", fileSave.substring(0,fileSave.lastIndexOf(".")),time,fileSave.substring(fileSave.lastIndexOf(".")));
				saveFile = new File(savePath,fileSave);
			}
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			jsdto.setFileSave(fileSave);
		}
		jpostSaveService.updateResume(jsdto);
		
		return "redirect:/myProfile.go";
	}
	
}
