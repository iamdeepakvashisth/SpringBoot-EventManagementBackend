package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Ticket;
import com.repository.TicketRepository;
import com.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	public static List<Ticket> ticketsList = new ArrayList<>();
	private static Integer COUNTER = 1;
	static {
		Ticket ticket = new Ticket(COUNTER++, 1, 50);
		ticketsList.add(ticket);
		ticket = new Ticket(COUNTER++, 2, 100);
		ticketsList.add(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public void add(Ticket ticket) {
		ticketRepository.save(ticket);
	}
}
