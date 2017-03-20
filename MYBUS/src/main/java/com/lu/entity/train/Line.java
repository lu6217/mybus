package com.lu.entity.train;

import java.util.List;

import com.lu.entity.schedule.Schedule;

public class Line {

	private Long id;
	
	private String name;
	
	private List<Schedule> schedules;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}
