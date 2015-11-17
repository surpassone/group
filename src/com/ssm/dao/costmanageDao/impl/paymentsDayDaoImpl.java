package com.ssm.dao.costmanageDao.impl;

import java.sql.*;
import java.util.*;

import com.ssm.dao.costmanageDao.paymentsDayDao;
import com.ssm.db.*;



public class paymentsDayDaoImpl extends BaseDAO implements paymentsDayDao {

	public List AllCar(){
        String sql="select * from t_payments_day";
        return super.executeQuery(sql, new paymentsDayDaoImpl.paymentsDayRow());       
    }
	
	
	
	
	 class paymentsDayRow implements IRowMapper{      
		 public Object bindRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
	    }
}
