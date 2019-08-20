package com.ja.springex.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.springex.vo.UploadFileVO;

public interface UploadFileSQLMapper {
	
	@Insert("INSERT INTO Board_UploadFiles VALUES(Board_UploadFiles_SEQ.NEXTVAL,#{c_idx}, #{f_linkname}, #{f_orifilename})")
	public void insert(UploadFileVO vo);
	
	
	@Select("SELECT * FROM BOARD_UPLOADFILES WHERE C_IDX = #{c_idx}")
	public ArrayList<UploadFileVO> selectByC_idx(String c_idx);
}
