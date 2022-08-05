package com.spring.phoenix.entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_PH_NOTICE_FILE")
@Data
@IdClass(NoticeFileId.class)
public class NoticeFile {
    @Id
    @ManyToOne
    @JoinColumn(name="NOTICE_SEQ")
	private Notice notice;
    
    @Id
    private int ntfileSeq;
	
	private String originalFileName;
	
	private String ntfileName;
	
	private String ntfilePath;
}
