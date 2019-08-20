package com.ja.springex.vo;

public class RestResponseDataVO {
	
	private boolean isExist;
	private String reason;
	
	public RestResponseDataVO() {
		
		
	}

	public RestResponseDataVO(boolean isExist, String reason) {
		super();
		this.isExist = isExist;
		this.reason = reason;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	
	
}
