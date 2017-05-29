package com.lu.service.impl;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu.dao.OrderDao;
import com.lu.dao.ScheduleDao;
import com.lu.dao.ScheduleSiteDao;
import com.lu.dao.SeatDao;
import com.lu.entity.order.Order;
import com.lu.entity.schedule.Schedule;
import com.lu.entity.schedule.ScheduleSite;
import com.lu.entity.seat.Seat;
import com.lu.entity.vo.OrderSearchVo;
import com.lu.entity.vo.OrderVo;
import com.lu.service.OrderService;
import com.lu.util.PagingVO;
import com.lu.util.qrcodeutil.QRCodeUtil;
@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private ScheduleSiteDao scheduleSiteDao;
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Override
	@Transactional
	public void saveOrUpdateOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.saveOrUpdate(order);
	}
	
	@Override
	@Transactional
	public boolean saveOrUpdateOrder(Order order,OrderVo orderVo) {
		// TODO Auto-generated method stub
		//余票数-1
		ScheduleSite scheduleSite=scheduleSiteDao.getScheduleSiteByTrainIdBeginSiteIdAndDepartureTime(orderVo.getTrainId(),orderVo.getBeginSiteId(),orderVo.getDepartureTime());
		if(scheduleSite!=null){
			Long scheduleId=scheduleSite.getScheduleId();
			Schedule schedule=scheduleDao.getScheduleById(scheduleId);
			if(schedule.getSeatNum()>0){
				schedule.setSeatNum(schedule.getSeatNum()-1);
				scheduleDao.update(schedule);
			
				//设置座位  
				Seat seat=seatDao.getOneSeat();
				seat.setStatus(1L);
				seatDao.update(seat);
				order.setSeatId(seat.getId());
				orderDao.saveOrUpdate(order);
				return true;
			}
		}
		return false;
	}
		
	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, OrderSearchVo orderSearchVo, Long accountId) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=orderDao.searchList(pagingVo,orderSearchVo,accountId);
		return vo;
	}

	@Override
	@Transactional
	public PagingVO searchList(PagingVO pagingVo, OrderSearchVo orderSearchVo) {
		// TODO Auto-generated method stub
		PagingVO vo =pagingVo;
		vo=orderDao.searchList(pagingVo,orderSearchVo);
		return vo;
	}
	
	@Override
	@Transactional
	public Order getOrderByUserIdAndTrainId(Long userId, Long trainId,Date date) {
		// TODO Auto-generated method stub
		
		return orderDao.getOrderByUserIdAndTrainId(userId,trainId,date);
	}

	@Override
	@Transactional
	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
		
		return orderDao.getOrderById(id);
	}

	@Override
	@Transactional
	public void createQrcode(Order order,String qrcodepath) {
		// TODO Auto-generated method stub
		//生成二维码 之后   得到二维码的路径    存到order中   
		String ip="";
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(ip);
// 		String qrcodepath="C:\\Users\\lu\\Desktop\\";
 		String filename=order.getId()+".jpg";
 		//同过URL进行跳转的二维码可以进行 票务检测      跳转的时候就把二维码的状态更改为已检票
 		String content="http://"+ip+":8080/MYBUS/luwei/front/order/qrcode/getorderinfo/"+order.getId();
 		
 		//这种直接写order内容的   无法判断是否已经检票   扫描二维码的时候无法进行判断 
// 		String content=	"姓名："+order.getUser().getName()+"  身份证号："+order.getUser().getIDcard()
//		 		+"\n 车次："+order.getTrain().getNumber()+"  开车时间："+order.getDepartureTime()
//		 		+"\n 出发地："+order.getBeginSite().getName()+"  目的地："+order.getEndSite().getName()
//		 		+"\n 席别：硬卧  座次："+order.getSeat().getCompartmentNumber()+"车厢    "+order.getSeat().getSeatNumber()+"号 "
// 				+"\n 票价：￥"+order.getPrice()+"元";
 		File filePath = new File(qrcodepath);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
 		try {
			QRCodeUtil.encode(content,null,qrcodepath+filename,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.setQrcodeImg(qrcodepath+filename);
		order.setQrcodeStatus(1L);
		orderDao.saveOrUpdate(order);
	}

}
