package com.centris.service;

import java.util.ArrayList;

import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;

public interface LetterHeadService {

	String insertLetterHead(LetterHeadPOJO letterHeadPOJO);

	ArrayList<LetterHeadVo> getAllLetterHeads(String usercode);

}
