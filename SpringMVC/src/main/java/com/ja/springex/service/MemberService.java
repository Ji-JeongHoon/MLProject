package com.ja.springex.service;

import com.ja.springex.vo.MemberVO;
import com.ja.springex.vo.SessionDataVO;

public interface MemberService {
	
	public void joinMember(MemberVO vo);
	
	public SessionDataVO loginProcess(MemberVO vo);
	
	public boolean isExistID(MemberVO requestParam);
	
	
}












