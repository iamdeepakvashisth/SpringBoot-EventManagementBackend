package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Ticket;
import com.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Ticket>>(ticketService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody Ticket ticket) {
		ticketService.add(ticket);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
