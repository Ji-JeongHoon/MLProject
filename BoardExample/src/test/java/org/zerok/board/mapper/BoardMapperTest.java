package org.zerok.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerok.board.domain.BoardVO;
import org.zerok.board.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {org.zerok.board.config.RootConfig.class})
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
/*	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로이 만드는 글");
		board.setContents("안녕 잘되는지 보고싶어요");
		board.setWriter("홍말자");
		mapper.insert(board);
		
		log.info("kiusdrgadsoiufghaoesfg$$$$$$$$$$$$$$");
		log.info(board);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로이 만드는 글 by SelectKey");
		board.setContents("안녕 잘되는지 보고싶어요 by SelectKey");
		board.setWriter("홍말자");
		mapper.insertSelectKey(board);

		log.info("ki*****************$$$$");
		log.info(board);
	}

	@Test
	public void testFindBoardById() {
		BoardVO board = mapper.findBoardById(2);
		
		log.info("ki*!!!!!!!!!!!!!!!!!!!*$$$$");
		log.info(board);
	}
	@Test
	public void testDeleteBoardById() {
		int delCnt = mapper.deleteBoardById(2);
		
		log.info("\n---------------------------------------");
		log.info("\n" + delCnt + "건 삭제되었습니다.");
	}
	@Test
	public void testUpdateBoard() {
		BoardVO board = new BoardVO();
		board.setId(6);
		board.setTitle("수정하는 글");
		board.setContents("안녕 잘되는지 보고싶어요");
		board.setWriter("홍춘이");
		int uptCny = mapper.updateBoard(board);

		log.info("\n+++++++++++++++");
		log.info("\n" + uptCny + "건 수정되었습니다.");
	}

	@Test
	public void testGetListWithPaging() {
		Criteria criteria = new Criteria(1, 10);
		criteria.setType("TC");
		criteria.setKeyword("수정");
		mapper.getListWithPaging(criteria).forEach(board->log.info(board));
	}

	@Test
	public void testGetListWithPaging2() {
		Criteria criteria = new Criteria(1, 10);
		mapper.getListWithPaging(criteria).forEach(board->log.info(board));
	}

	@Test
	public void testGetListWithPaging() {
		Criteria criteria = new Criteria(1, 10);
		criteria.setType("TC");
		criteria.setKeyword("수정");
		mapper.getListWithPaging(criteria).forEach(board->log.info(board));
	}

	@Test
	public void testTotal() {
		Criteria criteria = new Criteria(1, 10);
		criteria.setType("TC");
		criteria.setKeyword("수정");
		int total = mapper.getTotalCount(criteria);
		log.info("\n조회한 전체 개수는" + total);
	}
*/

	@Test
	public void testGetListWithPaging() {
		Criteria criteria = new Criteria(1, 10);
		criteria.setType("TCW");
		criteria.setKeyword("제목");
		mapper.getListWithPaging(criteria).forEach(board->log.info(board));
	}
}
