package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.dao.impl.SearchTransactionDAO;
import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionBO extends BaseBO {

	public SearchTransactionBO(Connection connection) {
		super(connection);
	}

	private static final Logger log = Logger
			.getLogger(SearchTransactionBO.class);

	public List<SearchTransaction> getSearchDetails(
			SearchTransaction searchTransc) throws DAOException, BOException {
		List<SearchTransaction> searchInfoList = null;
		log.debug("in SearchTransactionBO.getSearchDetails");
		try {

			SearchTransactionDAO searchTranscDAO = new SearchTransactionDAO(
					getConnection());
			if (searchTransc.getSelectOption() == 2) {
				searchInfoList = searchTranscDAO
						.getTransactionsOnAccountNumber(searchTransc);
			} else if (searchTransc.getSelectOption() == 1)
				searchInfoList = searchTranscDAO
						.getTransactionsOnCategoryName(searchTransc);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in SearchTransactionBO.getSearchDetails "
					+ e.getMessage());
			throw new BOException();
		}
		return searchInfoList;
	}

	public List<SearchTransaction> getSearchOnDate(
			SearchTransaction searchTransc) throws DAOException, BOException {
		List<SearchTransaction> searchInfoList = null;
		log.debug("in SearchTransactionBO.getSearchOnDate");
		try {

			SearchTransactionDAO searchTranscDAO = new SearchTransactionDAO(
					getConnection());

			searchInfoList = searchTranscDAO
					.getTransactionsOnDate(searchTransc);

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in SearchTransactionBO.getSearchOnDate"
					+ e.getMessage());
			throw new BOException();
		}
		return searchInfoList;
	}

}