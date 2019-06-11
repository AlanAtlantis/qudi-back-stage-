package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qudi.service.SysUserDaoService;
import com.qudi.util.MessageUtil;

/**
 * 后台用户控制层类
 * @author nan
 *
 */
@RestController
@SpringBootApplication
@RequestMapping("/sysuser")
public class SysUserController {

	/*
	 * 声明后台用户业务逻辑层方法类
	 */
	@Autowired
	private SysUserDaoService sysUserService;
	
	/**
	 * 后台用户登录方法
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody MessageUtil login(HttpServletRequest request, @RequestParam String username,
			@RequestParam String password) {
		
		System.out.println(username + "\t\t" + password);
		MessageUtil message = sysUserService.login(username, password, null);
		
		if (message.getObject() != null) {
			// 保存登录信息
			request.getSession().setAttribute("username", message.getObject());
			request.getSession().setMaxInactiveInterval(30*60);
		}
		
		return message;
	}
	
	
}
