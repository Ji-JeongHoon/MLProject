package org.zerok.board.mapper;

import java.util.List;

import org.zerok.board.domain.BoardVO;
import org.zerok.board.domain.Criteria;

public interface BoardMapper {
	public int getTotalCount(Criteria criteria);
	
	//@Select("select * from t_board where id < 100")

	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria criteria);

	public BoardVO findBoardById(int id);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);

	public int updateBoard(BoardVO board);
	/* 몇건 삭제 되었지? */
	public int deleteBoardById(int id);
}
