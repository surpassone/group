package com.ssm.controller.costmanageController;

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
import com.ssm.dao.costmanageDao.paymentsDayDao;
import com.ssm.dao.costmanageDao.impl.paymentsDayDaoImpl;

@Controller
@RequestMapping("/costmanageController/")
public class CostmanageController {
	paymentsDayDao pdd = new paymentsDayDaoImpl();

	@RequestMapping("save.do")
	public ModelAndView testLogin() {
		ModelAndView model = new ModelAndView("jsp/loginError");
		return model;

	}

}
