package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.DailyAllownaceDownloadVo;

public class UploadDailyAllowanceByManager extends TableDecorator {

	public String getDownload() {
		DailyAllownaceDownloadVo alldata = (DailyAllownaceDownloadVo) getCurrentRowObject();
		String path = alldata.getUploadedFilePath();
		String result = "<input type=\"button\" value=\"Download\" id=\"approve\" onclick='downloadFile(\""
				+ path + "\")' class=\"button1\"/>";
		return result;
	}
}
