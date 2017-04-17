package com.lu.service;

import com.lu.entity.train_site.Train_Site;

public interface Train_SiteService {

	void save(Train_Site train_Site);

	Train_Site getTrainSiteByTrainIdAndSiteId(Long trainId, Long siteId);

	void saveAndChange(Train_Site train_Site, Long trainId, Long number);

}
