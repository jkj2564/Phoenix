package com.spring.phoenix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.entitiy.NoticeFile;
import com.spring.phoenix.entitiy.NoticeFileId;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, NoticeFileId> {
	List<NoticeFile> findByNotice(Notice notice);
	
	@Query(value="select ifnull(max(f.ntfile_seq), 0) + 1 from t_ph_noticefile f where f.notice_seq = :noticeSeq", nativeQuery=true)
	int selectNextFileSeqByNoticeNoticeSeq(@Param("noticeSeq") int noticeSeq);
}
