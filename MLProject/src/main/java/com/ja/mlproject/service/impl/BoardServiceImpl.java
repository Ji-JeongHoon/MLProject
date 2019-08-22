package com.ja.mlproject.service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.mlproject.mapper.BoardSQLMapper;
import com.ja.mlproject.mapper.MemberSQLMapper;
import com.ja.mlproject.service.BoardService;
import com.ja.mlproject.vo.BoardMemberVO;
import com.ja.mlproject.vo.BoardVO;

import com.ja.mlproject.vo.MemberVO;
import com.ja.mlproject.vo.PagingVO;





@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;

	
	@Override
	public ArrayList<BoardMemberVO> getBoardList(PagingVO requestParam) {
		// TODO Auto-generated method stub
		
		ArrayList<BoardMemberVO> dataList = new ArrayList<BoardMemberVO>(); 
		
		ArrayList<BoardVO> contentsList = null;
		
		if(requestParam.getSearchTarget() == null) {
			contentsList = boardSQLMapper.selectAllWithPaging(requestParam);
			
			//닉네임검색
		}else if(requestParam.getSearchTarget().equals("m_nickname")){
			
			MemberVO memberVO = new MemberVO();
			
			memberVO = memberSQLMapper.selectByNickname(requestParam.getSearchWord());
			
			String m_idx = memberVO.getM_idx();
			
			requestParam.setM_idx(m_idx);
			
			contentsList = boardSQLMapper.selectByM_idx(requestParam);
			
			
			//제목, 내용검색
		}else {
			
			contentsList = boardSQLMapper.selectBySearchWord(requestParam);
			
		}
		
		
		for(BoardVO content : contentsList) {
			MemberVO member = memberSQLMapper.selectByIdx(content.getM_idx());		
			BoardMemberVO data = new BoardMemberVO(content, member); 
			
			dataList.add(data);
		}
		
		return dataList;
		
			
	}


	@Override
	public BoardMemberVO readContent(BoardVO requestParam) {
		// TODO Auto-generated method stub
		
		BoardVO board = boardSQLMapper.selectByIdx(requestParam.getB_idx());
		MemberVO member = memberSQLMapper.selectByIdx(board.getM_idx());	
	
		return new BoardMemberVO(board,member);
	}


	@Override
	public void deleteContent(BoardVO requestParam) {
		boardSQLMapper.deleteByIdx(requestParam.getB_idx());
		
	}


	@Override
	public void updateContent(BoardVO requestParam) {
		// TODO Auto-generated method stub
		
		boardSQLMapper.updateByIdx(requestParam);
	}


	@Override
	public void writeContent(BoardVO requestParam) {

		boardSQLMapper.insert(requestParam);
		
	}


	
	//조회수 증가.
	@Override
	public void updateCount(BoardVO requestParam) {
		boardSQLMapper.updateCount(requestParam);
	}


	//페이징-전체 게시물 갯수 
	public int boardListCount() {
		// TODO Auto-generated method stub
		
		return boardSQLMapper.boardListCount();
	}

	//페이징 ..?
	@Override
	public ArrayList<BoardMemberVO> getBoardListWithPaging(PagingVO vo) {

		
		ArrayList<BoardMemberVO> dataList = new ArrayList<BoardMemberVO>(); 
		
		ArrayList<BoardVO> contentsList = null;
		
		contentsList = boardSQLMapper.selectAllWithPaging(vo);
		
		for(BoardVO content : contentsList) {
			MemberVO member = memberSQLMapper.selectByIdx(content.getB_idx());		
			
			BoardMemberVO data = new BoardMemberVO(content,member); 
			
			dataList.add(data);
		}
		
		
		return dataList;
	}


	@Override // 검색된 게시물 갯수 세기
	public int countSearchWord(PagingVO vo) {
		// TODO Auto-generated method stub
		return boardSQLMapper.countSearchWord(vo);
	}


	@Override
	public int countSearchNick(PagingVO vo) {
		// TODO Auto-generated method stub
		return boardSQLMapper.countSearchNick(vo);
	}

}