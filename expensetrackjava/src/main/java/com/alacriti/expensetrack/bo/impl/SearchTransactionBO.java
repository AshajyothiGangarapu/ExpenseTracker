package com.alacriti.expensetrack.bo.impl;

import java.sql.Connection;
import java.util.List;

import com.alacriti.expensetrack.dao.impl.SearchTransactionDAO;
import com.alacriti.expensetrack.model.vo.SearchTransaction;

public class SearchTransactionBO extends BaseBO {

	public SearchTransactionBO(Connection connection) {
		super(connection);
	}

	public List<SearchTransaction> getSearchDetails(
			SearchTransaction searchTransc) throws DAOException, BOException {
		List<SearchTransaction> searchInfoList = null;
		try {
			
			SearchTransactionDAO searchTranscDAO = new SearchTransactionDAO(
					getConnection());
			if(searchTransc.getSelectOption()==1){
			 searchInfoList = searchTranscDAO
					.getTransactionsOnAccountNumber(searchTransc);
			}
			else
				searchInfoList = searchTranscDAO
				.getTransactionsOnCategoryName(searchTransc);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return searchInfoList;
	}
	public List<SearchTransaction> getSearchOnDate(
			SearchTransaction searchTransc) throws DAOException, BOException {
		List<SearchTransaction> searchInfoList = null;
		try {
			
			SearchTransactionDAO searchTranscDAO = new SearchTransactionDAO(
					getConnection());
			
				searchInfoList = searchTranscDAO
				.getTransactionsOnDate(searchTransc);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return searchInfoList;
	}


}