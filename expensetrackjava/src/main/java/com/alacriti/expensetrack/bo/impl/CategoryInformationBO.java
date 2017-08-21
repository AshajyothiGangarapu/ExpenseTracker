package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.dao.impl.CategoryInformationDAO;
import com.alacriti.expensetrack.dao.impl.DAOException;
import com.alacriti.expensetrack.model.vo.CategoryVo;

public class CategoryInformationBO extends BaseBO {
	public CategoryInformationBO() {

	}

	public CategoryInformationBO(Connection conn) {
		super(conn);
	}


	private static final Logger log = Logger
			.getLogger(CategoryInformationBO.class);

	public List<CategoryVo> getCategoryInformation() throws DAOException,
			BOException {
		List<CategoryVo> categoryInfoList = null;
		log.debug("in CategoryInformationBO");
		try {
			CategoryInformationDAO categoryInfoDAO = new CategoryInformationDAO(
					getConnection());
			categoryInfoList = categoryInfoDAO.getCategoryInformation();
			System.out.println("in categoryInfoBO");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in CategoryInformationBO" + e.getMessage());
			throw new BOException();
		}
		return categoryInfoList;
	}

}
