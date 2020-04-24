package com.banshi.logincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.banshi.Dao.DaoController;
import com.banshi.service.Service;
@Controller
public class LoginController 
{
	DaoController dao=new DaoController();
	 @RequestMapping("/login")
	 
	    public ModelAndView showform(HttpServletRequest req,HttpServletResponse res)
	 {  
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		ModelAndView mv=new ModelAndView();
/// Static I had with out Mysql
//		if(uname.equals("abc")&& pass.equals("123"))
//		{
//		 
//		 mv.setViewName("disply.jsp");//view page name
//		// mv.addObject("result",k);///pass key it can be anything and value 
//	    	return mv;///return modeland view object
//		}
//		else
//		{
//			 mv.setViewName("index.jsp");
//		}
		
		////Dinamic with mysql
		
		if(dao.check(uname, pass))
		{
			mv.setViewName("disply.jsp");
		}
		else
		{
			 mv.setViewName("index.jsp");
		}
		return mv;
	    }  
}

