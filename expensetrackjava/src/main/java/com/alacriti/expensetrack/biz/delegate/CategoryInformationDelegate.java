package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.bo.impl.CategoryInformationBO;
import com.alacriti.expensetrack.model.vo.CategoryVo;


public class CategoryInformationDelegate extends BaseDelegate{
	public List<CategoryVo> getCategoryInformation() {
		boolean rollBack = false;
		Connection connection = null;
		List<CategoryVo> categoryInfoList = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			CategoryInformationBO categoryInfoBO = new CategoryInformationBO(
					getConnection());
			categoryInfoList = categoryInfoBO.getCategoryInformation();
			System.out.println("categorydelegate");
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return categoryInfoList;

	}
	

}
