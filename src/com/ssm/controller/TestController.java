package com.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.Bean.UserBean;
import com.ssm.dao.TestDao;
import com.ssm.dao.impl.TestDaoImpl;

@Controller
public class TestController {
	TestDao td =new TestDaoImpl();
	@RequestMapping("login.do")
	public ModelAndView testLogin(String username,String password){
		
	if(!("admin".equals(username)&&"admin".equals(password))){
		List<UserBean> list = new ArrayList<UserBean>();
		ModelAndView model = new ModelAndView("jsp/loginError");
		list=td.selectUser();
		model.addObject("list",list );
		return model;
	}
	return new ModelAndView("jsp/loginSucc");	
	}

}
