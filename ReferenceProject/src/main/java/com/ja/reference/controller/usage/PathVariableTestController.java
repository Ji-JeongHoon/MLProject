package com.ja.reference.controller.usage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PathVariableTestController {
	
	//url 을 변수처럼 쓰겠다.  {cat} 자리에는 문자열 / {pid} 에는 숫자 쓰면 ?하는 것처럼 날라옴. 
	@GetMapping("/produce/{cat}/{pid}")
	public String method1(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
		
			System.out.println("cat = " + cat);
			System.out.println("pid = " + pid);
		
		
		return "test";
	}
	
	
	
}
