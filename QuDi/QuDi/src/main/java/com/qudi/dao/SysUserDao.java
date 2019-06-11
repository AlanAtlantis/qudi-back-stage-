package com.qudi.dao;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.SysUser;

/**
 *后台方法类
 * @author nan
 *
 */
public interface SysUserDao {
	

	/**
	 * 后台登录方法
	 * @param nameuser
	 * @param password
	 * @param Phone
	 * @return
	 */
     SysUser login(@Param("username") String username,@Param("password") String password,@Param ("phone") String phone);

}
