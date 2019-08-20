package com.ja.proto.vo;

public class PerceptronVO {
	private String pValue;
	private String isFinalLayer;
	
	public PerceptronVO(){
		
	}	
	
	

	public PerceptronVO(String pValue) {
		super();
		this.pValue = pValue;
	}



	public PerceptronVO(String pValue, String isFinalLayer) {
		super();
		this.pValue = pValue;
		this.isFinalLayer = isFinalLayer;
	}



	public String getpValue() {
		return pValue;
	}



	public void setpValue(String pValue) {
		this.pValue = pValue;
	}



	public String getIsFinalLayer() {
		return isFinalLayer;
	}



	public void setIsFinalLayer(String isFinalLayer) {
		this.isFinalLayer = isFinalLayer;
	}
	
	
	
	
}
