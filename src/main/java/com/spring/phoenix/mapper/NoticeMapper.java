package com.spring.phoenix.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeMapper {
	@Select("SELECT IFNULL(MAX(NOTICE_SEQ), 0) + 1 FROM T_PH_NOTICE")
     int getNextNoticeSeq();
	
	@Update("UPDATE T_PH_NOTICE SET NOTICE_SEQ = NOTICE_SEQ - 1 WHERE NOTICE_SEQ > #{noticeSeq}")
	void updateBoardSeq(int boardSeq);
	
}
