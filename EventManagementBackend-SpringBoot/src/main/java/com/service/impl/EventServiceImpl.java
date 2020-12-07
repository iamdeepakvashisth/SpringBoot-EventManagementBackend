package com.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Event;
import com.repository.EventRepository;
import com.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Optional<Event> findById(Long id) {
		// TODO Auto-generated method stub
		return eventRepository.findById(id);
	}

	@Override
	public void add(Event event) {
		eventRepository.save(event);
		// TODO Auto-generated method stub
	}

	@Override
	public Optional<Event> delete(Long id) {
		Optional<Event> eventOpt = eventRepository.findById(id);
		if (eventOpt.isPresent()) {
			eventRepository.delete(eventOpt.get());
			return eventOpt;
		}
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Event> update(Event event) {
		Optional<Event> eventOpt = eventRepository.findById(event.getId());

		if (eventOpt.isPresent()) {
			Event existingEvent = eventOpt.get();
			if (event.getEventNAme() != null) {
				existingEvent.setEventNAme(event.getEventNAme());
			}
			if (event.getImgUrl() != null) {
				existingEvent.setImgUrl(event.getImgUrl());
			}
			eventRepository.save(existingEvent);
			return Optional.of(existingEvent);
		}
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
