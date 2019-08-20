package com.ja.reference.mybatisdao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ja.reference.vo.ContentVO;

@Repository
public class ContentMybatisDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ContentVO vo) {
		
		
		sqlSessionTemplate.insert("ContentDAO.insert", vo);
		
		
	}
}
