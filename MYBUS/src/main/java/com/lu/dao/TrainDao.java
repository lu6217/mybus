package com.lu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lu.entity.train.TrainNumber;
import com.lu.util.BaseDAO;
import com.lu.util.DetachedCriteriaBuilder;
@Repository
public class TrainDao extends BaseDAO<TrainNumber>{

	public List<TrainNumber> getTrainByName(String name) {
		// TODO Auto-generated method stub
		DetachedCriteriaBuilder builder = DetachedCriteriaBuilder.instance(TrainNumber.class);
		builder.addEq("number",name);
		return this.select(builder);
	}

}
