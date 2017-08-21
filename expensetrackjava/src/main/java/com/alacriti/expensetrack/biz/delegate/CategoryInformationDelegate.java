package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.CategoryInformationBO;
import com.alacriti.expensetrack.model.vo.CategoryVo;

public class CategoryInformationDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(CategoryInformationDelegate.class);

	public List<CategoryVo> getCategoryInformation() {
		boolean rollBack = false;
		Connection connection = null;
		List<CategoryVo> categoryInfoList = null;
		log.debug("in CategoryInformationDelegate");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			CategoryInformationBO categoryInfoBO = new CategoryInformationBO(
					getConnection());
			categoryInfoList = categoryInfoBO.getCategoryInformation();
			System.out.println("categorydelegate");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in CategoryInformationDelegate"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return categoryInfoList;

	}

}
