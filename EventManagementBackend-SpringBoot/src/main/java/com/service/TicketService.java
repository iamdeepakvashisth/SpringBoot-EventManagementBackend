package com.service;

import java.util.List;
import com.model.Ticket;


public interface TicketService {

	public List<Ticket> findAll();

	public void add(Ticket ticket);

}
