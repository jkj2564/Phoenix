package com.spring.boardweb.controller.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardweb.entity.Notice;
import com.spring.boardweb.service.notice.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticePageController {
	 @Autowired
	 NoticeService noticeService;
	
     @GetMapping("/getNoticeList")
     public ModelAndView normalView(){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("notice/getNoticeList.html");
    	
    	return mv;
     }
     
     @GetMapping("/getNotice")
     public ModelAndView getNoticeView() {
    	 ModelAndView mv = new ModelAndView();
    	 mv.setViewName("notice/getNotice.html");
  
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
