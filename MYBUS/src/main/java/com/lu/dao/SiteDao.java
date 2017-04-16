package com.lu.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.lu.entity.site.Site;
import com.lu.entity.vo.ResultVO;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;

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

	public List<ResultVO> fuzzyQuerySite(String queryKey, Long[] sites, Long pr) {
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
		}else{
			for(int i=0;i<sites.length;i++){
				builder.addNe("id", sites[i]);
			}
		}
		builder.getDetachedCriteria().setResultTransformer(new AliasToBeanResultTransformer(ResultVO.class));
		return selectE(builder);
	}

}
