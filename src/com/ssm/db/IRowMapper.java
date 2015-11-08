package com.ssm.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<E> {
	public E bindRow(ResultSet rs) throws SQLException;
}
