package com.ssm.dao.loginDao.impl;

import java.sql.*;
import java.util.*;

import com.ssm.util.Guid;
import com.ssm.Bean.UserBean;
import com.ssm.Bean.paymentsDayBean;
import com.ssm.dao.costmanageDao.paymentsDayDao;
import com.ssm.dao.loginDao.LoginDao;
import com.ssm.db.*;
import com.ssm.util.DateUtil;

public class LoginDaoImpl extends BaseDAO implements LoginDao {

	public List<UserBean> allUsers() {
		String sql = "select * from base_user where state = 0";
		return super.executeQuery(sql, new LoginDaoImpl.loginRow());
	}

	public List selectById(final String id) {
		String sql = "select * from base_user where id=?";
		return super.executeQuery(sql, new loginRow(), new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, id);
			}
		});
	}

	public void delUser(final String id) {
		String seq = "update base_user set state=1 where id=?";
		super.executeUpdate(seq, new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, id);
			}
		});
	}

	public void AddUser(final UserBean bean) {
		String sql = "insert into base_user values(?,?,?,?,?,?,?,?,?,?,?)";
		super.executeUpdate(sql, new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, Guid.create());
				pstmt.setString(2, "admin");
				pstmt.setString(3, DateUtil.getDate());
				pstmt.setString(4, bean.getUsername());
				pstmt.setString(5, bean.getPassword());
				pstmt.setString(6, bean.getPerson_name());
				pstmt.setString(7, bean.getRoom_id());
				pstmt.setString(8, bean.getRoom_name());
				pstmt.setInt(9, bean.getSex());
				pstmt.setInt(10, bean.getState());
				pstmt.setString(11, bean.getNote());
			}
		});
	}

	public void updateUser(final UserBean bean) {
		String seq = "update base_user set password=?, person_name=?, room_id=? , room_name=? ,sex=? where id=?";
		super.executeUpdate(seq, new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, bean.getPassword());
				pstmt.setString(2, bean.getPerson_name());
				pstmt.setString(3, bean.getRoom_id());
				pstmt.setString(4, bean.getRoom_name());
				pstmt.setInt(5, bean.getSex());
				pstmt.setString(6, bean.getId());
			}
		});
	}

	class loginRow implements IRowMapper {
		public Object bindRow(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			UserBean bean = new UserBean();
			bean.setId(rs.getString("id"));
			bean.setPerson_name(rs.getString("person_name"));
			bean.setUsername(rs.getString("username"));
			bean.setPassword(rs.getString("password"));
			bean.setRoom_id(rs.getString("room_id"));
			bean.setRoom_name(rs.getString("room_name"));
			bean.setSex(rs.getInt("sex"));
			bean.setState(rs.getInt("state"));
			bean.setNote(rs.getString("note"));
			return bean;
		}
	}
}
