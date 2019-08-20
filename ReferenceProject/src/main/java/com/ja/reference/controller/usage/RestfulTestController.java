package com.ja.reference.controller.usage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.reference.vo.MemberVO;

import java.util.*;



@Controller
@ResponseBody //포워딩이아니고 AJAX 용.
public class RestfulTestController {

	@RequestMapping("/testRestful")
	public ArrayList<MemberVO> testRest() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		list.add(new MemberVO("1","s1","1","1","1","1","1"));
		list.add(new MemberVO("1","s2","1","1","1","1","1"));
		list.add(new MemberVO("1","s3","1","1","1","1","1"));
		list.add(new MemberVO("1","s4","1","1","1","1","1"));
		list.add(new MemberVO("1","s5","1","1","1","1","1"));
		
		//자바 스크립트 형태의 DATA 로 날려주고싶음. 
		/*
		 * [{m_idx :1, .....}, {...},{...}, ..]
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		return list;
	}
	
}
