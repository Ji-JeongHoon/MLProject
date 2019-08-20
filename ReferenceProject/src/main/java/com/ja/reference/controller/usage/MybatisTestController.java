package com.ja.reference.controller.usage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.reference.mapper.MemberSQLMapper;
import com.ja.reference.mybatisdao.ContentMybatisDAO;
import com.ja.reference.vo.ContentVO;
import com.ja.reference.vo.MemberVO;

@Controller
public class MybatisTestController {
	
	@Autowired
	private MemberSQLMapper memberMapper; //1번방식으로 생성된 인스턴스 주입...
	
	@Autowired
	private ContentMybatisDAO contentMybatisDAO; //2번방식으로 생성된 인스턴스 주입.. 우리가 직접 DAO 선언, SQL xml파일이 뽑힌다... 
	
	
	
	@RequestMapping("/mybatisTest2")
	@Transactional //트랜잭션 처리. 동시에 값이 넘어올때. 다 되면 다되고 하나라도 안되면 전부 rollback 을 시켜버림. 
	public String mybatis2Test() {
		//2번방식 테스트
		
		ContentVO vo = new ContentVO(null, "55","mybatisTest","Test",null,null);		
		
		contentMybatisDAO.insert(vo);
		
		return "test";
	}
	
	
	
	
	@RequestMapping("/mybatisTestForm")
	public String mybatisTestForm() {
		return "mybatistTestForm";
		}
		
	
	
	
	
	
	@RequestMapping("/mybatisJoinMemberAction")	
	public String mybatisTestAction(MemberVO vo) {
		
		memberMapper.insert(vo);
		
		
		
		return "test";
	}
		
		
		
		
		
	

}
