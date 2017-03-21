package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.site.Site;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

@Repository
public class SiteDao extends BaseDAO<Site>{


	public List<Site> getSiteByName(String name) {
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Site.class);
		query.addEq("name",name);
		
		return this.select(query);
	}

}
