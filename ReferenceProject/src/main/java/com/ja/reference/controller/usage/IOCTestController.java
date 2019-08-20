package com.ja.reference.controller.usage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.reference.service.SumService;


@Controller
public class IOCTestController {
	
	
	//의존주입 하는 것. 
	@Autowired
	private SumService sumService;
	
	
	@RequestMapping("/sum")
	public String sumTest(String v1, String v2, Model model) {

		//여기까지가 컨트롤러의 역할. 그 이후 로직은 service 객체가 해야함. 
		int value1 = Integer.parseInt(v1);
		
		int value2 = Integer.parseInt(v2);
		
		int result = sumService.sumProcess(value1, value2);
		
		model.addAttribute("result", result);
		
		
		return "sumResult";
	}
	
	

}










