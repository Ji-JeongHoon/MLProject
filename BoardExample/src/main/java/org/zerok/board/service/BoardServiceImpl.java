package org.zerok.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerok.board.domain.BoardVO;
import org.zerok.board.domain.Criteria;
import org.zerok.board.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	private BoardMapper mapper;
	
	@Override
	public int getTotalCount(Criteria criteria) {
		return mapper.getTotalCount(criteria);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria criteria) {
		return mapper.getListWithPaging(criteria);
	}

	@Override
	public BoardVO findBoardById(int id) {
		return mapper.findBoardById(id);
	}

	@Override
	public void insert(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		return mapper.updateBoard(board) != 0;
	}

	@Override
	public boolean deleteBoardById(int id) {
		return mapper.deleteBoardById(id) != 0;
	}

}
