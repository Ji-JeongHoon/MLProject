package com.ja.mlproject.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.mlproject.service.BoardService;
import com.ja.mlproject.vo.BoardMemberVO;
import com.ja.mlproject.vo.BoardVO;
import com.ja.mlproject.vo.Pagination;





@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping("/testBoardPage")
	public String testBoardPage(String startIdx, String endIdx,Model model) {
		
		ArrayList<BoardMemberVO> testlist = boardService.getBoardListWithPaging(startIdx, endIdx);
		
		model.addAttribute("boardDataList", testlist);
		
		return "testBoardPage";
	}
	
	
	@RequestMapping("/boardPage")
	public String BoardPage(Model model,String searchWord, String searchTarget) {
		
	
		
		ArrayList<BoardMemberVO> list = boardService.getBoardList(searchWord,searchTarget);
		
		model.addAttribute("boardDataList",list);
		
		return "boardPage";
		
	}

	@RequestMapping("/readContentPage")
	public String readContentPage(BoardVO requestParam,Model model) {
		
		boardService.updateCount(requestParam);
		
		BoardMemberVO boardData = boardService.readContent(requestParam);
		
		model.addAttribute("boardData" , boardData);
		
		
		return "readContentPage";
	}
	
	
	@RequestMapping("/writeContentPage")
	public String writeContentPage() {
		
		
		return "writeContentPage";
		
	}
	
	@RequestMapping("/writeContentAction")
	public String writeContentAction(BoardVO requestParam){
		
		boardService.writeContent(requestParam);
		
		return "redirect:boardPage";
	}
	
	@RequestMapping("/deleteContentAction")
	public String deleteContentAction(String b_idx) {
		
		BoardVO vo = new BoardVO();
		vo.setB_idx(b_idx);
		
		boardService.deleteContent(vo);
		
		return "redirect:boardPage";
		
		
	}
	
	@RequestMapping("/updateContentPage")
	public String updateContentPage(BoardVO requestParam, Model model) {
		
		BoardMemberVO data = boardService.readContent(requestParam);
		
		model.addAttribute("boardData", data);
		
		
		return "updateContentPage";
	}
	
	@RequestMapping("/updateContentAction")
	public String updateContentAction(BoardVO requestParam) {
		
		
		boardService.updateContent(requestParam);
		
		
		return "redirect:boardPage";
	}
	
	
	
	}
