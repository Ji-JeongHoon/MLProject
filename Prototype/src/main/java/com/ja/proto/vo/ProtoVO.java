package com.ja.proto.vo;

public class ProtoVO {
	
	private InputLayerVO inputLayer;
	
	private String meanSquaredError;
	
	private String stochasticGradientDescent;
	
	public ProtoVO() {
		
		
	}

	public ProtoVO(InputLayerVO inputLayer, String meanSquaredError, String stochasticGradientDescent) {
		super();
		this.inputLayer = inputLayer;
		this.meanSquaredError = meanSquaredError;
		this.stochasticGradientDescent = stochasticGradientDescent;
	}

	public InputLayerVO getInputLayer() {
		return inputLayer;
	}

	public void setInputLayer(InputLayerVO inputLayer) {
		this.inputLayer = inputLayer;
	}

	public String getMeanSquaredError() {
		return meanSquaredError;
	}

	public void setMeanSquaredError(String meanSquaredError) {
		this.meanSquaredError = meanSquaredError;
	}

	public String getStochasticGradientDescent() {
		return stochasticGradientDescent;
	}

	public void setStochasticGradientDescent(String stochasticGradientDescent) {
		this.stochasticGradientDescent = stochasticGradientDescent;
	}
	
	

}
