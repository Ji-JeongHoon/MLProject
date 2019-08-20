package com.ja.reference.controller.usage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/member/*")
public class URLMappingTestController {

	
	//@RequestMapping("/board/member/test") 리퀘스트 매핑이 클래스 위에도 붙을 수 있음. 분류할때 씀. 
	@RequestMapping("/test1")
	public String test1() {
		
		System.out.println("test1 호출");
		
		return "test";
	}
	
	
	@RequestMapping("/test2")
	public String test2() {
		
		System.out.println("test2 호출");
		
		return "test";
	}
	
	public String test3() {
		
		return "test";
	}
	
		
}
