package com.ssm.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 过滤非法字符,防范xss跨站攻击
 * 
 * @author GC
 * 
 */
public class CharFilter implements Filter {
	private Logger log = Logger.getLogger(CharFilter.class);
	private String encoding;
	private String[] legalNames;
	private String[] illegalChars;

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
		legalNames = filterConfig.getInitParameter("legalNames").split(",");
		illegalChars = filterConfig.getInitParameter("illegalChars").split(",");
	}

	public void destroy() {
		encoding = null;
		legalNames = null;
		illegalChars = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 必须手动指定编码格式
		req.setCharacterEncoding(encoding);
		String tempURL = req.getRequestURI();
		log.info(tempURL);
		Enumeration params = req.getParameterNames();

		// 是否执行过滤 true：执行过滤 false：不执行过滤
		boolean executable = true;

		// 非法状态 true：非法 false；不非法
		boolean illegalStatus = false;
		String illegalChar = "";
		// 对参数名与参数进行判断
		w: while (params.hasMoreElements()) {

			String paramName = (String) params.nextElement();

			executable = true;

			// 密码不过滤
			if (paramName.toLowerCase().contains("password")) {
				executable = false;
			} else {
				// 检查提交参数的名字，是否合法，即不过滤其提交的值
				f: for (int i = 0; i < legalNames.length; i++) {
					if (legalNames[i].equals(paramName)) {
						executable = false;
						break f;
					}
				}
			}

			if (executable) {
				String[] paramValues = req.getParameterValues(paramName);

				f1: for (int i = 0; i < paramValues.length; i++) {
					String paramValue = paramValues[i];
					f2: for (int j = 0; j < illegalChars.length; j++) {
						illegalChar = illegalChars[j];
						if (paramValue.indexOf(illegalChar) != -1) {
							illegalStatus = true;// 非法状态
							break f2;
						}
					}
					if (illegalStatus) {
						break f1;
					}
				}
			}
			if (illegalStatus) {
				break w;
			}
		}
		// 对URL进行判断
		for (int j = 0; j < illegalChars.length; j++) {

			illegalChar = illegalChars[j];

			if (tempURL.indexOf(illegalChar) != -1) {
				illegalStatus = true;// 非法状态
				break;
			}
		}
		if (illegalStatus) {
			// 必须手动指定编码格式
			res.setContentType("text/html;charset=" + encoding);
			res.setCharacterEncoding(encoding);
//			res.getWriter()
//					.print("<link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/static/jquery/themes/default/easyui.css' />");
//			res.getWriter()
//					.print("<link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/static/jquery/themes/icon.css'/> ");
//			res.getWriter()
//					.print("<script type='text/javascript' src='<%= request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js'></script> ");
//			res.getWriter()
//					.print("<script type='text/javascript' src='<%=request.getContextPath()%>/static/jquery/jquery.easyui.min.js'></script>");
//			res.getWriter()
//					.print("<script type='text/javascript' src='<%=request.getContextPath()%>/static/jquery/easyui-lang-zh_CN.js'></script>");
//
//			res.getWriter()
//					.print("<script>"
//							+ "$.messager.confirm('注意','您当前链接中存在非法字符，请点击确认返回！',function(r){"
//							+ "    if (r){  window.history.go(-1); }    });  "
//							+ "</script>");
			 res.getWriter()
						 .print("<script>window.alert('您当前链接中存在非法字符，请点击确认返回！');window.history.go(-1);</script>");
						
		
		} else {
			filterChain.doFilter(request, response);
		}
	}
}
