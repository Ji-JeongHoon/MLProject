package com.ja.mlproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.mlproject.service.LearningService;

@Controller
public class LearningController {
	
	@Autowired
	private LearningService learningService;
	
	@RequestMapping("/programUsingPage")
	public String programUsingPage() {
		
		return "programUsingPage";
	}
	
	
	
}
