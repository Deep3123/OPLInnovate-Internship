package com.event.management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.event.management.dao.Event;
import com.event.management.service.EventService;

@RestController
public class EventController {
	@Autowired
	private EventService impl;

	@PostMapping("/getAllEventDetails")
	public List<Event> getAllEventDetails() {
		return impl.getAllEventDetails();
	}

	@PostMapping("/getEventDetailById")
	public Event getEventDetailById(@RequestBody Integer id) {
		return impl.getEventDetailById(id);
	}

	@PostMapping("/saveEventDetails")
	public String saveEventDetails(@RequestBody Event e) {
		return impl.saveEventDetails(e);
	}

	@PostMapping("/updateEventDetailsById")
	public String updateEventDetailsById(@RequestBody Event e) {
		return impl.updateEventDetailsById(e.getEvent_id(), e.getDate_time());
	}

	@PostMapping("/deleteEventDetailsById")
	public String deleteEventDetailsById(@RequestBody Integer id) {
		return impl.deleteEventDetailsById(id);
	}
}
