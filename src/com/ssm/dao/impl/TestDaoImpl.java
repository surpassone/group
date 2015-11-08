package com.ssm.dao.impl;

import java.sql.*;
import java.util.*;

import com.ssm.Bean.UserBean;
import com.ssm.dao.TestDao;
import com.ssm.db.BaseDAO;
import com.ssm.db.IRowMapper;

public class TestDaoImpl extends BaseDAO<UserBean> implements TestDao {

	public List selectUser() {
		// TODO Auto-generated method stub
		String sql="select * from t_user";
        return super.executeQuery(sql, new DepartRow());
	}
	
	
}
class DepartRow implements IRowMapper<UserBean>{

	public UserBean bindRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		UserBean userBean =new UserBean();
		userBean.setCreatetime(rs.getString("createtime"));
		userBean.setName(rs.getString("name"));
		return userBean;
	}      
	
    
}
