package com.qudi.service;

import org.springframework.stereotype.Service;

import com.qudi.util.MessageUtil;

/**
 * 后台用户业务逻辑层方法类
 * @author nan
 *
 */
@Service
public interface SysUserDaoService {
	
	/**
	 * 后台登录方法
	 * @param username
	 * @param password
	 * @param phone
	 * @return
	 */
	public MessageUtil login(String username,String password,String phone);
	

}
