package com.spring.phoenix.service.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.entitiy.NoticeFile;
import com.spring.phoenix.mapper.NoticeMapper;
import com.spring.phoenix.repository.NoticeFileRepository;
import com.spring.phoenix.repository.NoticeRepository;
import com.spring.phoenix.service.notice.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
     @Autowired
     NoticeRepository noticeRepository;
     
     @Autowired
     NoticeFileRepository noticeFileRepository;
     
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
     
     @Override
     public void deleteNotice(int noticeSeq) {
    	 noticeRepository.deleteById(noticeSeq);
    	 
    	 noticeMapper.updateBoardSeq(noticeSeq);
     }
     
     @Override
     public void updateNotice(Notice notice) {
    	 noticeRepository.save(notice);
     }
     
     @Override
     public void insertNoticeFileList(List<NoticeFile> fileList) {
    	 
    	 for(NoticeFile noticeFile : fileList) {
 			noticeFile.setNtfileSeq(noticeFileRepository.selectNextFileSeqByNoticeNoticeSeq(noticeFile.getNotice().getNoticeSeq()));
 			noticeFileRepository.save(noticeFile);
 		}
     }

	@Override
	public List<NoticeFile> getNoticeFileList(int noitceSeq){
		
		Notice notice = new Notice();
		
		notice.setNoticeSeq(noitceSeq);
		
		List<NoticeFile> fileList = noticeFileRepository.findByNotice(notice);
		
		if(fileList == null || fileList.isEmpty()) {
			return null;
		} else {
			return fileList;
		}
	}
}
