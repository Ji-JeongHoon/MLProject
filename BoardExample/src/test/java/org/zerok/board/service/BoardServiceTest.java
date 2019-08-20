package org.zerok.board.service;

import java.util.List;

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
public class BoardServiceTest {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}

	@Test
	public void testGetListWithPaging(Criteria criteria) {
		service.getListWithPaging(criteria).forEach(board->log.info(board));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로이 만드는 글");
		board.setContents("안녕 잘되는지 보고싶어요");
		board.setWriter("홍말자");
		service.insert(board);
		
		log.info("\nService에서 글 등록하기 테스트합니다.");
		log.info(board);
	}

	@Test
	public void testFindBoardById() {
		BoardVO board = service.findBoardById(222345);
		
		log.info("\n서비스에서 글 찾기 테스트");
		log.info(board);
	}

	@Test
	public void testDeleteBoardById() {
		boolean isDeleted = service.deleteBoardById(23);
		
		log.info("\n---------------------------------------");
		if (isDeleted) {
			log.info("\n삭제되었습니다.");
		} else {
			log.info("\n삭제 실패. 아이디 바꿔서 다시 테스트해 보라구!!!!!!!");
		}
	}

	@Test
	public void testUpdateBoard() {
		BoardVO board = new BoardVO();
		board.setId(6);
		board.setTitle("수정하는 글");
		board.setContents("안녕 잘되는지 보고싶어요");
		board.setWriter("홍춘이");
		boolean isUpdated = service.updateBoard(board);

		log.info("\n---------------------------------------");
		if (isUpdated) {
			log.info("\n수정되었습니다.");
		} else {
			log.info("\n수정 실패. 아이디 바꿔서 다시 테스트해 보라구!!!!!!!");
		}
	}
}
