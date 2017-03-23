package com.lu.service;

import com.lu.entity.train.TrainNumber;

public interface TrainService {

	void save(TrainNumber train);

	boolean checkName(String name);

	
}
