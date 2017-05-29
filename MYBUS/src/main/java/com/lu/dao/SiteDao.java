package com.lu.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

@Repository
public class SiteDao extends BaseDAO<Site>{


	public List<Site> getSiteByName(String name) {
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Site.class);
		query.addEq("name",name);
		
		return this.select(query);
	}

	public List<ResultVO> fuzzyQuerySite(String queryKey, String site) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Site.class);
		builder.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("description"), "description")
				);
		builder.addLikeStart("name",queryKey).addNe("name", site);
		builder.getDetachedCriteria().setResultTransformer(new AliasToBeanResultTransformer(ResultVO.class));
		return selectTopNE(builder, 10);
	}

	public List<ResultVO> fuzzyQuerySite(String queryKey, Long[] sites, Long pr, Long endSiteId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(Site.class);
		builder.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("description"), "description")
				);
		builder.addLikeStart("name",queryKey);
		if(pr==1){
			builder.addIn("id", sites);
			builder.addNe("id", endSiteId);//去掉终点站站点
		}else{
			if(sites!=null){
				for(int i=0;i<sites.length;i++){
					builder.addNe("id", sites[i]);
				}
			}
		}
		builder.getDetachedCriteria().setResultTransformer(new AliasToBeanResultTransformer(ResultVO.class));
		return selectE(builder);
	}

	public PagingVO getAllSite(PagingVO pagingVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria();
		DetachedCriteriaBuilder count = initQueryCriteria();
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Site.class,"site");
		query.addNe("site.isDelete", Boolean.TRUE);
		return query;
	}

	public List<Site> getSiteById(Long siteId) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query=DetachedCriteriaBuilder.instance(Site.class);
		query.addEq("id",siteId);
		
		return this.select(query);
	}
	
}
