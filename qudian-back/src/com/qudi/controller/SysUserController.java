package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qudi.bean.SysUser;
import com.qudi.dao.SysUserDao;
import com.qudi.service.SysUserDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 鍚庡彴鐢ㄦ埛鎺у埗灞傜被
 * 
 * @author nan
 *
 */
@Controller
@RequestMapping("/sys/sysuser")
public class SysUserController {

	/*
	 * 澹版槑鍚庡彴鐢ㄦ埛涓氬姟閫昏緫灞傛柟娉曠被
	 */
	@Autowired
	private SysUserDaoService sysUserService;

	/**
	 * 鍚庡彴鐢ㄦ埛鐧诲綍鏂规硶
	 * 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login_sysuser", method = RequestMethod.GET)
	public String login_sysuser(HttpServletRequest request, @RequestParam String username,
			@RequestParam String password) {

		System.out.println(username + "\t\t" + password);
		MessageUtil message = sysUserService.login_sysuser(username, password);

		if (message.getObject() != null) {
			request.getSession().setAttribute("sysLogin", message.getObject());
			request.getSession().setAttribute("user", message.getObject());

			SysUser sysuser = (SysUser) request.getSession().getAttribute("sysLogin");
			MessageUtil mess = sysUserService.thequery_show(sysuser.getId());
			request.getSession().setAttribute("userid", sysuser.getId());
			request.getSession().setAttribute("list", mess.getObject());

			return "theorder";
		}
		return "login";
	}

	/**
	 * 鍚庡彴鐢ㄦ埛娣诲姞鏂规硶
	 * 
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
	 * 寰屽彴鐢ㄦ埗淇敼鏂规硶
	 * 
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "/update_sysuser", method = RequestMethod.GET)
	public String update_sysuser(HttpServletRequest request, @RequestParam String password, @RequestParam int sex,
			@RequestParam String phone, @RequestParam String email, @RequestParam String birthday,
			@RequestParam String address, @RequestParam String remarks, @RequestParam int id) {
		
		MessageUtil message = sysUserService.update_sysuser(password, sex, phone, email, birthday, address, remarks,
				id);
		
		System.out.println("impl:"+password+"------"+sex+"------"+phone+"------"+email+"------"+birthday+"------"+address+"------"+remarks+"------"+id);

		if (Result.SUCCEED == message.getResult()) {
			request.setAttribute("message", message.getInfo());
			return "updateUser";
		}
		return "updateUser";
	}

	/**
	 * 鏌ヨ鐢ㄦ埗鍚嶆柟娉�
	 * 
	 * @param sysuser
	 * @return
	 */
	@RequestMapping(value = "/checkusername_sysuser", method = RequestMethod.GET)
	public @ResponseBody MessageUtil checkusername_sysuser(@RequestParam("username") String username) {

		MessageUtil message = sysUserService.checkusername_sysuser(username);

		return message;
	}

	/**
	 * 璺宠浆淇敼闋侀潰鏂规硶
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update_jump", method = RequestMethod.GET)
	public String update_jump(HttpServletRequest request) {
		return "updateUser";
	}

	/**
	 * 璺宠浆璁㈠崟闋侀潰鏂规硶
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/theorder_jump", method = RequestMethod.GET)
	public String theorder_jump(HttpServletRequest request) {
		return "theorder";
	}

	/**
	 * 鏌ヨ鐢ㄦ埛璁㈠崟鏂规硶
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/thequery_theorder", method = RequestMethod.GET)
	public String thequery_theorder(HttpServletRequest request, @RequestParam("orderid") String orderid,
			@RequestParam("userid") int userid) {

		MessageUtil message = sysUserService.thequery_theorder(orderid, userid);

		if (Result.SUCCEED == message.getResult()) {
			// 淇濆瓨鐧诲綍淇℃伅
			request.getSession().setAttribute("list", message.getObject());

			return "theorder";
		}
		return "theorder";
	}
	
	
	/**
	 * 璺宠浆璁㈠崟闋侀潰鏂规硶
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register_jump", method = RequestMethod.GET)
	public String register_jump(HttpServletRequest request) {
		return "register";
	}


}
