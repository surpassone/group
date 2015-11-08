package com.ssm.db;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

public class BaseDAO<E> {
	static Logger logger = Logger.getLogger(BaseDAO.class); //Login为相关的类
	//获取数据库连接
	private DBConnection dbcon=new DBConnection();
	/**
	 * @function:实现增加、删除、修改操作（无参）
	 * @param sql语句
	 * @return 影响的行数
	 */
	public int executeUpdate(String sql){
		Connection con=dbcon.getCon();
		Statement stmt=null;
		int rowcount=0;
		try {
			stmt= con.createStatement();
			rowcount=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(this.getClass(), e);
		}finally{
			dbcon.realse(null, stmt, con);
		}
		return rowcount;
	}
	/**
	 * @function:实现查询操作（无参）
	 * @param sql语句，mapper 将数据从数据库封装到实体里去
	 * @return 要查询的对象集合
	 */
	public List<E> executeQuery(String sql,IRowMapper<E> mapper){
		Connection con=dbcon.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		List<E> list=new ArrayList<E>();
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				E obj=mapper.bindRow(rs);
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(this.getClass(), e);
		}finally{
			dbcon.realse(rs, stmt, con);
		}
		return list;
	}
	/**
	 * @function:实现查询操作（有参）
	 * @param sql mapper iPP绑定参数
	 * @return 要查询的对象集合
	 */
	public List<E> executeQuery(String sql,IRowMapper<E> mapper,IPbingParam iPP){
		Connection con=dbcon.getCon();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<E> list=new ArrayList<E>();
		try {
			pstmt=con.prepareStatement(sql);
			iPP.bindingParam(pstmt);
			rs=pstmt.executeQuery();
			while(rs.next()){
				E obj=mapper.bindRow(rs);
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(this.getClass(), e);
		}finally{
			dbcon.realse(rs, pstmt, con);
		}
		return list;
	}

	/**
	 * @function:实现增加、删除、修改操作（有参）
	 * @param sql iPP
	 * @return 影响的行数
	 */
	public int executeUpdate(String sql,IPbingParam iPP){
		Connection con=dbcon.getCon();
		PreparedStatement pstmt=null;
		int rowcount=0;
		try {
			pstmt=con.prepareStatement(sql);
			iPP.bindingParam(pstmt);
			rowcount=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(this.getClass(), e);
		}finally{
			dbcon.realse(null, pstmt, con);
		}
		return rowcount;
	}

	/**
	 * @function 实现要查询的操作的总条数
	 * @param sql  iPP
	 * @return 返回查询结果的总条数
	 */
	public int querySize(String sql,IPbingParam iPP){
		Connection con=dbcon.getCon();
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int size = 0;
		try {
			if(iPP == null){
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
			}else {
				pstmt=con.prepareStatement(sql);
				iPP.bindingParam(pstmt);
				rs=pstmt.executeQuery();
			}
			while (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(this.getClass(), e);
		}finally{
			dbcon.realse(rs, stmt, con);
		}
		return size;
	}

}