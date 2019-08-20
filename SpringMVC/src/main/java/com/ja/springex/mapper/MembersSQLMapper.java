package com.ja.springex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ja.springex.vo.MemberVO;

public interface MembersSQLMapper {
	@Insert("INSERT INTO BOARD_MEMBERS VALUES(BOARD_MEMBERS_SEQ.NEXTVAL,#{m_id},#{m_pw},#{m_nick},#{m_phone},#{m_address},SYSDATE)")
	public void insert(MemberVO vo);

	
	@Select("SELECT * FROM BOARD_MEMBERS WHERE M_ID = #{id}")
	public MemberVO selectById(String id);
	
	
	@Select("SELECT * FROM BOARD_MEMBERS WHERE M_IDX = #{m_idx}")
	public MemberVO selectByIdx(
			@Param("m_idx") String idx
			);
	
	
	//회원 정보 수정....
	@Update("UPDATE BOARD_MEMBERS SET m_nick = #{m_nick} WHERE m_idx = #{m_idx}")
	public void update(MemberVO vo);
	
	
	
}

























