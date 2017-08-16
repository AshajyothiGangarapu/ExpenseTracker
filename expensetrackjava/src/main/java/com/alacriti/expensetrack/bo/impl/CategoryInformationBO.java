package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.dao.impl.CategoryInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.CategoryVo;

public class CategoryInformationBO extends BaseBO{
	public CategoryInformationBO() {

	}

	public CategoryInformationBO(Connection conn) {
		super(conn);
	}
	public List<CategoryVo> getCategoryInformation()
			throws DAOException, BOException {
		List<CategoryVo> categoryInfoList = null;
		try {
			CategoryInformationDAO categoryInfoDAO = new CategoryInformationDAO(
					getConnection());
			categoryInfoList = categoryInfoDAO.getCategoryInformation();
			System.out.println("in categoryInfoBO");

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return categoryInfoList;
	}


}
