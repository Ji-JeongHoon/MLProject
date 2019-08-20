package org.zerok.board.service;

import org.springframework.stereotype.Service;
import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.ReplyPageDTO;
import org.zerok.board.domain.ReplyVO;
import org.zerok.board.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper mapper;

	@Override
	public ReplyVO findById(int id) {
		return mapper.findById(id);
	}

	@Override
	public ReplyPageDTO getListWithPaging(Criteria cri, int pid) {
		return new ReplyPageDTO(mapper.getCountOfReply(pid), mapper.getListWithPaging(cri, pid));
	}
	
	@Override
	public int insertSelectKey(ReplyVO reply) {
		return mapper.insertSelectKey(reply);
	}

	@Override
	public boolean update(ReplyVO reply) {
		return mapper.update(reply) != 0;
	}
	
	@Override
	public boolean delete(int id) {
		return mapper.delete(id) != 0;
	}
	
}
