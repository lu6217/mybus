package com.lu.service;

import java.util.List;

import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;
import com.lu.util.PagingVO;

public interface SiteService {

	void saveOrUpdate(Site site);

	boolean checkName(String name);

	List<ResultVO> fuzzyQuerySite(String queryKey,String site);

	Site getSiteByName(String beginSite);

	List<ResultVO> fuzzyQuerySite2(String queryKey, Long trainId, Long pr);

	PagingVO searchAllSiteList(PagingVO pagingVo);

	Site getSiteById(Long siteId);

}
