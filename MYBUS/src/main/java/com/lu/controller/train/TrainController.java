package com.lu.controller.train;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lu.entity.train.TrainNumber;
import com.lu.entity.vo.TrainVo;
import com.lu.service.TrainService;
import com.lu.util.ResultResponse;

@Controller
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	@RequestMapping("/create")
	@ResponseBody
	public ResultResponse addTrain(HttpServletRequest request,TrainVo trainVo){
		
		ResultResponse result = new ResultResponse();
		if(trainVo!=null){
			TrainNumber train=new TrainNumber();
			train.setNumber(trainVo.getNumber().trim());
			//train.setBeginSite(trainVo.getBeginSite().trim());
			//train.setEndSite(trainVo.getEndSite().trim());
			//��ͨ�����Ʋ��ҵ���Ӧ��վ��id Ȼ�󱣴浽train��    �����ݿ���û�ж�Ӧ������ �ͻ������
			//�������ݿ��л�û�� ��Ҫ�Ȱ�վ�㱣������ Ȼ���ٶ�Ӧ��train���б���
			//������ǰ̨ �����ݿ�������վ�㶼ȡ���� 
			
			train.setBeginSite(1L);
			train.setEndSite(2L);
			train.setNum(Long.parseLong(trainVo.getNum().trim()));
			train.setPrice(trainVo.getPrice().trim());
			train.setStartTime(trainVo.getStartTime());
			train.setCreateTime(new Date());
			trainService.save(train);
			result.setMessage("Success!");
		}else{
			result.setResult(Boolean.FALSE);
			result.setMessage("failure!");
		}
		return result;
	}
	
}
