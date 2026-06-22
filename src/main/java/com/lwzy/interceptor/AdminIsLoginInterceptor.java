package com.lwzy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminIsLoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String aname = (String)session.getAttribute("aname");
		if(aname == null || aname.length() == 0) {
			request.setAttribute("errorMessage", "没登录，无权访问，请登录！");
			request.getRequestDispatcher("/admin/toLogin").forward(request, response);
			return false;
		}
		return true;
	}
}
