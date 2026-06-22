package com.lwzy.interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.lwzy.bean.before.Buser;
import com.lwzy.util.MyUtil;
public class BuserIsLoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Buser buser = MyUtil.getBuserFromSession(session);
		//没登录
		if(buser == null) {
			request.setAttribute("errorMessage", "没登录，无权访问，请登录！");
			request.getRequestDispatcher("/user/toLogin").forward(request, response);
			return false;
		}
		return true;
	}
}
