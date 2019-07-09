package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qudi.bean.SysUser;
import com.qudi.service.SysUserDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 
 * @author nan
 *
 */
@Controller
@RequestMapping("/sys/sysuser")
public class SysUserController {

	/*
	 */
	@Autowired
	private SysUserDaoService sysUserService;

	/**
	 * 登录方法
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login_sysuser", method = RequestMethod.GET)
	public String login_sysuser(HttpServletRequest request,Model model, @RequestParam String username,
			@RequestParam String password) {

		MessageUtil message = sysUserService.login_sysuser(username, password);

		if (Result.SUCCEED == message.getResult()) {
			request.getSession().setAttribute("sysLogin", message.getObject());
			request.getSession().setAttribute("user", message.getObject());

			//修改
			SysUser sysuser = (SysUser) request.getSession().getAttribute("sysLogin");
			MessageUtil mess = sysUserService.thequery_show(sysuser.getId());
			model.addAttribute("userid",sysuser.getId());
			model.addAttribute("list", mess.getObject());

			return "theorder";
		}
		return "login";
	}

	/**
	 * 註冊方法
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "/register_sysuser", method = RequestMethod.GET)
	public String register_sysuser(HttpServletRequest request, @RequestParam String username,
			@RequestParam String password, @RequestParam String phone, @RequestParam String email) {

		MessageUtil message = sysUserService.register_sysuser(username, password, phone, email);

		if (Result.SUCCEED == message.getResult()) {
			request.setAttribute("message", message.getInfo());
			return "login";
		}
		return "register";
	}

	/**
	 * 修改方法
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "/update_sysuser", method = RequestMethod.GET)
	public String update_sysuser(HttpServletRequest request, @RequestParam String password, @RequestParam int sex,
			@RequestParam String phone, @RequestParam String email, @RequestParam String birthday,
			@RequestParam String address, @RequestParam String remarks, @RequestParam int id) {

		MessageUtil message = sysUserService.update_sysuser(password, sex, phone, email, birthday, address, remarks,
				id);

		if (Result.SUCCEED == message.getResult()) {
			request.setAttribute("message", message.getInfo());
			return "login";
		}
		return "updateUser";
	}
	
	/**
	 * 查詢用戶信息方法
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userinfo_sysuser", method = RequestMethod.GET)
	public String userinfo_sysuser(HttpServletRequest request,Model model) {

		SysUser sysuser = (SysUser) request.getSession().getAttribute("sysLogin");
		MessageUtil message=sysUserService.userinfo_sysuser(sysuser.getId());		
	    
		model.addAttribute("listUserinfo",message.getObject());

		return "userinfo";
	}


	/**
	 * 查询用戶名方法
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "/checkusername_sysuser", method = RequestMethod.GET)
	public @ResponseBody MessageUtil checkusername_sysuser(@RequestParam("username") String username) {

		MessageUtil message = sysUserService.checkusername_sysuser(username);

		return message;
	}

	/**
	 * 跳转用户修改页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update_jump", method = RequestMethod.GET)
	public String update_jump(HttpServletRequest request) {
		return "updateUser";
	}

	/**
	 * 跳转用户订单页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/theorder_jump", method = RequestMethod.GET)
	public String theorder_jump(HttpServletRequest request) {
		return "theorder";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/thequery_theorder", method = RequestMethod.GET)
	public String thequery_theorder(HttpServletRequest request, @RequestParam("orderid") String orderid,
			@RequestParam("userid") int userid) {

		MessageUtil message = sysUserService.thequery_theorder(orderid, userid);

		if (Result.SUCCEED == message.getResult()) {
			request.getSession().setAttribute("list", message.getObject());

			return "theorder";
		}
		return "theorder";
	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register_jump", method = RequestMethod.GET)
	public String register_jump(HttpServletRequest request) {
		return "register";
	}

	
	/**
	 * 跳转用户信息页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userinfo_jump", method = RequestMethod.GET)
	public String userinfo_jump(HttpServletRequest request) {
		return "userinfo";
	}

}
