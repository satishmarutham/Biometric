package com.centris.VO;

import java.sql.Time;

public class ShiftDetails {

	public ShiftDetails() {
		// TODO Auto-generated constructor stub
	}

	
	private String AI_SHIFT_ID;         
	private String AI_SHIFT_NAME;        
	private Time AI_SHIFT_START_TIME;        
	private Time AI_SHIFT_END_TIME;        
	private Time AI_SHIFT_LTOC;        
	private Time AI_SHIFT_ETOG;      
	private Time AI_SHIFT_LTOC_GC;      
	private Time AI_SHIFT_ETOG_GC;     
	private int AI_SHIFT_LTOC_NO_EXEC;      
	private int AI_SHIFT_ETOG_NO_EXEC;       
	private String AI_SHIFT_LTOC_LD;       
	private String AI_SHIFT_ETOG_LD;
	
	private String location;
	private String locationId;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	/**
	 * @return the aI_SHIFT_ID
	 */
	public String getAI_SHIFT_ID() {
		return AI_SHIFT_ID;
	}
	/**
	 * @param aI_SHIFT_ID the aI_SHIFT_ID to set
	 */
	public void setAI_SHIFT_ID(String aI_SHIFT_ID) {
		AI_SHIFT_ID = aI_SHIFT_ID;
	}
	/**
	 * @return the aI_SHIFT_NAME
	 */
	public String getAI_SHIFT_NAME() {
		return AI_SHIFT_NAME;
	}
	/**
	 * @param aI_SHIFT_NAME the aI_SHIFT_NAME to set
	 */
	public void setAI_SHIFT_NAME(String aI_SHIFT_NAME) {
		AI_SHIFT_NAME = aI_SHIFT_NAME;
	}
	/**
	 * @return the aI_SHIFT_START_TIME
	 */
	public Time getAI_SHIFT_START_TIME() {
		return AI_SHIFT_START_TIME;
	}
	/**
	 * @param aI_SHIFT_START_TIME the aI_SHIFT_START_TIME to set
	 */
	public void setAI_SHIFT_START_TIME(Time aI_SHIFT_START_TIME) {
		AI_SHIFT_START_TIME = aI_SHIFT_START_TIME;
	}
	/**
	 * @return the aI_SHIFT_END_TIME
	 */
	public Time getAI_SHIFT_END_TIME() {
		return AI_SHIFT_END_TIME;
	}
	/**
	 * @param aI_SHIFT_END_TIME the aI_SHIFT_END_TIME to set
	 */
	public void setAI_SHIFT_END_TIME(Time aI_SHIFT_END_TIME) {
		AI_SHIFT_END_TIME = aI_SHIFT_END_TIME;
	}
	/**
	 * @return the aI_SHIFT_LTOC
	 */
	public Time getAI_SHIFT_LTOC() {
		return AI_SHIFT_LTOC;
	}
	/**
	 * @param aI_SHIFT_LTOC the aI_SHIFT_LTOC to set
	 */
	public void setAI_SHIFT_LTOC(Time aI_SHIFT_LTOC) {
		AI_SHIFT_LTOC = aI_SHIFT_LTOC;
	}
	/**
	 * @return the aI_SHIFT_ETOG
	 */
	public Time getAI_SHIFT_ETOG() {
		return AI_SHIFT_ETOG;
	}
	/**
	 * @param aI_SHIFT_ETOG the aI_SHIFT_ETOG to set
	 */
	public void setAI_SHIFT_ETOG(Time aI_SHIFT_ETOG) {
		AI_SHIFT_ETOG = aI_SHIFT_ETOG;
	}
	/**
	 * @return the aI_SHIFT_LTOC_GC
	 */
	public Time getAI_SHIFT_LTOC_GC() {
		return AI_SHIFT_LTOC_GC;
	}
	/**
	 * @param aI_SHIFT_LTOC_GC the aI_SHIFT_LTOC_GC to set
	 */
	public void setAI_SHIFT_LTOC_GC(Time aI_SHIFT_LTOC_GC) {
		AI_SHIFT_LTOC_GC = aI_SHIFT_LTOC_GC;
	}
	/**
	 * @return the aI_SHIFT_ETOG_GC
	 */
	public Time getAI_SHIFT_ETOG_GC() {
		return AI_SHIFT_ETOG_GC;
	}
	/**
	 * @param aI_SHIFT_ETOG_GC the aI_SHIFT_ETOG_GC to set
	 */
	public void setAI_SHIFT_ETOG_GC(Time aI_SHIFT_ETOG_GC) {
		AI_SHIFT_ETOG_GC = aI_SHIFT_ETOG_GC;
	}
	/**
	 * @return the aI_SHIFT_LTOC_NO_EXEC
	 */
	public int getAI_SHIFT_LTOC_NO_EXEC() {
		return AI_SHIFT_LTOC_NO_EXEC;
	}
	/**
	 * @param aI_SHIFT_LTOC_NO_EXEC the aI_SHIFT_LTOC_NO_EXEC to set
	 */
	public void setAI_SHIFT_LTOC_NO_EXEC(int aI_SHIFT_LTOC_NO_EXEC) {
		AI_SHIFT_LTOC_NO_EXEC = aI_SHIFT_LTOC_NO_EXEC;
	}
	/**
	 * @return the aI_SHIFT_ETOG_NO_EXEC
	 */
	public int getAI_SHIFT_ETOG_NO_EXEC() {
		return AI_SHIFT_ETOG_NO_EXEC;
	}
	/**
	 * @param aI_SHIFT_ETOG_NO_EXEC the aI_SHIFT_ETOG_NO_EXEC to set
	 */
	public void setAI_SHIFT_ETOG_NO_EXEC(int aI_SHIFT_ETOG_NO_EXEC) {
		AI_SHIFT_ETOG_NO_EXEC = aI_SHIFT_ETOG_NO_EXEC;
	}
	/**
	 * @return the aI_SHIFT_LTOC_LD
	 */
	public String getAI_SHIFT_LTOC_LD() {
		return AI_SHIFT_LTOC_LD;
	}
	/**
	 * @param aI_SHIFT_LTOC_LD the aI_SHIFT_LTOC_LD to set
	 */
	public void setAI_SHIFT_LTOC_LD(String aI_SHIFT_LTOC_LD) {
		AI_SHIFT_LTOC_LD = aI_SHIFT_LTOC_LD;
	}
	/**
	 * @return the aI_SHIFT_ETOG_LD
	 */
	public String getAI_SHIFT_ETOG_LD() {
		return AI_SHIFT_ETOG_LD;
	}
	/**
	 * @param aI_SHIFT_ETOG_LD the aI_SHIFT_ETOG_LD to set
	 */
	public void setAI_SHIFT_ETOG_LD(String aI_SHIFT_ETOG_LD) {
		AI_SHIFT_ETOG_LD = aI_SHIFT_ETOG_LD;
	}  
	
	
	
	
	
	

}
