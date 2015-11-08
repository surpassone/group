package com.ssm.db;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

public class BaseDAO<E> {
	static Logger logger = Logger.getLogger(BaseDAO.class); //LoginΪ��ص���
	//��ȡ���ݿ�����
	private DBConnection dbcon=new DBConnection();
	/**
	 * @function:ʵ�����ӡ�ɾ�����޸Ĳ������޲Σ�
	 * @param sql���
	 * @return Ӱ�������
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
	 * @function:ʵ�ֲ�ѯ�������޲Σ�
	 * @param sql��䣬mapper �����ݴ����ݿ��װ��ʵ����ȥ
	 * @return Ҫ��ѯ�Ķ��󼯺�
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
	 * @function:ʵ�ֲ�ѯ�������вΣ�
	 * @param sql mapper iPP�󶨲���
	 * @return Ҫ��ѯ�Ķ��󼯺�
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
	 * @function:ʵ�����ӡ�ɾ�����޸Ĳ������вΣ�
	 * @param sql iPP
	 * @return Ӱ�������
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
	 * @function ʵ��Ҫ��ѯ�Ĳ�����������
	 * @param sql  iPP
	 * @return ���ز�ѯ�����������
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