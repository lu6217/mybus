package com.lu.service;

import java.util.List;

import com.lu.entity.common.Information;
import com.lu.entity.vo.InformationVo;
import com.lu.util.PagingVO;

public interface InformationService {

	PagingVO searchList(PagingVO pagingVo, InformationVo informationVo);

	boolean saveOrUpdate(Information information);

	Information getInformationById(Long id);

	List<Information> getInformationList();

}
