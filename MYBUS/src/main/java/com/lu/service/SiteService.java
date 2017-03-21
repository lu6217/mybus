package com.lu.service;

import com.lu.entity.site.Site;

public interface SiteService {

	void save(Site site);

	boolean checkName(String name);

}
