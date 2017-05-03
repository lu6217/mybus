package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.train_site.Train_Site;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class Train_SiteDao extends BaseDAO<Train_Site>{

	public List<Train_Site> getSitesBytrainId(Long trainId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Train_Site.class,"train_site");
		builder.leftJoin("train_site.train", "train").leftJoin("train_site.site", "site");
		builder.addEq("train_site.trainId",trainId);
		builder.addAscOrder("train_site.number");
		return this.select(builder);
	}

	public List<Train_Site> getTrainSiteByTrainIdAndSiteId(Long trainId, Long siteId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Train_Site.class);
		builder.addEq("trainId",trainId)
		.addEq("siteId", siteId);
		return this.select(builder);
	}

	public List<Train_Site> getTrainSite(Long trainId, Long number) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Train_Site.class);
		builder.addEq("trainId",trainId)
		.addGt("number", number);
		return this.select(builder);
	}

	public List<Train_Site> getTrainSiteByTrainIdAndNumber(Long trainId,
			long number) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Train_Site.class);
		builder.addEq("trainId",trainId)
		.addEq("number", number);
		return this.select(builder);
	}

}
