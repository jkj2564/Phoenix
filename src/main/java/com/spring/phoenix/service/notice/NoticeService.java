package com.spring.phoenix.service.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.phoenix.entitiy.Notice;

public interface NoticeService {
     Page<Notice> getNoticeList(Notice notice, Pageable pageable);
	
	 int insertNotice(Notice notice);
	
     Notice getNotice(int noticeSeq);
}
