package com.spring.phoenix.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.phoenix.commons.NoticeFileUtils;
import com.spring.phoenix.entitiy.Notice;
import com.spring.phoenix.entitiy.NoticeFile;
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
   	 List<NoticeFile> fileList = noticeService.getNoticeFileList(noticeSeq);
   	 
   	 mv.addObject("notice", notice);
   	 mv.addObject("fileList", fileList);
 
   	 return mv;
    }
    
    @GetMapping("/insertNotice")
    public ModelAndView insertNoticeView() {
   	 ModelAndView mv = new ModelAndView();
   	 mv.setViewName("notice/insertNotice.html");
   	 
   	 return mv;
    }
    
    @PostMapping("/insertNotice")
    public void insertNotice(HttpServletResponse response, Notice notice,
   		 HttpServletRequest request, MultipartHttpServletRequest multipartServletRequest) throws IOException{
   	 int noticeSeq = noticeService.insertNotice(notice);
        
   	 NoticeFileUtils noticefileUtils = new NoticeFileUtils();
	 List<NoticeFile> fileList = noticefileUtils.parseFileInfo(noticeSeq, request, multipartServletRequest);
 
	 noticeService.insertNoticeFileList(fileList);
	 
   	 response.sendRedirect("/notice/getNoticeList");
    }
    
    @GetMapping("deleteNotice/{noticeSeq}")
	 public void deleteNotice(@PathVariable int noticeSeq, HttpServletResponse response) throws IOException {
		 noticeService.deleteNotice(noticeSeq);
		
		 response.sendRedirect("/notice/getNoticeList");
	 }
    
    @PostMapping("/updateNotice")
    public void updateNotice(Notice notice, HttpServletResponse response, HttpServletRequest request,
   		                   MultipartHttpServletRequest multipartServletRequest) throws IOException {
   	 noticeService.updateNotice(notice);
   	 
   	 NoticeFileUtils noticefileUtils = new NoticeFileUtils();
   	 
   	 List<NoticeFile> fileList = noticefileUtils.parseFileInfo(notice.getNoticeSeq(), request, multipartServletRequest);
			
		 noticeService.insertNoticeFileList(fileList);
   	 
   	 response.sendRedirect("/notice/getNoticeList");
    }
    
    @RequestMapping("/fileDown")
    public ResponseEntity<Resource> filedown (@RequestParam String fileName, HttpServletRequest request){
   	 String path = request.getSession().getServletContext().getRealPath("/") + "/upload/";
   	 
   	 Resource resource = new FileSystemResource(path + fileName);
   	 
   	 String resourceName = resource.getFilename();
   	 
   	 HttpHeaders header = new HttpHeaders();
   	 
   	 try {
			header.add("Content-Disposition", "attachment; filename=" + new String(resourceName.getBytes("UTF-8"),
					"ISO-8859-1"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }
}