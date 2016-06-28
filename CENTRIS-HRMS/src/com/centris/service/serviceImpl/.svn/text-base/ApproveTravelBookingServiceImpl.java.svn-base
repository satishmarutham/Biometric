package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.centris.DAO.ApproveTravelBookingDao;
import com.centris.DAO.DAOIMPL.ApproveTravelBookingDaoImpl;
import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.form.ApproveTravelBookingForm;
import com.centris.service.ApproveTravelBookingService;

public class ApproveTravelBookingServiceImpl implements ApproveTravelBookingService{

	ApproveTravelBookingDao approvetktDao=new ApproveTravelBookingDaoImpl();
	@Override
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getTktBookingDetailsService(
			ApproveTravelBookingForm form, String currenuserId,String userType) {
		// TODO Auto-generated method stub
		
		return approvetktDao.getTktBookingDetailsDao(form,currenuserId,userType);
	}
	@Override
	public SingleTravelBookingDetailsVo getsingleTicketDetailsService(String tktCode) {
		// TODO Auto-generated method stub
		
		 return approvetktDao.getTktBookingDetailsDao(tktCode);
	}
	
	@Override
	public String approveSingleTicketService(ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub
		return approvetktDao.approveSingleTicketDao(pojo);
	}
	@Override
	public ArrayList<ApproveTravelBookingVo> getConflictEmployeesService(
			String startDate,String fromDate,String userType,String userCode) {
		// TODO Auto-generated method stub
		return approvetktDao.getConflictEmployeesDao(startDate,fromDate,userType,userCode);
	}
	@Override
	public ArrayList<ApproveTravelBookingVo> getTktBkngDetailsForDounloadService(
			String startDate, String endDate, String currenuserId,
			String userType) {
		// TODO Auto-generated method stub
		return approvetktDao.getTktBkngDetailsForDounloadDao(startDate,endDate,currenuserId,userType);
	}
	@Override
	public String approveAllTravelBookingDetailsService(
			ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub
		return approvetktDao.approveAllTravelBookingDetailsDao(pojo);
	}
	@Override
	public String rejectSingleTicketService(ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub
		return approvetktDao.rejectSingleTicketDao(pojo);
	}

}
