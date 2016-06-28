package com.centris.form;

import org.apache.struts.action.ActionForm;

public class GetLeavesform extends ActionForm{
String sno;
	public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
	String accyear;
String totalleaves;
String permonth;
String accid;

private double sl;
private double pl;
private double cl;

public String getAccid() {
	return accid;
	
}
public void setAccid(String accid) {
	this.accid = accid;
	
}
public String getAccyear() {
	return accyear;
}
public void setAccyear(String accyear) {
	this.accyear = accyear;
}
public String getTotalleaves() {
	return totalleaves;
}
public void setTotalleaves(String totalleaves) {
	this.totalleaves = totalleaves;
	
}
public String getPermonth() {
	return permonth;
}
public void setPermonth(String permonth) {
	this.permonth = permonth;
}
public double getSl() {
	return sl;
}
public void setSl(double sl) {
	this.sl = sl;
}
public double getPl() {
	return pl;
}
public void setPl(double pl) {
	this.pl = pl;
}
public double getCl() {
	return cl;
}
public void setCl(double cl) {
	this.cl = cl;
}



}
