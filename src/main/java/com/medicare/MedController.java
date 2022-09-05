package com.medicare;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicare.Medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedController {
@Autowired
	MedDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insertm")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String price=req.getParameter("price");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Medicine s=new Medicine();
	s.setId(id);
	log.info("pojo object created");
	s.setName(name);
	log.info("name is set to the pojo");
	s.setPrice(price);
	log.info("email is set to the pojo");
	Medicine sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("admin.jsp");
	}
	
	return mv;
}
@RequestMapping("update")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("name");
	String price=req.getParameter("price");
int id=Integer.parseInt(req.getParameter("id"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Medicine ss=new Medicine();
	log.info("pojo object created");
	ss.setName(name);
	log.info("name is set to the pojo");
	ss.setPrice(price);
	log.info("email is set to the pojo");
	ss.setId(id);
	Medicine sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("running.jsp");
	}
	
	return mv;
}
@RequestMapping("delete")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("rid"));	
	ModelAndView mv=new ModelAndView();
	Medicine s=new Medicine();
	s.setId(id);
	String sd=dao.deleteByid(id);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("running.jsp");
	}
	return mv;
}

@RequestMapping("getall")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Medicine> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("newarrival.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}
@RequestMapping("getallu")
public ModelAndView geturunning(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Medicine> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("urunninglist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}

@RequestMapping("addtocart")
public ModelAndView adtoCart(HttpServletRequest req,HttpServletResponse res, 
		@RequestParam("id") String id)    
{
	ModelAndView mv = new ModelAndView();
	int cartId = Integer.valueOf(id);
	Medicine MediCine = dao.findbyid(cartId);
	HttpSession session = req.getSession();
	session.setAttribute("MediCine", MediCine);
	mv.addObject(MediCine);
	mv.setViewName("cart.jsp");
	
	
	return mv;
}
}