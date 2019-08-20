package com.ja.springex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.springex.mapper.MembersSQLMapper;
import com.ja.springex.service.MemberService;
import com.ja.springex.vo.MemberVO;
import com.ja.springex.vo.SessionDataVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MembersSQLMapper membersSQLMapper;
	
	public void joinMember(MemberVO vo) {
		
		membersSQLMapper.insert(vo);
	}

	@Override
	public SessionDataVO loginProcess(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberVO result = membersSQLMapper.selectById(vo.getM_id());
		
		SessionDataVO sessionData = null;
		
		if(result != null && result.getM_pw().equals(vo.getM_pw())) {
			//로그인 성공
			sessionData = new SessionDataVO(result.getM_idx(),result.getM_nick());
		}else {
			//로그인 실패...
		}
		
		return sessionData;
	}

	@Override
	public boolean isExistID(MemberVO requestParam) {
		// TODO Auto-generated method stub
		
		MemberVO data = membersSQLMapper.selectById(requestParam.getM_id());
		
		//이미 회원가입
		if(data != null) {
			
			return true;	
			
		}else {
			//아디 없음. 
			return false;
			
		}
		
		
	}
	
	
}



















