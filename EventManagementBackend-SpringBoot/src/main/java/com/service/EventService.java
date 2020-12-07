package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Event;

public interface EventService {

	public List<Event> findAll();
	
	public Optional<Event> findById(Long id);
	
	public void add(Event event);
	
	public Optional<Event> delete(Long id);
	
	public Optional<Event> update(Event event);
}
