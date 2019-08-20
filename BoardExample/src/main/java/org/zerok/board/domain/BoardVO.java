package org.zerok.board.domain;

import java.util.Date;

import org.ivar.framework.DisplayControl;
import org.ivar.framework.DisplayControlHelper;

import lombok.Data;

@Data
public class BoardVO {
	@DisplayControl(caption="#번호", order=0, primary = true)
	private int id;
	@DisplayControl(caption="제목", order=1, anchor="/board/get")
	private String title;
	private String contents;
	@DisplayControl(caption="작성자", order=2)
	private String writer;
	@DisplayControl(caption="등록일", order=3, pattern="%tY년 %tm월 %te일")
	private Date regDate;
	@DisplayControl(caption="수정일", order=4, pattern="%tY년 %tm월 %te일")
	private Date updateDate;

	public String makeTableRow() {
		return DisplayControlHelper.makeTableRow(this, DisplayControl.class);
	}
}
