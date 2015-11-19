package com.ssm.dao.costmanageDao.impl;

import java.sql.*;
import java.util.*;

import com.ssm.util.Guid;
import com.ssm.Bean.paymentsDayBean;
import com.ssm.dao.costmanageDao.paymentsDayDao;
import com.ssm.db.*;
import com.ssm.util.DateUtil;

public class paymentsDayDaoImpl extends BaseDAO implements paymentsDayDao {

	public List allPayments() {
		String sql = "select * from t_payments_day";
		return super.executeQuery(sql, new paymentsDayDaoImpl.paymentsDayRow());
	}

	
	public List selectById(final String id) {
		String sql = "select * from t_payments_day where id=?";
		return super.executeQuery(sql, new paymentsDayRow(), new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, id);
			}
		});
	}

	 public void delPayments(final String id){
	        String sql = "delete t_payments_day  where id=?";
	        super.executeUpdate(sql, new IPbingParam() {
				public void bindingParam(PreparedStatement pstmt)
						throws SQLException {
					// TODO Auto-generated method stub
					pstmt.setString(1, id);
				}
	        });
	    }
	
	 public void AddPayments(final paymentsDayBean bean){
	        String sql="insert into t_payments_day values(?,?,?,?,?,?,?,?,?,?)";
	        super.executeUpdate(sql, new IPbingParam(){
				public void bindingParam(PreparedStatement pstmt)
						throws SQLException {
					pstmt.setString(1, Guid.create());
	                pstmt.setString(2, "admin");
	                pstmt.setString(3, DateUtil.getDate());
	                pstmt.setString(4, bean.getTime());
	                pstmt.setDouble(5, bean.getPay_mount());
	                pstmt.setString(6, bean.getPerson_id());
	                pstmt.setString(7, bean.getPerson_name());
	                pstmt.setString(8, bean.getRoom_id());
	                pstmt.setString(9, bean.getRoom_name());
	                pstmt.setString(10, bean.getNote());
				}
	        });
	    }
	    
	 
	 public void updatePayments(final paymentsDayBean bean){
	       String seq="update t_payments_day set time=?, pay_mount=?, person_id=? , person_name=? ,room_id=?,room_name=?,note=? where id=?";
	       super.executeUpdate(seq, new IPbingParam() {
			public void bindingParam(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, bean.getTime());
				pstmt.setDouble(2, bean.getPay_mount());
				pstmt.setString(3, bean.getPerson_id());
				pstmt.setString(4, bean.getPerson_name());
				pstmt.setString(5, bean.getRoom_id());
				pstmt.setString(6, bean.getRoom_name());
				pstmt.setString(7, bean.getNote());
				pstmt.setString(8, bean.getId());
			}
	       });
	   }
	    
	 
	class paymentsDayRow implements IRowMapper {
		public Object bindRow(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			paymentsDayBean bean = new paymentsDayBean();
			bean.setPerson_id(rs.getString("person_id"));
			bean.setPerson_name(rs.getString("person_name"));
			bean.setPay_mount(rs.getDouble("pay_mount"));
			bean.setRoom_id(rs.getString("room_id"));
			bean.setRoom_name(rs.getString("room_name"));
			bean.setTime(rs.getString("time"));
			bean.setNote(rs.getString("note"));
			return bean;
		}
	}
}
