package com.lu.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.ResultVO;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
import com.lu.util.PagingVO;
@Repository
public class TrainDao extends BaseDAO<TrainNumber>{

	public List<TrainNumber> getTrainByName(String name) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(TrainNumber.class,"train");
		builder.leftJoin("train.beginSite", "beginsite").leftJoin("train.endSite", "endsite");
		builder.addEq("number",name);
		return this.select(builder);
	}

	public PagingVO searchList(PagingVO pagingVo, TrainSearchVo trainSearchVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = initQueryCriteria(trainSearchVo);
		DetachedCriteriaBuilder count = initQueryCriteria(trainSearchVo);
		return this.selectPagingVO(query, pagingVo, count);
	}

	private DetachedCriteriaBuilder initQueryCriteria(
			TrainSearchVo trainSearchVo) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder query = DetachedCriteriaBuilder.instance(TrainNumber.class, "train");
		query.leftJoin("train.beginSite", "beginsite").leftJoin("train.endSite", "endsite");
		query.addLikeAny("train.number", trainSearchVo.getNumber());
		//这个乘车点和目的地站点要在站点列表中查询  通过这两个站点来查出是哪个车次  
//		query.addEq("train.beginSite", trainSearchVo.getBeginSite());
//		query.addEq("train.endSite", trainSearchVo.getEndSite());
		//发车时间在这一天中的车次都要查出来  可能要用  between and 来表示一个范围 来查询车次信息
//		query.addEq("train.departureTime", trainSearchVo.getDepartureTime());
		return query;
	}

	public List<TrainNumber> getTrainById(Long id) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(TrainNumber.class,"train");
		builder.leftJoin("train.beginSite", "beginsite").leftJoin("train.endSite", "endsite");
		builder.addEq("id",id);
		return this.select(builder);
	}

	public List<TrainNumber> getTrain() {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(TrainNumber.class,"train");
		builder.leftJoin("train.beginSite", "beginsite").leftJoin("train.endSite", "endsite");
		return this.select(builder);
	}

	public List<ResultVO> fuzzyQuerySite(String queryKey) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(TrainNumber.class);
		builder.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("number"),"name")
				);
		builder.addLikeStart("number",queryKey);
		builder.getDetachedCriteria().setResultTransformer(new AliasToBeanResultTransformer(ResultVO.class));
		return selectTopNE(builder, 10);
	}


}
