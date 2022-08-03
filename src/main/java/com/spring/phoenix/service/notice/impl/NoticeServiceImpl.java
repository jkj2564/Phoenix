package com.spring.phoenix.service.notice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.phoenix.mapper.NoticeMapper;
import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.repository.NoticeRepository;
import com.spring.phoenix.service.notice.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
     @Autowired
     NoticeRepository noticeRepository;
     
     @Autowired
     NoticeMapper noticeMapper;
     
     @Override
     public Page<Notice> getNoticeList(Notice notice, Pageable pageable){
    	 return noticeRepository.findAll(pageable);
     }
     
     @Override
     public int insertNotice(Notice notice) {
    	 int noticeSeq = noticeMapper.getNextNoticeSeq();
    	 notice.setNoticeSeq(noticeSeq);
    	 noticeRepository.save(notice);
    	 noticeRepository.flush();
    	 return notice.getNoticeSeq();
     }
     
     @Override
     public Notice getNotice(int noticeSeq) {
    	 return noticeRepository.findById(noticeSeq).get();
     }
}
