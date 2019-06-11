package com.qudi.bean;

/**
 * 后台登录信息
 * 
 * @author AlanAtlantis
 *
 */
public class SysUser {

	private int id;
	private int usertype;// 用户类型
	private String username;// 用户名
	private String password;// 密码
	private int level;// 等级
	private int sex;// 性别
	private String phone;// 电话
	private String email;// 邮箱
	private int notdel;//
	private String birthday;// 生日
	private String address;// 地址
	private String remarks;// 备注
	private int status;// 状态
	private String createuser;// 操作人
	private String createdate;// 创建操作时间
	private String updauser;// 修改操作人
	private String updadate;// 修改操作时间

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SysUser[id=" + id + ",usertype=" + usertype + ",username=" + username + ",password=" + password
				+ ",level=" + level + ",sex=" + sex + ",phone=" + phone + ",email=" + email + ",notdel=" + notdel
				+ ",birthday=" + birthday + ",address=" + address + ",remarks=" + remarks + ",status=" + status
				+ ",createuser=" + createuser + ",createdate=" + createdate + ",updauser=" + updauser + ",updadate="
				+ updadate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNotdel() {
		return notdel;
	}

	public void setNotdel(int notdel) {
		this.notdel = notdel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdauser() {
		return updauser;
	}

	public void setUpdauser(String updauser) {
		this.updauser = updauser;
	}

	public String getUpdadate() {
		return updadate;
	}

	public void setUpdadate(String updadate) {
		this.updadate = updadate;
	}

}
