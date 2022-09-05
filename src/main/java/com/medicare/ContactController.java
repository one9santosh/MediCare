package com.medicare;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
@Autowired
	ContactDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("saveMsg")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {

	String name=req.getParameter("name");
	String mobileNum=req.getParameter("mobileNum");
	String email=req.getParameter("email");
	String subject=req.getParameter("subject");
	String message=req.getParameter("message");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Contact s=new Contact();
	
	log.info("pojo object created");
	s.setName(name);
	log.info("name is set to the pojo");
	s.setMobileNum(mobileNum);
	s.setEmail(email);
	s.setSubject(subject);
	s.setMessage(message);
	log.info("email is set to the pojo");
	Contact sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("contact.jsp");
	}
	
	return mv;
}


@RequestMapping("getmsg")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	
	ModelAndView mv=new ModelAndView();
	
	List<Contact> list=dao.getall();
	
	mv.setViewName("messages.jsp");
	
	mv.addObject("lists",list);
	
	return mv;
}


}
