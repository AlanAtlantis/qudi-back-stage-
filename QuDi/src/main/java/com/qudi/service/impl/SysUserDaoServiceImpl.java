package com.qudi.service.impl;

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
	public MessageUtil login(String username, String password, String phone) {

		//密码加密
		if(password!=null) {
			password=MD5Util.getMD5(password);
		}
		
		//声明返回信息类
		MessageUtil message=new MessageUtil();
		
		//声明后台实体类，并接收dao层登录方法。
		SysUser sysuser=sysUserDao.login(username, password, phone);
		
		//判断用户对象不为空
		if(sysuser!=null){
			message.setResult(Result.SUCCEED);//接收返回状态
			message.setObject(sysuser);//接收用户对象
			message.setInfo("login成功！");
			
			return message;
		}
		
		message.setInfo("login失敗！");
		
		return message;
	}

}
