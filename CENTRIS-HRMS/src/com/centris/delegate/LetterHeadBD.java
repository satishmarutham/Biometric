package com.centris.delegate;

import java.util.ArrayList;

import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;
import com.centris.service.LetterHeadService;
import com.centris.service.serviceImpl.LetterHeadServiceImpl;

public class LetterHeadBD {

	public String insertLetterHead(LetterHeadPOJO letterHeadPOJO) {
		
		LetterHeadService  letterHeadService =new LetterHeadServiceImpl();
	
		return letterHeadService.insertLetterHead(letterHeadPOJO);
	}

	public ArrayList<LetterHeadVo> getAllLetterHeads(String usercode) {
		
		LetterHeadService  letterHeadService =new LetterHeadServiceImpl();
		
		return letterHeadService.getAllLetterHeads(usercode);
	}

}
