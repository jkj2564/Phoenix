package com.spring.phoenix.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="T_PH_NOTICE")

/*
 * @SequenceGenerator( name="T_PH_NOTICE_SEQ_GENERATOR",
 * sequenceName="T_PH_NOTICE_SEQ", initialValue=1, allocationSize=1 )
 */
public class Notice {
	@Id
    
	
	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "T_PH_NOTICE_SEQ_GENERATOR")
	 */
	 
    private int noticeSeq;
    
    private String noticeSub;
    
    private String noticeDiv;
    
    private String noticeWriter;
    
    private String noticeTitle;
    
    private String noticeContent;
    
    private LocalDateTime noticeRegdate = LocalDateTime.now();
    
    private LocalDateTime noticeMdfdate = LocalDateTime.now();
        
}
