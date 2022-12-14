package com.spring.phoenix.controller.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.service.notice.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticePageController {
	 @Autowired
	 NoticeService noticeService;
	
     @GetMapping("/getNoticeList")
     public ModelAndView getNoticeListView(@PageableDefault(page = 0, size = 10) Pageable pageable,
    		 Notice notice){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("notice/getNoticeList.html");
    	
    	Page<Notice> noticeList = noticeService.getNoticeList(notice, pageable);
		mv.addObject("noticeList", noticeList);
    	
    	return mv;
     }
     
     @GetMapping("/getNotice/{noticeSeq}")
     public ModelAndView getNoticeView(@PathVariable int noticeSeq) {
    	 ModelAndView mv = new ModelAndView();
    	 mv.setViewName("notice/getNotice.html");
    	 
    	 Notice notice = noticeService.getNotice(noticeSeq);
    	 mv.addObject("notice", notice);
  
    	 return mv;
     }
     
     @GetMapping("/insertNotice")
     public ModelAndView insertNoticeView() {
    	 ModelAndView mv = new ModelAndView();
    	 mv.setViewName("notice/insertNotice.html");
    	 
    	 return mv;
     }
     
     @PostMapping("/insertNotice")
     public void insertNotice(HttpServletResponse response, Notice notice) throws IOException{
    	 int noticeSeq = noticeService.insertNotice(notice);
     
    	 response.sendRedirect("/notice/getNoticeList");
     }
}
