package com.ja.springex.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ja.springex.mapper.ContentsSQLMapper;
import com.ja.springex.mapper.MembersSQLMapper;
import com.ja.springex.mapper.UploadFileSQLMapper;
import com.ja.springex.service.ContentService;
import com.ja.springex.vo.BoardDataVO;
import com.ja.springex.vo.ContentVO;
import com.ja.springex.vo.MemberVO;
import com.ja.springex.vo.UploadFileVO;

@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private MembersSQLMapper membersSQLMapper;
	@Autowired
	private ContentsSQLMapper contentsSQLMapper;
	
	@Autowired
	private UploadFileSQLMapper uploadFileSQLMapper;
	
	
	@Override
	public ArrayList<BoardDataVO> getContentsList(String searchWord, String searchTarget) {
		
		ArrayList<BoardDataVO> dataList = new ArrayList<BoardDataVO>(); 
		
		ArrayList<ContentVO> contentsList = null;
		
		if(searchWord == null) {
			
			contentsList = contentsSQLMapper.selectAll();
		}else {
			
			contentsList = contentsSQLMapper.selectBySearchWord(searchWord,searchTarget);
			
		}
				
		
		for(ContentVO content : contentsList) {
			MemberVO member = membersSQLMapper.selectByIdx(content.getM_idx());		
			
			BoardDataVO data = new BoardDataVO(content,member); 
			
			dataList.add(data);
		}

		
		return dataList;
	}

	
	
	
	@Override
	public BoardDataVO readContent(ContentVO requestParam) {
		// TODO Auto-generated method stub
		ContentVO content = contentsSQLMapper.selectByIdx(requestParam.getC_idx());
		MemberVO member = membersSQLMapper.selectByIdx(content.getM_idx());	
	
		ArrayList<UploadFileVO> fileList = uploadFileSQLMapper.selectByC_idx(requestParam.getC_idx());
		
		
		return new BoardDataVO(content,member,fileList);
	}

	
	
	
	
	@Override
	public void deleteContent(ContentVO requestParam) {
		// TODO Auto-generated method stub
		contentsSQLMapper.deleteByIdx(requestParam.getC_idx());
	}

	@Override
	public void updateContent(ContentVO requestParam) {

		contentsSQLMapper.updateByIdx(requestParam);
		
	}

	@Override
	@Transactional // 트랜잭션 처리.. 밑의 로직을 한 뭉텅이로 하나의 트랜잭션으로 인식해서. 될거면 전부 다되고, 하나라도 안되면 롤백.. 
	public void writeContent(ContentVO requestParam, ArrayList<UploadFileVO> fileList) {
		// TODO Auto-generated method stub
		
		String key = contentsSQLMapper.getKey();
		
		requestParam.setC_idx(key);
		contentsSQLMapper.insert(requestParam);
		
		for(UploadFileVO vo: fileList ) {
			
			vo.setC_idx(key);
			
			uploadFileSQLMapper.insert(vo);
			
		}
		
		
	}

}



















