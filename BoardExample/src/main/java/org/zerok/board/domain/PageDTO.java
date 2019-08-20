package org.zerok.board.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private static final int PAGE_NAV_SIZE = 10;
	private int startPage, endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria criteria;
	
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		endPage = (int) Math.ceil((float) criteria.getCurPage() / PAGE_NAV_SIZE)
				* PAGE_NAV_SIZE;
		startPage = endPage - PAGE_NAV_SIZE + 1;
		
		int totalPage = (int) Math.ceil((float) this.total / criteria.getPageSize());
		if (totalPage < endPage) {
			endPage = totalPage;
		}
		
		prev = startPage > 1;
		next = endPage < totalPage;
	}
}
