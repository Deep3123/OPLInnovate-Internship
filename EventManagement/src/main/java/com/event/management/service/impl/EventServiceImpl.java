package com.event.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.event.management.dao.Event;
import com.event.management.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	private List<Event> eventlist = new ArrayList<>();

	@Override
	public List<Event> getAllEventDetails() {
		return eventlist;
	}

	@Override
	public Event getEventDetailById(Integer id) {
		return eventlist.stream().filter(p -> p.getEvent_id().equals(id)).findFirst().orElse(null);
	}

	@Override
	public String saveEventDetails(Event e) {
		if (eventlist.add(e))
			return "Event added successfully.";

		else
			return "There was an error.";
	}

	@Override
	public String updateEventDetailsById(Integer id, String date_time) {
		Optional<Event> event = eventlist.stream().filter(p -> p.getEvent_id().equals(id)).findFirst();

		if (event.isPresent()) {
			event.get().setDate_time(date_time);
			return "Date and time of event is updated.";
		}

		else
			return "There is an error.";
	}

	@Override
	public String deleteEventDetailsById(Integer id) {
		Optional<Event> event = eventlist.stream().filter(p -> p.getEvent_id().equals(id)).findFirst();

		if (event.isPresent()) {
			eventlist.remove(event.get());
			return "Event is removed successfully.";
		}

		else
			return "There is an error.";
	}
}