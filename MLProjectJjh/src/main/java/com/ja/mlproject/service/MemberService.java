package com.ja.mlproject.service;

import com.ja.mlproject.vo.MemberVO;

public interface MemberService {
	
	public MemberVO searchByNickname(String m_nickname);

}
