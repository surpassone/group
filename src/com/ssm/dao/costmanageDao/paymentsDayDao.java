package com.ssm.dao.costmanageDao;

import java.util.List;

import com.ssm.Bean.paymentsDayBean;

public interface paymentsDayDao {
	//查询所有的账单
	public List allPayments() ;
	//根据id查询账单
	public List selectById(final String id);
	//删除账单
	public void delPayments(final String id);
	//增加账单
	public void AddPayments(final paymentsDayBean bean);
	//更新账单
	public void updatePayments(final paymentsDayBean bean);
	
}
