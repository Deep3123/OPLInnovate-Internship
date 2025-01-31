package com.event.management.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Event {
	private Integer event_id;
	private String event_name;
	private String venue;
	private String date_time;
	private String organizedbyString;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Integer event_id, String event_name, String venue, String date_time, String organizedbyString) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.venue = venue;
		this.date_time = date_time;
		this.organizedbyString = organizedbyString;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getOrganizedbyString() {
		return organizedbyString;
	}

	public void setOrganizedbyString(String organizedbyString) {
		this.organizedbyString = organizedbyString;
	}

	@Override
	public String toString() {
		return "Event [event_id=" + event_id + ", event_name=" + event_name + ", venue=" + venue + ", date_time="
				+ date_time + ", organizedbyString=" + organizedbyString + "]";
	}
}