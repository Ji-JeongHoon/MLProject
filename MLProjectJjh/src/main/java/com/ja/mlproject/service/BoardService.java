package com.ja.mlproject.service;

import java.util.ArrayList;

import com.ja.mlproject.vo.BoardMemberVO;

import com.ja.mlproject.vo.BoardVO;




public interface BoardService {
	
	
	//전체출력
	public ArrayList<BoardMemberVO> getBoardList(String searchWord, String searchTarget);
	
	//페이징
	public ArrayList<BoardMemberVO> getBoardListWithPaging(String startIdx, String endIdx);
	
	//글읽기
	public BoardMemberVO readContent(BoardVO requestParam);
	
	//조회수 증가
	public void updateCount(BoardVO requestParam);
	
	public int boardListCount(BoardVO requestParam);
	
	//글삭제
	public void deleteContent(BoardVO requestParam);
	
	//글 수정
	public void updateContent(BoardVO requestParam);
	
	//글 쓰기
	public void writeContent(BoardVO requestParam);
	
	
	
}
