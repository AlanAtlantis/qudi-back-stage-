package com.qudi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.SysUser;

/**
 * 后台方法类
 * 
 * @author nan
 *
 */
public interface SysUserDao {

	/*
	 * 声明后台用户對象
	 */
	SysUser sysuser(int id);

	/**
	 * 后台登录方法
	 * 
	 * @param nameuser
	 * @param password
	 * @param Phone
	 * @return
	 */
	SysUser login_sysuser(@Param("username") String username, @Param("password") String password);

	/**
	 * 后台添加方法
	 * 
	 * @param sysuser
	 * @return
	 */
	int register_sysuser(SysUser sysuser);

	/**
	 * 后台修改方法
	 * 
	 * @param sysuser
	 * @return
	 */
	int update_sysuser(SysUser sysuser);

	/**
	 * 查询用户名方法
	 * 
	 * @param username
	 * @return
	 */
	SysUser checkusername_sysuser(@Param("username") String username);

	/**
	 * 查询電話號碼方法
	 * 
	 * @param username
	 * @return
	 */
	List<HashMap>  checkphone_sysuser(@Param("phone") String phone,@Param("id") int id);
	
	/**
	 * 显示用户订单信息方法
	 * 
	 * @param username
	 * @return
	 */
	List<HashMap>  thequery_show(@Param("userid") int userid);
	
	/**
	 * 查詢用户订单信息方法
	 * 
	 * @param username
	 * @return
	 */
	List<HashMap>  thequery_theorder(@Param("orderid") String orderid,@Param("userid") int userid);


}
