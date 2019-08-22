package com.ja.mlproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.mlproject.service.MemberService;
import com.ja.mlproject.vo.MemberVO;
import com.ja.mlproject.vo.SessionVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/joinMemberPage")
	public String joinMemberPage() {
		return "joinMemberPage";
	}
	
	@RequestMapping("/joinMemberAction")
	public String joinMemberAction(MemberVO requestParam) {
		memberService.joinMemberProcess(requestParam);

		return "redirect:joinMemberWaitingPage";
	}
	
	@RequestMapping("/joinMemberWaitingPage")
	public String joinMemberWaitingPage() {
		return "joinMemberWaitingPage";
	}
	
	@RequestMapping("/joinMemberConfirmAction")
	public String joinMemberConfirmAction(MemberVO requestParam) {
		memberService.joinConfirmProcess(requestParam);
		
		return "redirect:joinMemberConfirmPage";
	}
	
	@RequestMapping("/joinMemberConfirmPage")
	public String joinMemberConfirmPage() {
		return "joinMemberConfirmPage";
	}
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(MemberVO requestParam, HttpSession session) {
		SessionVO sessionVO = memberService.loginProcess(requestParam);
		if(sessionVO != null) {
			session.setAttribute("sessionData", sessionVO);
			return "redirect:mainPage";
		}else {
			
			return "redirect:loginPage?login=failed";
		}
	}
	
	@RequestMapping("/logoutAction")
	public String logoutAction(HttpSession session) {
		session.invalidate();
		
		return "redirect:mainPage";
	}
}
