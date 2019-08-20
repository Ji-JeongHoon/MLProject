package com.ja.mlproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ja.mlproject.mapper.MemberMapper;
import com.ja.mlproject.service.MemberService;
import com.ja.mlproject.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	
	@Override
	public MemberVO searchByNickname(String m_nickname) {

		MemberVO memberVO = new MemberVO();
		
		memberVO = memberMapper.selectByNickname(m_nickname);
		
		
		
		return memberVO;
	}

}
