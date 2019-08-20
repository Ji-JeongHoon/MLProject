package com.ja.mlproject.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ja.mlproject.vo.MemberVO;

public interface MemberMapper {
	
	@Select("SELECT * FROM ML_Member WHERE M_IDX = #{m_idx}")
	public MemberVO selectByIdx(
			@Param("m_idx") String idx
			);	
	
	
	@Select("SELECT * FROM ML_Member WHERE M_nickname = #{m_nickname}")
	public MemberVO selectByNickname(String m_nickname);

}
