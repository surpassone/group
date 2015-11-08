package com.ssm.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IPbingParam {
	public void bindingParam(PreparedStatement pstmt) throws SQLException;
}
