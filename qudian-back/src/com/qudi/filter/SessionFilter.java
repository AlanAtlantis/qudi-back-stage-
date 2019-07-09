package com.qudi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest arg0, HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {

		StringBuffer url = arg0.getRequestURL();

		System.out.println("---------------------url:" + url);

		String[] filter = new String[] { "goodsBargaining", "goodsCategory", "goodsImg", "goodsList", "shop",
				"upload" };

		boolean doFilter = false;
		for (String s : filter) {
			// 过滤
			if (url.indexOf(s) != -1) {
				doFilter = true;
				break;
			}
		}

		if (doFilter) {
			// 获取session对象
			HttpSession session = arg0.getSession();

			// 获取用户登录信息
			Object object = session.getAttribute("user");

			System.out.println("---------------------------object:" + object);

			// 判断用户对象为空
			if (object == null) {
				// 重定向到登录页面
				arg1.sendRedirect("/qudian-back");
				return;
			} else {
				// 不执行过滤
				arg2.doFilter(arg0, arg1);
			}

		}

		// 不执行过滤
		arg2.doFilter(arg0, arg1);

	}

}
