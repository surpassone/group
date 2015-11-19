package com.ssm.dao.loginDao;

import java.util.List;

import com.ssm.Bean.UserBean;
import com.ssm.Bean.paymentsDayBean;

public interface LoginDao {
	//查询所有用户
	public List<UserBean> allUsers();
	//根据id查询用户
	public List selectById(final String id) ;
	//删除用户
	public void delUser(final String id);
	//增加用户
	public void AddUser(final UserBean bean);
	//更新用户
	public void updateUser(final UserBean bean);
	
}
