package com.ssm.db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

import com.ssm.sys.Config;
import com.ssm.util.PropertyUtil;

public class DBConnection {
//	
//	private String url="jdbc:mysql://127.0.0.1:3306/group?useUnicode=true&characterEncoding=UTF-8";
//	private String username="root";
//	private String userpassword="123456";

	private String url= PropertyUtil.getKey("db.properties","url");
	private String username= PropertyUtil.getKey("db.properties","username");
	private String userpassword=PropertyUtil.getKey("db.properties","userpassword");
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCon(){
		Connection con=null;
		try {
			con=(Connection) DriverManager.getConnection(url, username, userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void realse(ResultSet rs,Statement stmt,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con=null;
		}
	}
}