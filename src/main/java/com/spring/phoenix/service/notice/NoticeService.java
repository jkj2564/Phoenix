package com.spring.phoenix.service.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.entitiy.NoticeFile;

public interface NoticeService {
     Page<Notice> getNoticeList(Notice notice, Pageable pageable);
	
	 int insertNotice(Notice notice);
	
     Notice getNotice(int noticeSeq);
     
     void deleteNotice(int noticeSeq);
     
     void updateNotice(Notice notice);
     
     void insertNoticeFileList(List<NoticeFile> fileList);
     
     List<NoticeFile> getNoticeFileList(int NoticeSeq);
}
