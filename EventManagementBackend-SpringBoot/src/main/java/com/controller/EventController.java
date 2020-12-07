package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Event;
import com.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Event>>(eventService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Event> eventOpt = eventService.findById(id);
		if (eventOpt.isPresent()) {
			return new ResponseEntity<Event>(eventOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Validated @RequestBody Event event) {
		eventService.add(event);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Event> optEvent = eventService.delete(id);
		if (optEvent.isPresent()) {
			return new ResponseEntity<Event>(optEvent.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Event event){
		Optional<Event> optEvent = eventService.update(event);
		if (optEvent.isPresent()) {
			return new ResponseEntity<Event>(optEvent.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}