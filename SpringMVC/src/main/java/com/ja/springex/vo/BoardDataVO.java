package com.ja.springex.vo;

import java.util.ArrayList;

public class BoardDataVO {
	private ContentVO contentVO;
	private MemberVO memberVO;
	private ArrayList<UploadFileVO> fileList;
	
	public BoardDataVO() {
		
	}

	public BoardDataVO(ContentVO contentVO, MemberVO memberVO) {
		super();
		this.contentVO = contentVO;
		this.memberVO = memberVO;
	}
	
	
	
	

	public BoardDataVO(ContentVO contentVO, MemberVO memberVO, ArrayList<UploadFileVO> fileList) {
		super();
		this.contentVO = contentVO;
		this.memberVO = memberVO;
		this.fileList = fileList;
	}

	public ContentVO getContentVO() {
		return contentVO;
	}

	public void setContentVO(ContentVO contentVO) {
		this.contentVO = contentVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ArrayList<UploadFileVO> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<UploadFileVO> fileList) {
		this.fileList = fileList;
	}
	
	
	
	
	
	
		
}









