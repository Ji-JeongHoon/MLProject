package com.ja.reference.controller.usage.vo;

public class DataVO {
	
	private String v1;
	private String v2;
	
	
	//디폴트 생성자 하나 만들어야함.
	public DataVO() {
		
		
	}
	
	public DataVO(String v1, String v2) {
		super();
		this.v1=v1;
		this.v2=v2;
		
	}
	
	
	public String getV1() {
		return v1;
	}
	public void setV1(String v1) {
		this.v1 = v1;
	}
	public String getV2() {
		return v2;
	}
	public void setV2(String v2) {
		this.v2 = v2;
	}
	
	
}
