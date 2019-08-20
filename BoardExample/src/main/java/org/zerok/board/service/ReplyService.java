package org.zerok.board.service;

import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.ReplyPageDTO;
import org.zerok.board.domain.ReplyVO;

public interface ReplyService {

	public ReplyVO findById(int id);
	
	public ReplyPageDTO getListWithPaging(Criteria criteria, int pid);
	
	public int insertSelectKey(ReplyVO reply);

	public boolean update(ReplyVO reply);

	public boolean delete(int id);
}
