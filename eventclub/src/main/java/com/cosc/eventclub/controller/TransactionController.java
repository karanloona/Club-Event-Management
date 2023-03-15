package com.cosc.eventclub.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc.eventclub.controller.dao.AddTransactionDao;
import com.cosc.eventclub.entity.TransactionEntity;
import com.cosc.eventclub.service.TransactionService;

@RestController
@RequestMapping("/v1")
public class TransactionController {

	private final TransactionService transactionService;
	
	public TransactionController( TransactionService transactionService) {
		this.transactionService=transactionService;
	
	}
	
	@PostMapping("/addTransaction")
	public TransactionEntity addTransaction(@RequestBody AddTransactionDao transaction) throws Exception {
		
		return transactionService.addTransaction(transaction);
	}
	
	@GetMapping("transaction/{id}")
	public TransactionEntity getTransaction(@PathVariable Integer id) throws Exception {
		return transactionService.getTransaction(id);
	}
	
	@PutMapping("/updateTransaction")
	public TransactionEntity updateTransaction(@RequestBody TransactionEntity transaction) throws Exception {
		return transactionService.updateTransaction(transaction);
	}
	
	@DeleteMapping("transaction/{id}")
	public String removeTransaction(@PathVariable Integer id) throws Exception {
		return transactionService.removeTransaction(id);
	}
	

}
