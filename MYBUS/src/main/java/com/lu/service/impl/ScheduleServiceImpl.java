package com.lu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.ScheduleDao;
import com.lu.dao.ScheduleSiteDao;
import com.lu.dao.TrainDao;
import com.lu.dao.Train_SiteDao;
import com.lu.entity.schedule.Schedule;
import com.lu.entity.schedule.ScheduleSite;
import com.lu.entity.site.Site;
import com.lu.entity.train.TrainNumber;
import com.lu.entity.train_site.Train_Site;
import com.lu.entity.vo.ScheduleSearchVo;
import com.lu.entity.vo.view.ScheduleView;
import com.lu.service.ScheduleService;
import com.lu.service.SiteService;
import com.lu.util.PagingVO;
@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private ScheduleSiteDao schedulesiteDao;
	
	@Autowired
	private Train_SiteDao train_siteDao;
	
	@Autowired
	private TrainDao trainDao;
	
	@Autowired
	private SiteService siteService;
	
	@SuppressWarnings("deprecation")
	@Override
	public void saveScheduleAndSite(TrainNumber train) {
		// TODO Auto-generated method stub
		Schedule schedule=new Schedule();
		schedule.setBeginSiteId(train.getBeginSiteId());
		schedule.setEndSiteId(train.getEndSiteId());
		Date departureDate=new Date();
		Date arrivalDate=new Date();
		//生成明天的车辆的调度
		departureDate.setHours(train.getDepartureTime().getHours());
		departureDate.setMinutes(train.getDepartureTime().getMinutes());
		departureDate.setDate(departureDate.getDate()+1);
		schedule.setDepartureTime(departureDate);
		arrivalDate.setHours(train.getArrivalTime().getHours());
		arrivalDate.setMinutes(train.getArrivalTime().getMinutes());
		arrivalDate.setDate(arrivalDate.getDate()+1+train.getNumberDay().intValue());
		schedule.setArrivalTime(arrivalDate);
		schedule.setNumberDay(train.getNumberDay());
		schedule.setTrainId(train.getId());
		schedule.setPrice(train.getPrice());
		schedule.setSeatNum(train.getNum());
		scheduleDao.save(schedule);
		schedule=scheduleDao.getScheduleByIdAndTime(train.getId(),departureDate);
		//添加生成站点的调度 
		List<Train_Site> lists=train_siteDao.getSitesBytrainId(train.getId());
		
		if(lists!=null && lists.size() > 0){
			Train_Site train_site=null;
			for (int i = 0; i < lists.size(); i++) {
				Date depDate=new Date();
				Date arrDate=new Date();
				ScheduleSite scheduleSite=new ScheduleSite();
				train_site=lists.get(i);
				if(train_site.getNumber()==1){
//					scheduleSite.setArrivalTime(null);
					depDate.setHours(train_site.getDepartureTime().getHours());
					depDate.setMinutes(train_site.getDepartureTime().getMinutes());
					depDate.setDate(depDate.getDate()+1);
					scheduleSite.setDepartureTime(depDate);
				}else if(train_site.getNumber()==0){
//					scheduleSite.setDepartureTime(null);
					arrDate.setHours(train_site.getArrivalTime().getHours());
					arrDate.setMinutes(train_site.getArrivalTime().getMinutes());
					arrDate.setDate(arrDate.getDate()+1+train_site.getNumberDay().intValue());
					scheduleSite.setArrivalTime(arrDate);
				}else{
					depDate.setHours(train_site.getDepartureTime().getHours());
					depDate.setMinutes(train_site.getDepartureTime().getMinutes());
					depDate.setDate(depDate.getDate()+1);
					arrDate.setHours(train_site.getArrivalTime().getHours());
					arrDate.setMinutes(train_site.getArrivalTime().getMinutes());
					arrDate.setDate(arrDate.getDate()+1+train_site.getNumberDay().intValue());
					scheduleSite.setDepartureTime(depDate);
					scheduleSite.setArrivalTime(arrDate);
				}
				scheduleSite.setPrice(train_site.getPrice());
				scheduleSite.setSiteId(train_site.getSiteId());
				scheduleSite.setNumberDay(train_site.getNumberDay());
				scheduleSite.setScheduleId(schedule.getId());
				schedulesiteDao.save(scheduleSite);
			}
		}
		
	}

	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo,
			ScheduleSearchVo scheduleSearchVo) {
		// TODO Auto-generated method stub
		
		Site beginsite=siteService.getSiteByName(scheduleSearchVo.getBeginSite());
		Site endsite=siteService.getSiteByName(scheduleSearchVo.getEndSite());
		Date date=scheduleSearchVo.getDepartureDate();
		Date date2=new Date(date.getTime()+(long)24*3600*1000);
		List<ScheduleSite> lists=schedulesiteDao.getScheduleSiteBySiteIdAndTime(beginsite.getId(),date,date2);
		if(lists!=null && lists.size()>0){
			Long [] Ids=new Long[lists.size()];
			int j=0;
			for(int i=0;i<lists.size();i++){
				ScheduleSite scheduleSite=schedulesiteDao.getScheduleSiteByScheduleIdAndSiteId(lists.get(i).getScheduleId(),endsite.getId());
				if(scheduleSite!=null){
					Ids[j]=lists.get(i).getScheduleId();
					j++;
				}
			}
			if(j!=0){
				Long [] scheduleIds=new Long[j];
				for(int i=0;i<j;i++){
					scheduleIds[i]=Ids[i];
				}
				PagingVO pageVo=scheduleDao.searchList(pagingVo,scheduleSearchVo,scheduleIds);
				//train显示的时候 trainSite显示有问题  还要修改 
				@SuppressWarnings("unchecked")
				List<ScheduleView> datas = (List<ScheduleView>) pageVo.getDetails();
				
				for (ScheduleView scheduleView : datas) {
					
					List<TrainNumber> trains=trainDao.getTrainById(scheduleView.getTrainId());
					if(trains!=null && trains.size()>0){
						scheduleView.setTrain(trains.get(0));
					}
					scheduleView.setBeginSite(beginsite);
					scheduleView.setEndSite(endsite);
					ScheduleSite begin=schedulesiteDao.getScheduleSiteByScheduleIdAndSiteId(scheduleView.getId(), scheduleView.getBeginSite().getId());
					ScheduleSite end=schedulesiteDao.getScheduleSiteByScheduleIdAndSiteId(scheduleView.getId(), scheduleView.getEndSite().getId());
					scheduleView.setNumberDay(end.getNumberDay()-begin.getNumberDay());
					scheduleView.setDepartureTime(begin.getDepartureTime());
					scheduleView.setArrivalTime(end.getArrivalTime());
					scheduleView.setPrice(Integer.parseInt(end.getPrice())-Integer.parseInt(begin.getPrice())+"");
				}
				return pageVo;
			}
		}
		
		return null;
	}

}
