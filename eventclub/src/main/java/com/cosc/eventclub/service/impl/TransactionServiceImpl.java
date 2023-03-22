package com.cosc.eventclub.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cosc.eventclub.controller.dao.AddTransactionDao;
import com.cosc.eventclub.entity.EventsEntity;
import com.cosc.eventclub.entity.TransactionEntity;
import com.cosc.eventclub.repository.EventsRepository;
import com.cosc.eventclub.repository.TransactionRepository;
import com.cosc.eventclub.repository.UsersRepository;
import com.cosc.eventclub.service.EventsService;
import com.cosc.eventclub.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private final UsersRepository usersRepo;
	
	private final TransactionRepository transactionRepository;
	
	private final EventsRepository eventsRepository;
	
	private final EventsService eventsService;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository,UsersRepository usersRepo,EventsRepository eventsRepository,EventsService eventsService) {
		this.transactionRepository = transactionRepository;
		this.usersRepo=usersRepo;
		this.eventsRepository=eventsRepository;
		this.eventsService=eventsService;
	}

	@Override
	public TransactionEntity addTransaction(AddTransactionDao addTransaction) {
		TransactionEntity transaction=new TransactionEntity();
		transaction.setDateAdded(new Date());
		transaction.setAmount(addTransaction.getAmount());
		EventsEntity event=eventsRepository.findById(addTransaction.getEventId()).get();
		if(usersRepo.findById(addTransaction.getUserId()).isEmpty() || null==event) {
			return null;
		}
		transaction.setEventId(addTransaction.getEventId());
		transaction.setUserId(addTransaction.getUserId());
		Integer[] userIds=new Integer[event.getUserIds().length+1];
		userIds=event.getUserIds();
		userIds[userIds.length-1]=addTransaction.getUserId();
		eventsService.updateEvent(new EventsEntity(event.getEventId(), event.getEventName(), event.getEventPrice(), new Date(),userIds , event.getClub()));
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
