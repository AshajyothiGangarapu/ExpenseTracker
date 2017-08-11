package com.alacriti.expensetrack.biz.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.bo.impl.SearchTransactionBO;
import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionDelegate extends BaseDelegate{

	public List<SearchTransaction> getSearchDetails(SearchTransaction searchTransaction) {
		List<SearchTransaction> searchList = null;
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			SearchTransactionBO searchTransactionBO = new SearchTransactionBO(getConnection());
			searchList= searchTransactionBO.getSearchDetails(searchTransaction);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		
		return searchList;
		
	}
	public List<SearchTransaction> getSearchOnDate(SearchTransaction searchTransaction) {
		List<SearchTransaction> searchList = null;
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			SearchTransactionBO searchTransactionBO = new SearchTransactionBO(getConnection());
			searchList= searchTransactionBO.getSearchOnDate(searchTransaction);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		
		return searchList;
		
	}

}
