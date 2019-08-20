package com.ja.reference.mapper;

import org.apache.ibatis.annotations.Insert;

import com.ja.reference.vo.MemberVO;

public interface MemberSQLMapper {
	
	@Insert("INSERT INTO Board_Members VALUES (Board_Members_Seq.nextval,#{m_id},#{m_pw},#{m_nick},#{m_phone},#{m_address},SYSDATE)")
	public void insert(MemberVO vo);

}
   	