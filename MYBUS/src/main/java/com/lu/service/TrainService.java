package com.lu.service;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.util.PagingVO;

public interface TrainService {

	void save(TrainNumber train);

	boolean checkName(String name);

	PagingVO searchList(PagingVO pagingVo, TrainSearchVo trainSearchVo);

	TrainNumber getTrainByName(String name);

	
}
