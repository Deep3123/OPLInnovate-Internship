package com.event.management.service;

import java.util.List;
import com.event.management.dao.Event;

public interface EventService {
	public List<Event> getAllEventDetails();

	public Event getEventDetailById(Integer id);

	public String saveEventDetails(Event e);

	public String updateEventDetailsById(Integer id, String date_time);

	public String deleteEventDetailsById(Integer id);
}
