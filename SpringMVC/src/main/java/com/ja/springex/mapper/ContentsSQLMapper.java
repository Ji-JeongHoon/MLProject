package com.ja.springex.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ja.springex.vo.ContentVO;

public interface ContentsSQLMapper {

	
	@Select("SELECT BOARD_CONTENTS_SEQ.NEXTVAL FROM DUAL")
	public String getKey();
	
	
	
	@Select("SELECT * FROM BOARD_CONTENTS ORDER BY c_idx DESC")
	public ArrayList<ContentVO> selectAll();
	
	//제목검색, 값이 들어갈 곳에만 #가능, 그 외엔 달라로 가능.
	//@Select("SELECT * FROM BOARD_CONTENTS WHERE C_TITLE LIKE '%${searchWord}%' ORDER BY c_idx DESC")
	@Select("SELECT * FROM BOARD_CONTENTS WHERE ${searchTarget} LIKE '%'||#{searchWord}||'%' ORDER BY c_idx DESC")
	public ArrayList<ContentVO> selectBySearchWord(
			//이렇게 param 어노테이션을 붙여주면 두개이상 매개변수 받을 수 있음. 
			@Param("searchWord") String searchWord,
			@Param("searchTarget") String searchTarget);
	
	@Select("SELECT * FROM BOARD_CONTENTS WHERE c_idx = #{c_idx}")
	public ContentVO selectByIdx(String c_idx);
	
	
	
	@Insert("INSERT INTO BOARD_CONTENTS VALUES(#{c_idx},#{m_idx},#{c_title},#{c_content},0,SYSDATE)")                                                    
	public void insert(ContentVO vo);
	
	
	@Delete("DELETE FROM BOARD_CONTENTS WHERE c_idx = #{c_idx}")
	public void deleteByIdx(String c_idx);
	
	@Update("UPDATE BOARD_CONTENTS SET c_title=#{c_title} , c_content=#{c_content} WHERE c_idx=#{c_idx}")
 	public void updateByIdx(ContentVO vo);
	
	
	
}













