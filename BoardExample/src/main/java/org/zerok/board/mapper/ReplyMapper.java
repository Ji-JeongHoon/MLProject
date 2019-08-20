package org.zerok.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.ReplyVO;

public interface ReplyMapper {
	public int insertSelectKey(ReplyVO reply);
	
	public int update(ReplyVO reply);
	
	public int delete(int id);

	public ReplyVO findById(int id);

	public int getCountOfReply(@Param("pid") int pid);

	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("pid") int pid
			);
}
