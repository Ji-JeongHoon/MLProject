package com.ja.mlproject.vo;

public class PagingVO {

	private int totalCount;//전체 게시물 개수
	private int pageNum;//현재 페이지 번호
	private int contentNum = 10;//한 페이지에 몇개 표시?
	private int startPage = 1;//현재 페이지 블록의 시작페이지
	private int endPage=5; // 현재 페이지 블록의 마지막 페이지 
	
	private boolean prev = false; //이전페이지로 가는 화살표
	private boolean next;//다음페이지로 가는 화살표
	private int currentBlock;//현재 페이지 블록
	private int lastBlock;//마지막 페이지 블록
	
	
	//화살표 보이게, 안보이게.
	public void prevnext(int pageNum) {
		if(pageNum > 0 && pageNum < 6) {
			//첫페이지
			setPrev(false);
			setNext(true);
		}
		else if(getLastBlock() == getCurrentBlock()) {
			//마지막
			setPrev(true);
			setNext(false);
		}else {
			
			//중간
			setPrev(true);
			setNext(true);
			
			
		}
		
		
	}
	
	
	//전체 페이지 수를 계산하는 함수. 
	public int calcPage(int totalCount, int contentNum) {
		int totalPage= totalCount/contentNum;
		if(totalCount%contentNum > 0) {
			totalPage++;
		}
		return totalPage;
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
	
	
	//한 페이지 블록당 5개 씩 보여줄거기 때문.
	public void setStartPage(int currentBlock) {
		
		this.startPage = (currentBlock*5)-4;
		
		
	}
	
	
	public int getEndPage() {
		return endPage;
	}
	
	
	
	
	public void setEndPage(int getlastBlock, int getcurrentBlock) {
		
		if(getlastBlock == getcurrentBlock) {
			this.endPage =calcPage(getTotalCount(),getContentNum());
			
		}else {
			
			this.endPage = getStartPage() + 4;
		}
		
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
	
	
	public void setCurrentBlock(int pageNum) {
		this.currentBlock = pageNum/5;
		if(pageNum%5>0) {
			
			this.currentBlock ++;
		}
	}
	public int getLastBlock() {
		return lastBlock;
	}
	
	
	public void setLastBlock(int totalCount) {
		
		this.lastBlock = totalCount / (5*this.contentNum);
		if(totalCount%(5*this.contentNum)>0) {
			this.lastBlock++;
		}
		
		
		
	}
	
	
}
