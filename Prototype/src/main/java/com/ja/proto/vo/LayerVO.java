package com.ja.proto.vo;

public class LayerVO {

	private PerceptronVO perceptron;
	private String activation;
	
	
	public LayerVO (){
		
		
	
	
	}


	public LayerVO(PerceptronVO perceptron, String activation) {
		super();
		this.perceptron = perceptron;
		this.activation = activation;
	}


	public PerceptronVO getPerceptron() {
		return perceptron;
	}


	public void setPerceptron(PerceptronVO perceptron) {
		this.perceptron = perceptron;
	}


	public String getActivation() {
		return activation;
	}


	public void setActivation(String activation) {
		this.activation = activation;
	}
	
}
