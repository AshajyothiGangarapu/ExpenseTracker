package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.expensetrack.bo.impl.SearchTransactionBO;
import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionDelegate extends BaseDelegate {
	private static final Logger log = Logger
			.getLogger(SearchTransactionDelegate.class);

	public List<SearchTransaction> getSearchDetails(
			SearchTransaction searchTransaction) {
		List<SearchTransaction> searchList = null;
		boolean rollBack = false;
		Connection connection = null;
		log.debug("in SearchTransactionDelegate.getSearchDetails");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			SearchTransactionBO searchTransactionBO = new SearchTransactionBO(
					getConnection());
			searchList = searchTransactionBO
					.getSearchDetails(searchTransaction);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in SearchTransactionDelegate.getSearchDetails"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return searchList;

	}

	public List<SearchTransaction> getSearchOnDate(
			SearchTransaction searchTransaction) {
		List<SearchTransaction> searchList = null;
		boolean rollBack = false;
		Connection connection = null;
		log.debug("in SearchTransactionDelegate.getSearchOnDate");
		try {
			connection = startDBTransaction();
			setConnection(connection);
			SearchTransactionBO searchTransactionBO = new SearchTransactionBO(
					getConnection());
			searchList = searchTransactionBO.getSearchOnDate(searchTransaction);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in in SearchTransactionDelegate.getSearchOnDate"
					+ e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

		return searchList;

	}

}
