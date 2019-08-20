package org.zerok.board.service;

import java.util.List;

import org.zerok.board.domain.BoardVO;
import org.zerok.board.domain.Criteria;

public interface BoardService {
	public int getTotalCount(Criteria criteria);

	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria criteria);
	
	public BoardVO findBoardById(int id);

	public void insert(BoardVO board);

	public boolean updateBoard(BoardVO board);

	public boolean deleteBoardById(int id);
}
