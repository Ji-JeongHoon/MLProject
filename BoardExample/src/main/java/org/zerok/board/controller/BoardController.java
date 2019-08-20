package org.zerok.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerok.board.domain.BoardVO;
import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.PageDTO;
import org.zerok.board.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

/*	
	@RequestMapping("/list")
	public void getList(Model model) {
		model.addAttribute("list", service.getList());
	}
*/
	@RequestMapping("/list")
	public void getList(Criteria criteria, Model model) {
		model.addAttribute("list", service.getListWithPaging(criteria));
		int totalCount = service.getTotalCount(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, totalCount));
	}
	
	@GetMapping({"/get", "/update"})
	public void findBoardById(@RequestParam("id") int id, @ModelAttribute("criteria") Criteria criteria, Model model) {
		model.addAttribute("board", service.findBoardById(id));
	}
	
	/* 등록 화면 띄우기 */
	@GetMapping("/insert")
	public void insert() {
	}

	@PostMapping("/insert")
	public String insert(BoardVO board, RedirectAttributes rttr) {
		service.insert(board);
		rttr.addFlashAttribute("result", board.getId());
		return "redirect:/board/list";
	}

	@PostMapping("/update")
	public String updateBoard(BoardVO board, @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr) {
		if (service.updateBoard(board)) {
			rttr.addFlashAttribute("result", board.getId());
		}
		return "redirect:/board/list" + criteria.getListLink();
	}

	@PostMapping("/delete")
	public String deleteBoardById(@RequestParam("id") int id, @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr) {
		if (service.deleteBoardById(id)) {
			rttr.addFlashAttribute("result", id);
		}
		return "redirect:/board/list" + criteria.getListLink();
	}

}
