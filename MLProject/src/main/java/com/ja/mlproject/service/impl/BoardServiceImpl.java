package com.ja.mlproject.service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.mlproject.mapper.BoardMapper;
import com.ja.mlproject.mapper.MemberMapper;
import com.ja.mlproject.service.BoardService;
import com.ja.mlproject.vo.BoardMemberVO;
import com.ja.mlproject.vo.BoardVO;

import com.ja.mlproject.vo.MemberVO;





@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private MemberMapper memberMapper;

	
	@Override
	public ArrayList<BoardMemberVO> getBoardList(String searchWord, String searchTarget) {
		// TODO Auto-generated method stub
		
		ArrayList<BoardMemberVO> dataList = new ArrayList<BoardMemberVO>(); 
		
		ArrayList<BoardVO> contentsList = null;
		
		if(searchTarget == null) {
		contentsList = boardMapper.selectAll();
		}else if(searchTarget.equals("m_nickname")){
			
			MemberVO memberVO = new MemberVO();
			
			memberVO = memberMapper.selectByNickname(searchWord);
			
			String m_idx = memberVO.getM_idx();
			
			contentsList = boardMapper.selectByM_idx(m_idx);
			
			
			
		}else {
			
			contentsList = boardMapper.selectBySearchWord(searchWord, searchTarget); 
			
		}
		for(BoardVO content : contentsList) {
			MemberVO member = memberMapper.selectByIdx(content.getB_idx());		
			
			BoardMemberVO data = new BoardMemberVO(content,member); 
			
			dataList.add(data);
		}
		
		return dataList;
		
			
	}


	@Override
	public BoardMemberVO readContent(BoardVO requestParam) {
		// TODO Auto-generated method stub
		
		BoardVO board = boardMapper.selectByIdx(requestParam.getB_idx());
		MemberVO member = memberMapper.selectByIdx(board.getM_idx());	
	
		return new BoardMemberVO(board,member);
	}


	@Override
	public void deleteContent(BoardVO requestParam) {
		boardMapper.deleteByIdx(requestParam.getB_idx());
		
	}


	@Override
	public void updateContent(BoardVO requestParam) {
		// TODO Auto-generated method stub
		
		boardMapper.updateByIdx(requestParam);
	}


	@Override
	public void writeContent(BoardVO requestParam) {

		boardMapper.insert(requestParam);
		
	}


	
	//조회수 증가.
	@Override
	public void updateCount(BoardVO requestParam) {
		boardMapper.updateCount(requestParam);
	}


	//페이징-전체 게시물 갯수 
	public int boardListCount(BoardVO requestParam) {
		// TODO Auto-generated method stub
		int boardListCount = 0;
		boardListCount = boardMapper.boardListCount();
		return boardListCount;
	}

	//페이징 ..?
	@Override
	public ArrayList<BoardMemberVO> getBoardListWithPaging(String startIdx, String endIdx) {

		
		ArrayList<BoardMemberVO> dataList = new ArrayList<BoardMemberVO>(); 
		
		ArrayList<BoardVO> contentsList = null;
		
		contentsList = boardMapper.selectAllWithPaging(startIdx, endIdx);
		
		for(BoardVO content : contentsList) {
			MemberVO member = memberMapper.selectByIdx(content.getB_idx());		
			
			BoardMemberVO data = new BoardMemberVO(content,member); 
			
			dataList.add(data);
		}
		
		
		
		
		return dataList;
	}

}
