package com.spring.phoenix.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="T_PH_NOTICE")
public class Notice {
    @Id
    private int noticeSeq;
    
    private String noticeDiv;
    
    private String noticeWriter;
    
    private String noticeTitle;
    
    private String noticeContent;
    
    private LocalDateTime noticeRegdate = LocalDateTime.now();
    
    private LocalDateTime noticeMdfdate = LocalDateTime.now();
        
}
