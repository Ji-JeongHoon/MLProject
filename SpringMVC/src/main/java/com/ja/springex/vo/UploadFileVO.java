package com.ja.springex.vo;

public class UploadFileVO {
	private String f_idx;
	private String c_idx;
	private String f_linkname;
	private String f_orifilename;
	
	public UploadFileVO() {
		
		
	}

	public UploadFileVO(String f_idx, String c_idx, String f_linkname, String f_orifilename) {
		super();
		this.f_idx = f_idx;
		this.c_idx = c_idx;
		this.f_linkname = f_linkname;
		this.f_orifilename = f_orifilename;
	}

	public String getF_idx() {
		return f_idx;
	}

	public void setF_idx(String f_idx) {
		this.f_idx = f_idx;
	}

	public String getC_idx() {
		return c_idx;
	}

	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}

	public String getF_linkname() {
		return f_linkname;
	}

	public void setF_linkname(String f_linkname) {
		this.f_linkname = f_linkname;
	}

	public String getF_orifilename() {
		return f_orifilename;
	}

	public void setF_orifilename(String f_orifilename) {
		this.f_orifilename = f_orifilename;
	}
	
	
	

}
