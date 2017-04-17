package com.lu.service;

import com.lu.entity.train_site.Train_Site;

public interface Train_SiteService {

	Train_Site getTrainSiteByTrainIdAndSiteId(Long trainId, Long siteId);

	void saveAndChange(Train_Site train_Site, Long trainId, Long number);

	Train_Site getTrainSiteByTrainIdAndNumber(Long trainId, long number);

	void saveOrUpdate(Train_Site train_Site);

}
