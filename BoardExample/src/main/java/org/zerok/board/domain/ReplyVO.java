package org.zerok.board.domain;

import java.util.Date;

import org.ivar.framework.DisplayControl;
import org.ivar.framework.DisplayControlHelper;

import lombok.Data;

@Data
public class ReplyVO {
	private int id;
	private int pid;
	private String contents;
	private String writer;
	private Date regDate;
	private Date updateDate;

}
