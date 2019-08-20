package org.zerok.board.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

/**
 * 판단 기준, 검색 기준
 * @author admin
 *
 */
@Data
public class Criteria {
	private int curPage;
	private int pageSize;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int curPage, int pageSize) {
		this.curPage = curPage;
		this.pageSize = pageSize;
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder ucb = UriComponentsBuilder.fromPath("")
				.queryParam("curPage", curPage)
				.queryParam("pageSize", pageSize)
				.queryParam("type", type)
				.queryParam("keyword", keyword);
		return ucb.toUriString();
	}
}
