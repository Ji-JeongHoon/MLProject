package com.ja.proto.vo;

public class InputLayerVO {

	private String startIndex;
	private String lastIndex;
	
	public InputLayerVO() {
		
		
	}

	public InputLayerVO(String startIndex, String lastIndex) {
		super();
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public String getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(String lastIndex) {
		this.lastIndex = lastIndex;
	}
	
	
	
}
