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

@Controller
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	@RequestMapping("/create")
	@ResponseBody
	public String addTrain(HttpServletRequest request,TrainVo trainVo){
		System.out.println("kk");
		System.out.println(trainVo.getStartTime().getTime());
		String result=null;
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
			result="success";
		}
		return result;
	}
	
}
