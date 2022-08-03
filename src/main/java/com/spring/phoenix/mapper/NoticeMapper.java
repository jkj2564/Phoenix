package com.spring.phoenix.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeMapper {
	@Select("SELECT IFNULL(MAX(NOTICE_SEQ), 0) + 1 FROM T_PH_NOTICE")
     int getNextNoticeSeq();
}
