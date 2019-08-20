package com.ja.mlproject.vo;

public class PageVO1 {
	private int totalCount;//전체 게시물 개수
	private int pageNum;//현재 페이지 번호
	private int contentNum = 10;//한 페이지에 몇개 표시?
	private int startPage = 1;//현재 페이지 블록의 시작페이지
	private int endPage=5; // 현재 페이지 블록의 마지막 페이지 
	
	private boolean prev = false; //이전페이지로 가는 화살표
	private boolean next;//다음페이지로 가는 화살표
	private int currentBlock;//현재 페이지 블록
	private int lastBlock;//마지막 페이지 블록
	
	public PageVO1() {
		
		
	}

	public PageVO1(int totalCount, int pageNum, int contentNum, int startPage, int endPage, boolean prev, boolean next,
			int currentBlock, int lastBlock) {
		super();
		this.totalCount = totalCount;
		this.pageNum = pageNum;
		this.contentNum = contentNum;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.currentBlock = currentBlock;
		this.lastBlock = lastBlock;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getContentNum() {
		return contentNum;
	}

	public void setContentNum(int contentNum) {
		this.contentNum = contentNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(int currentBlock) {
		this.currentBlock = currentBlock;
	}

	public int getLastBlock() {
		return lastBlock;
	}

	public void setLastBlock(int lastBlock) {
		this.lastBlock = lastBlock;
	}
	
	

}
