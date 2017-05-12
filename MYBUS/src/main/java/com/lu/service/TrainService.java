package com.lu.service;

import java.util.List;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.ResultVO;
import com.lu.entity.vo.TrainSearchVo;
import com.lu.util.PagingVO;

public interface TrainService {

	void saveOrUpdateUser(TrainNumber train);

	boolean checkName(String name);

	PagingVO searchList(PagingVO pagingVo, TrainSearchVo trainSearchVo);

	TrainNumber getTrainByName(String name);

	TrainNumber getTrainById(Long id);

	void delTrain(TrainNumber train);

	List<TrainNumber> getTrain();

	List<ResultVO> fuzzyQueryTrain(String trim);

	
}
