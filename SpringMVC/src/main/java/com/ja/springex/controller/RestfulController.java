package com.ja.springex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.springex.service.MemberService;
import com.ja.springex.vo.MemberVO;
import com.ja.springex.vo.RestResponseDataVO;

@Controller
@ResponseBody
public class RestfulController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/testRest")
	public String test() {
		
		
		
		
		//Responsebody 가 붙어있으면 aaa.jsp 로 포워딩시키는게 아니라 "aaaa" 라는 문자열이 그대로 날라감. html 코드가 안날라감. 
		return "AAAA";
	}

	//restful api 잘 활용하는 법?
	//1. 서버 컨트롤러 구현. - JSON 타입으로 DATA 전달..
	//2. AJAX(자바 스크립트) 로 호출. 
	//3. 의미 있는 DATA 를 받고.. 의도에 맞게 UI 를 JAVAscript 로 만들어낸다..
	
	
	
	@RequestMapping("/isExistID")
	public RestResponseDataVO isExistID(MemberVO requestParam) {
		
		RestResponseDataVO result = new RestResponseDataVO();
		
		
		if(memberService.isExistID(requestParam)) {
			result.setExist(true);
			result.setReason("왜인지 모르겠지만 있다..");
		}
		
		return result; 
	}
}
