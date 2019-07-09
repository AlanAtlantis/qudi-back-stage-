package com.qudi.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.qudi.util.MessageUtil;

/**
 * 后台用户业务逻辑层方法类
 * 
 * @author nan
 *
 */
@Service
public interface SysUserDaoService {

	/**
	 * 后台登录方法
	 * 
	 * @param username
	 * @param password
	 * @param phone
	 * @return
	 */
	public MessageUtil login_sysuser(String username, String password);

	/**
	 * 后台添加方法
	 * 
	 * @param sysuser
	 * @return
	 */
	public MessageUtil register_sysuser(String username, String password, String phont, String email);

	/**
	 * 后台修改方法
	 * 
	 * @param sysuser
	 * @return
	 */
	public MessageUtil update_sysuser( String password, int sex, String phone,String email,String  birthday, String address, String remarks,int id);

	/**
	 * 查询用户名方法
	 * 
	 * @param username
	 * @return
	 */
	public MessageUtil checkusername_sysuser(@Param("username") String username);

	/**
	 * 显示用户订单信息方法
	 * 
	 * @param userid
	 * @return
	 */
	public MessageUtil thequery_show(@Param("userid") int userid);
	
	/**
	 * 查詢用户订单信息方法
	 * @param userid
	 * @param orderid
	 * @return
	 */
	public MessageUtil thequery_theorder(@Param("orderid") String orderid,@Param("userid") int userid);
	
	
	/**
	 * 查詢用户信息
	 * @param id
	 * @return
	 */
	public MessageUtil	userinfo_sysuser(@Param("id") int id);
	
}
