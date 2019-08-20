package com.ja.springex.service;

import java.util.ArrayList;

import com.ja.springex.vo.BoardDataVO;
import com.ja.springex.vo.ContentVO;
import com.ja.springex.vo.UploadFileVO;

public interface ContentService {

	public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget);
	public BoardDataVO readContent(ContentVO requestParam);
	public void deleteContent(ContentVO requestParam);
	public void updateContent(ContentVO requestParam);
	public void writeContent(ContentVO requestParam,ArrayList<UploadFileVO> fileList);
	
	
}
















