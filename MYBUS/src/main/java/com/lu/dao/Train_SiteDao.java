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
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Train_Site.class);
		builder.addEq("trainId",trainId);
		return this.select(builder);
	}

}
