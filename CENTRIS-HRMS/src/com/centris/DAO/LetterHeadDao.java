package com.centris.DAO;

import java.util.ArrayList;

import com.centris.POJO.LetterHeadPOJO;
import com.centris.VO.LetterHeadVo;

public interface LetterHeadDao {

	String insertLetterHead(LetterHeadPOJO letterHeadPOJO);

	ArrayList<LetterHeadVo> getAllLetterHeads(String usercode);

}
