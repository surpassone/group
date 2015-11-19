package com.ssm.controller.loginController;

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
import com.ssm.Bean.paymentsDayBean;
import com.ssm.dao.costmanageDao.paymentsDayDao;
import com.ssm.dao.costmanageDao.impl.paymentsDayDaoImpl;
import com.ssm.dao.loginDao.LoginDao;
import com.ssm.dao.loginDao.impl.LoginDaoImpl;

@Controller
@RequestMapping("/LoginController/")
public class LoginController {
	private static final List UserBean = null;
	LoginDao loginDao = new LoginDaoImpl();

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("login.do")
	public ModelAndView userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("jsp/login/welcome");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		List<UserBean> list = loginDao.allUsers();
		String str = "咦？用户名怎么不正确了，点击下方返回按钮看看吧！";
		String tip="登录失败";
		for (int i = 0; i < list.size(); i++) {
			if (username.equals(list.get(i).getUsername())) {
				// 用户名正确
				if (password.equals(list.get(i).getPassword())) {
					// 用户名正确，密码正确，成功登陆
					str = " hello 小伙伴" + list.get(i).getPerson_name()
							+ ",每日一点欢迎你。祝你今天吃的开心，玩的开心！";
					tip ="登陆成功";
					model.addObject("bean", list.get(i));
				} else {
					// 用户名正确，密码不正确
					str = "咦？密码怎么不正确了，点击下方返回按钮看看吧！";
				}
			}
		}
		model.addObject("text", str);
		model.addObject("tip", tip);
		return model;

	}

	
	/**
	 * 登录失败后返回开始登陆页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("back.do")
	public ModelAndView backlogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("jsp/login/login");
		return model;
	}
	
	
	@RequestMapping("goIndex.do")
	public ModelAndView goIndex(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("jsp/costmanage/payMountAdd");
		String userId = request.getParameter("userId");
		model.addObject("userId", userId);
		return model;
	}
}
