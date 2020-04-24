package com.banshi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.banshi.service.Service;
@Controller
public class CentralController 
{
	 @RequestMapping("/add")
	    public ModelAndView showform(HttpServletRequest req,HttpServletResponse res)
	 {  
		 int i=Integer.parseInt(req.getParameter("Fvalue"));///Fvalue is nothing but input jsp name of type
		 int j=Integer.parseInt(req.getParameter("Svalue"));///Svalue is nothing but input jsp name of type
		 Service service=new Service();
		 int k=service.add(i, j);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("disply.jsp");//view page name
		 mv.addObject("result",k);///pass key it can be anything and value 
	    	return mv;///return modeland view object
	    }  
}
