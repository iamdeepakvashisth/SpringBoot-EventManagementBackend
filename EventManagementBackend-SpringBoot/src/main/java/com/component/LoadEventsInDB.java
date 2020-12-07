package com.component;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.Event;
import com.model.User;
import com.repository.EventRepository;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadEventsInDB implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		Event event1 = new Event("4th April", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		// eventRepository.save(event);
		Event event2 = new Event("Halloween Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		// eventRepository.save(event);
		Event event3 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		// eventRepository.save(event);
		Event event4 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		Event event5 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		Event event6 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		Event event7 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		Event event8 = new Event("25 Dec Day", "http://getwallpapers.com/wallpaper/full/d/6/5/106490.jpg");
		List<Event> eventsList = Arrays.asList(event1, event2, event3, event4, event5, event6, event7, event8);
		eventRepository.saveAll(eventsList);

		User user1 = new User("Admin", "Admin", "admin", "admin");
		User user2 = new User("Vas", "Vas", "vas@gmail.com", "abc");
		List<User> usersList = Arrays.asList(user1, user2);
		userRepository.saveAll(usersList);

	}

}
