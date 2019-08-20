package org.zerok.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerok.board.domain.Criteria;
import org.zerok.board.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {org.zerok.board.config.RootConfig.class})
@Log4j
public class ReplyMapperTest {
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	public void testInsertSelectKey() {
		ReplyVO reply = new ReplyVO();
		reply.setPid(3);
		reply.setContents("안녕2");
		reply.setWriter("홍말자");
		mapper.insertSelectKey(reply);

		log.info("ki*****************$$$$");
		log.info(reply);
	}

	@Test
	public void testGetList() {
		Criteria cri = new Criteria(3, 3);
		List<ReplyVO> listResult = mapper.getListWithPaging(cri, 3);
		if (listResult == null) {
			System.out.println("내가 잘못 알고있었다는...");
		} else if (listResult.isEmpty()) {
			System.out.println("그렇지!!!");
		} else {
			System.out.println("다른 원글 선택해 봐요");
		}
		log.info("ki*****************$$$$");
		listResult.forEach(r->log.info(r));
	}
}
