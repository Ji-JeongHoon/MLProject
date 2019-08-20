package com.ja.springex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.springex.service.MemberService;
import com.ja.springex.vo.MemberVO;
import com.ja.springex.vo.SessionDataVO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService; 	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "loginForm";
	}

	@RequestMapping("/joinMemberForm")
	public String joinMemberForm() {
		return "joinMemberForm";
	}
	
	@RequestMapping("/joinMemberAction")
	public String joinMemberAction(MemberVO vo) {
		
		memberService.joinMember(vo);
		
		return "redirect:loginForm";
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(MemberVO vo , HttpSession session) {
		
		SessionDataVO sessionData = memberService.loginProcess(vo);
		
		if(sessionData != null) {
			//로그인 성공..
			session.setAttribute("sessionData", sessionData);
			
			return "redirect:boardPage";
			
		}else {
			//로그인 실패..
		}
		
		return "loginFail";
	}
	
	@RequestMapping("/logoutAction")
	public String logoutAction(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:boardPage";
	}
	
	
}

















