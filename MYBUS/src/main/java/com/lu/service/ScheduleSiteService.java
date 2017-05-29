package com.lu.service;

import java.util.Date;

public interface ScheduleSiteService {

	Long getScheduleId(Long trainId, Long beginSiteId, Date departureTime);

	
}
