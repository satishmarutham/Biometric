package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.LetterHeadDao;
import com.centris.DAO.DAOIMPL.LetterHeadDaoImpl;
import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;
import com.centris.service.LetterHeadService;

public class LetterHeadServiceImpl implements LetterHeadService{

	
	public String insertLetterHead(LetterHeadPOJO letterHeadPOJO) {
		
		LetterHeadDao letterHeadDao = new  LetterHeadDaoImpl();
	
		return letterHeadDao.insertLetterHead(letterHeadPOJO);
	}

	
	public ArrayList<LetterHeadVo> getAllLetterHeads(String usercode) {
		
		LetterHeadDao letterHeadDao = new  LetterHeadDaoImpl();
		
		return letterHeadDao.getAllLetterHeads(usercode);
	}

}
