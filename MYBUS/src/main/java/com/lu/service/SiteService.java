package com.lu.service;

import java.util.List;

import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;

public interface SiteService {

	void save(Site site);

	boolean checkName(String name);

	List<ResultVO> fuzzyQuerySite(String queryKey,String site);

	Site getSiteByName(String beginSite);

}
