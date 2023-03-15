package com.cosc.eventclub.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cosc.eventclub.controller.dao.AddTransactionDao;
import com.cosc.eventclub.entity.TransactionEntity;
import com.cosc.eventclub.repository.EventsRepository;
import com.cosc.eventclub.repository.TransactionRepository;
import com.cosc.eventclub.repository.UsersRepository;
import com.cosc.eventclub.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private final UsersRepository usersRepo;
	
	private final TransactionRepository transactionRepository;
	
	private final EventsRepository eventsRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository,UsersRepository usersRepo,EventsRepository eventsRepository) {
		this.transactionRepository = transactionRepository;
		this.usersRepo=usersRepo;
		this.eventsRepository=eventsRepository;
	}

	@Override
	public TransactionEntity addTransaction(AddTransactionDao event) {
		TransactionEntity transaction=new TransactionEntity();
		transaction.setDateAdded(new Date());
		transaction.setAmount(event.getAmount());
		if(usersRepo.findById(event.getUserId()).isEmpty() || eventsRepository.findById(event.getEventId()).isEmpty()) {
			return null;
		}
		transaction.setEventId(event.getEventId());
		transaction.setUserId(event.getUserId());
		return transactionRepository.save(transaction);
	}

	@Override
	public TransactionEntity getTransaction(Integer id) {
		
		return transactionRepository.findById(id).get();
	}

	@Override
	public TransactionEntity updateTransaction(TransactionEntity event) {
		if(transactionRepository.findById(event.getTransactionId()).isPresent()) {
			TransactionEntity transaction=new TransactionEntity();
			transaction.setDateAdded(new Date());
			transaction.setAmount(event.getAmount());
			if(usersRepo.findById(event.getUserId()).isEmpty() || eventsRepository.findById(event.getEventId()).isEmpty()) {
				return null;
			}
			transaction.setEventId(event.getEventId());
			transaction.setUserId(event.getUserId());
		}
		return null;
	}

	@Override
	public String removeTransaction(Integer id) {
		transactionRepository.deleteById(id);
		return "Deleted Successfully";
	}

}
