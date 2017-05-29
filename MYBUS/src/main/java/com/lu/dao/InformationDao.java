package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.common.Information;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;

@Repository
public class InformationDao extends BaseDAO<Information>{

	public PagingVO getAllInformation(PagingVO pagingVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria();
		DetachedCriteriaBuilder count = initQueryCriteria();
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Information.class,"information");
		query.addNe("information.isDelete", Boolean.TRUE);
		return query;
	}

	public Information getInformationById(Long id) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Information.class,"information");
		query.addEq("information.id", id);
		query.addNe("information.isDelete", Boolean.TRUE);
		return this.selectTopOne(query);
	}

	public List<Information> getInformationList() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(Information.class,"information");
		query.addNe("information.isDelete", Boolean.TRUE);
		return this.select(query);
	}

}
