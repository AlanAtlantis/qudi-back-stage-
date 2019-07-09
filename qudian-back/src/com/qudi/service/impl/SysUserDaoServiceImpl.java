package com.qudi.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.SysUser;
import com.qudi.dao.SysUserDao;
import com.qudi.service.SysUserDaoService;
import com.qudi.util.MD5Util;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

/**
 * 后台用户业务逻辑层方法实现类
 * 
 * @author nan
 *
 */
@Repository("sysUserService")
public class SysUserDaoServiceImpl implements SysUserDaoService {

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 后台用户登录方法
	 */
	public MessageUtil login_sysuser(String username, String password) {

		// 密码加密
		if (password != null) {
			// password=MD5Util.getMD5(password);
		}

		// 声明返回信息类
		MessageUtil message = new MessageUtil();

		// 声明后台实体类，并接收dao层登录方法。
		SysUser sysuser = sysUserDao.login_sysuser(username, password);

		// 判断用户对象不为空
		if (sysuser != null) {
			message.setResult(Result.SUCCEED);// 接收返回状态
			message.setObject(sysuser);// 接收用户对象
			message.setInfo("login成功！");

			return message;
		}
		message.setInfo("login失敗！");

		return message;
	}

	/**
	 * 后台用户添加方法
	 */
	public MessageUtil register_sysuser(String username, String password, String phone, String email) {

		MessageUtil message = new MessageUtil();

		List<HashMap> map = sysUserDao.checkphone_sysuser(phone,0);

		if (map.size() > 0) {
			message.setInfo("號碼已存在");
			message.setResult(Result.FAILED);
			return message;
		}

		if (username != null && username.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in the username");
			return message;
		}
		if (password != null && password.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in the password");
			// encryption
			password = MD5Util.getMD5(password);

			return message;
		}
		if (phone != null && phone.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in your mobile phone number");
			return message;
		}

		if (email != null && email.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in your email");
			return message;
		}

		SysUser sysuser = new SysUser();
		sysuser.setUsername(username);
		sysuser.setPassword(password);
		sysuser.setPhone(phone);
		sysuser.setEmail(email);
		int eiti = sysUserDao.register_sysuser(sysuser);

		if (eiti > 0) {
			message.setObject(email);
			message.setInfo("Registered successfully");
			message.setResult(Result.SUCCEED);
			return message;
		}

		message.setInfo("Registration failed");
		message.setResult(Result.FAILED);

		return message;
	}

	/**
	 * 後台用戶修改方法
	 */
	public MessageUtil update_sysuser(String password, int sex, String phone, String email, String birthday,
			String address, String remarks, int id) {

		MessageUtil message = new MessageUtil();

		List<HashMap> map = sysUserDao.checkphone_sysuser(phone,id);
		if (map.size() > 0) {
			message.setInfo("號碼已存在");
			message.setResult(Result.FAILED);
			return message;
		}
		if (id < 0) {
			message.setInfo("Please fill in the id");
			return message;
		}

		if (password != null && password.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in the password");
			// encryption
			password = MD5Util.getMD5(password);

			return message;
		}
		if (phone != null && phone.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in your mobile phone number");
			return message;
		}

		if (email != null && email.replace(" ", "").length() == 0) {
			message.setInfo("Please fill in your email");
			return message;
		}

		SysUser sysuser = new SysUser();
		sysuser.setPassword(password);
		sysuser.setSex(sex);
		sysuser.setPhone(phone);
		sysuser.setEmail(email);
		sysuser.setBirthday(birthday);
		sysuser.setAddress(address);
		sysuser.setRemarks(remarks);
		sysuser.setId(id);
		int eiti = sysUserDao.update_sysuser(sysuser);
		if (eiti > 0) {
			message.setObject(email);
			message.setInfo("修改成功");
			message.setResult(Result.SUCCEED);
			return message;
		}

		message.setInfo("修改失敗");
		message.setResult(Result.FAILED);

		return message;
	}

	/**
	 * 查詢用戶名方法
	 */
	public MessageUtil checkusername_sysuser(String username) {
		MessageUtil message = new MessageUtil();

		if (username != null) {
			// Check phone Numbers
			SysUser sysuser = sysUserDao.checkusername_sysuser(username);

			if (sysuser != null) {
				message.setInfo("用户名查詢成功！");
				return message;
			}
			message.setInfo("查询成功！");
			message.setResult(Result.SUCCEED);
			return message;
		}
		message.setInfo("查詢失敗！");
		return message;
	}

	/**
	 * 显示用户订单信息方法
	 */
	@Override
	public MessageUtil thequery_show(int userid) {

		MessageUtil message = new MessageUtil();

		if (userid != 0) {
			// Check phone Numbers
			List<HashMap> list = sysUserDao.thequery_show(userid);

			if (list != null) {
				message.setInfo("订单信息显示成功！");
				message.setObject(list);// 接收用户对象
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("订单信息显示失败！");
		message.setResult(Result.FAILED);
		return message;
	}

	/**
	 * 查詢用户订单信息方法
	 */
	public MessageUtil thequery_theorder(String orderid, int userid) {
		MessageUtil message = new MessageUtil();

		if (userid != 0 && orderid != null) {

			// Check phone Numbers
			List<HashMap> list = sysUserDao.thequery_theorder(orderid, userid);

			if (list != null) {
				message.setInfo("查询成功！");
				message.setObject(list);// 接收用户对象
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("查詢失敗！");
		message.setResult(Result.FAILED);
		return message;
	}

/**
 * 查詢用户信息
 */
	public MessageUtil userinfo_sysuser(int id) {
		
		// 声明返回信息类
		MessageUtil message = new MessageUtil();

		// 声明后台实体类，并接收dao层查询方法。
		List<HashMap> sysuser = sysUserDao.userinfo_sysuser(id);

		// 判断用户对象不为空
		if (sysuser != null) {
			message.setResult(Result.SUCCEED);// 接收返回状态
			message.setObject(sysuser);// 接收用户对象
			return message;
		}
		return message;
	}

}
