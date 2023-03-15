package com.cosc.eventclub.service;

import com.cosc.eventclub.controller.dao.AddTransactionDao;
import com.cosc.eventclub.entity.TransactionEntity;

public interface TransactionService {
	
	public TransactionEntity addTransaction(AddTransactionDao event);

	public TransactionEntity getTransaction(Integer id);

	public TransactionEntity updateTransaction(TransactionEntity event);

	public String removeTransaction(Integer id);

}
