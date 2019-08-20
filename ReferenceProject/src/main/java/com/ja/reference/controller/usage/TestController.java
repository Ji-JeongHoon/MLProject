package com.ja.reference.controller.usage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ja.reference.controller.usage.vo.DataVO;

@Controller
public class TestController {
	
	//가장 일반적인 방법.......
	//@RequestMapping(value = "test1", method=RequestMethod.GET)
	@RequestMapping("/test1")
	public String defaultMethod(DataVO data, Model model, HttpSession session) {
		
		
		System.out.println("넘어온 값 v1 : " + data.getV1());
		System.out.println("넘어온 값 v2 : " + data.getV2());
		
		session.setAttribute("nick", "한조");
		
		
		String str = "무언가 값이 만들어짐. ";

		
		model.addAttribute("strValue", str);
		
		//test.jsp 로 포워딩 됨. 리턴 문자열로 포워딩.. /WEB-INF/views/test.jsp 로 포워딩됨. 
		return "test";
		
		
	}
	
	//일반적인 방법 두번째. (param 으로 받을 변수가 한개 두개 일때 굳이 datavo 를 만들어야돼?? ㅇㅇ)
	@RequestMapping("/test3")
	public String defaultMethod2(String v1, Model model) {
		
		System.out.println("넘어온 값 : " + v1);
		
		//리다이렉트 redirect 써주면 끝.
		return "redirect:test1";
	}
	
	
	//v1으로 넘어온 값을 data1로 받고 싶을때. 
	@RequestMapping("/test4")
	public String defaultMethod3(@RequestParam("v1") String data1, String data2) {
		
		
		
		
		return "test";
		
	}
	
	
	//나머지 기타등등..
	@RequestMapping("/test2")
	public void test2() {
		//return 타입이 void 인 경우...... test2로 포워딩됨.
		
		
	}
	@RequestMapping("/test5")
	public ModelAndView test5() {
		
		ModelAndView mv = new ModelAndView();
		
		String str = "만들어진 어떤 값.. ";
		
		mv.addObject("strValue", str);
		
		mv.setViewName("test");
		
		return mv;
	}
	@RequestMapping("/test6")
	public String test6(HttpServletRequest req, HttpServletResponse res) {
		
		
		return "test";
	}
	
	//
	

}
