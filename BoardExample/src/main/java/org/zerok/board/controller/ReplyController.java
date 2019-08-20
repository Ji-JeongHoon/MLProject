package org.zerok.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.ReplyPageDTO;
import org.zerok.board.domain.ReplyVO;
import org.zerok.board.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/replies/")
public class ReplyController {
	@Setter(onMethod_ = @Autowired)
	private ReplyService service;

	@PostMapping(value="/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		int cnt = service.insertSelectKey(replyVO);
		
		return cnt == 1 ?
			new ResponseEntity<> ("success", HttpStatus.OK)
			: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value="/{id}",
			produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> findById(
			@PathVariable("id") int id) 
	{
		ReplyVO result = service.findById(id);
		
		return new ResponseEntity<> (result, HttpStatus.OK);
	}

	@GetMapping(value="/pages/{pid}/{page}/{pageSize}",
			produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("pid") int pid,
			@PathVariable("page") int page,
			@PathVariable("pageSize") int pageSize) 
	{
		Criteria cri = new Criteria(page, pageSize);
		ReplyPageDTO replyPageDTO = service.getListWithPaging(cri, pid);
		
		return new ResponseEntity<> (replyPageDTO, HttpStatus.OK);
	}

	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
			value="/{id}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(
			@RequestBody ReplyVO reply,
			@PathVariable("id") int id) 
	{
		reply.setId(id);
		boolean result = service.update(reply);
		
		return result ? new ResponseEntity<> ("success", HttpStatus.OK)
				: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping(value="/{id}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(
			@PathVariable("id") int id) 
	{
		boolean result = service.delete(id);
		
		return result ? new ResponseEntity<> ("success", HttpStatus.OK)
				: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
