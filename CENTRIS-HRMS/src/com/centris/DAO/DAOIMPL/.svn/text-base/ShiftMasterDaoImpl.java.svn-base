package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.ShiftMasterDao;
import com.centris.POJO.ShiftMasterPOJO;
import com.centris.VO.ShiftDetails;
import com.centris.VO.ShiftMasterVO;

import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;



public class ShiftMasterDaoImpl extends DBService implements ShiftMasterDao{
	
	int count;
	
	private static 	Logger logger = Logger.getLogger(ShiftMasterDaoImpl.class);
	@Override
	public synchronized ArrayList<ShiftMasterVO> getAllShifts(String groupid) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getshiftData Starting");
		System.out.println("Control in ShiftMasterDaoImpl:getshiftData Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet resultsetshift = null;
		
		ArrayList<ShiftMasterVO> shiftList=new ArrayList<ShiftMasterVO>();
		try {
			conn = getConnection();
			 pstmt=conn.prepareStatement(SQLutilConstants.SELECT_SHIFT_DETAILS);
			 pstmt.setString(1, groupid);
			resultsetshift = pstmt.executeQuery();
			
			while (resultsetshift.next()) {
			
				ShiftMasterVO shiftMasterVO=new ShiftMasterVO();
				shiftMasterVO.setAi_shift_id(resultsetshift.getString(SQLutilConstants.AI_SHIFT_ID));
				shiftMasterVO.setAi_shift_name(resultsetshift.getString(SQLutilConstants.AI_SHIFT_NAME));
				shiftMasterVO.setAi_shift_start_time(resultsetshift.getString(SQLutilConstants.AI_SHIFT_START_TIME));
				shiftMasterVO.setAi_shift_end_time(resultsetshift.getString(SQLutilConstants.AI_SHIFT_END_TIME));
				shiftMasterVO.setAi_shift_ltoc(resultsetshift.getString(SQLutilConstants.AI_SHIFT_LTOC));
				shiftMasterVO.setAi_shift_etog(resultsetshift.getString(SQLutilConstants.AI_SHIFT_ETOG));
				shiftMasterVO.setAi_shift_ltoc_gc(resultsetshift.getString(SQLutilConstants.AI_SHIFT_LTOC_GC));
				shiftMasterVO.setAi_shift_etog_gc(resultsetshift.getString(SQLutilConstants.AI_SHIFT_ETOG_GC));
				shiftMasterVO.setAi_shift_ltoc_no_exec(resultsetshift.getString(SQLutilConstants.AI_SHIFT_LTOC_NO_EXEC));
				shiftMasterVO.setAi_shift_etog_no_exec(resultsetshift.getString(SQLutilConstants.AI_SHIFT_ETOG_NO_EXEC));
				shiftMasterVO.setAi_shift_ltoc_ld(resultsetshift.getString(SQLutilConstants.AI_SHIFT_LTOC_LD));
				shiftMasterVO.setAi_shift_etog_ld(resultsetshift.getString(SQLutilConstants.AI_SHIFT_ETOG_LD));
				shiftMasterVO.setLocation(resultsetshift.getString(SQLutilConstants.LOCATION));
				shiftMasterVO.setLocationId(resultsetshift.getString("locationid"));
				
				shiftList.add(shiftMasterVO);
				
			}
			
		   } catch (SQLException e) {
			   
		        e.printStackTrace();
		      }catch (Exception e) {
					
					e.printStackTrace();
				}
				finally{
					
					 try {
		               
						 if(resultsetshift!=null && !resultsetshift.isClosed() ){
							 resultsetshift.close();
							
						 }
						 if(pstmt!=null && !pstmt.isClosed() ){
							 pstmt.close();
							
						 }
						 
						 if(!conn.isClosed()){
							 conn.close();
							 
						 }
						
					
					} catch (SQLException e) {
						
						e.printStackTrace();
					}catch (Exception e) {
						
						e.printStackTrace();
					}
			}
		System.out.println("Control in ShiftMasterDaoImpl:getshiftData Ending");
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getshiftData Ending");
	return shiftList;
}

	@Override
	public synchronized String shiftCreation(ShiftMasterPOJO shiftMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:insertShift Starting");
		Connection conn = null;
		ResultSet resultsetshift = null;
		PreparedStatement pstmt=null;
		int result=0;
		
	try{
		conn= getConnection();
		/* pstmt=conn.prepareStatement(SQLutilConstants.GET_SHIFT_COUNT);
		pstmt.setString(1,shiftMasterPOJO.getAi_shift_name());
		resultsetshift=pstmt.executeQuery();
		while(resultsetshift.next()){
			 count=resultsetshift.getInt(1);
		}
		System.out.println(count);
		if(count>0){
			return "Exist";
		}else{*/
		pstmt=conn.prepareStatement(SQLutilConstants.INSERT_SHIFT_DETAILS);
		pstmt.setString(1, shiftMasterPOJO.getAi_shift_id());
		pstmt.setString(2, shiftMasterPOJO.getAi_shift_name());
		pstmt.setString(3, shiftMasterPOJO.getAi_shift_start_time());
		pstmt.setString(4, shiftMasterPOJO.getAi_shift_end_time());
		pstmt.setString(5, shiftMasterPOJO.getAi_shift_ltoc());
		pstmt.setString(6, shiftMasterPOJO.getAi_shift_etog()); 
		pstmt.setString(7, shiftMasterPOJO.getAi_shift_ltoc_gc());
		pstmt.setString(8, shiftMasterPOJO.getAi_shift_etog_gc());
		pstmt.setInt(9, Integer.parseInt(shiftMasterPOJO.getAi_shift_ltoc_no_exec()));
		pstmt.setInt(10,Integer.parseInt(shiftMasterPOJO.getAi_shift_etog_no_exec()));
		pstmt.setFloat(11, Float.valueOf(shiftMasterPOJO.getAi_shift_ltoc_ld()));
		pstmt.setFloat(12, Float.valueOf(shiftMasterPOJO.getAi_shift_etog_ld()));
		pstmt.setString(13, shiftMasterPOJO.getCreateuser());
		pstmt.setString(14, shiftMasterPOJO.getCreatetime());
		pstmt.setString(15, shiftMasterPOJO.getLocation());
		  System.out.println(pstmt.toString());
	 result=pstmt.executeUpdate();/*}*/
	   
	
	
	} catch (SQLException e) {
		   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
                     if(resultsetshift!=null && !resultsetshift.isClosed()){
                    	 resultsetshift.close();
                     }
                     
                     if(pstmt!=null && !pstmt.isClosed()){
                    	 pstmt.close();
                     }
                            
					 
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ShiftMasterDaoImpl:insertShift Ending");
		if(result==1){
			return "insert";
		}
		return null;
	}

	@Override
	public synchronized String shiftUpdate(ShiftMasterPOJO shiftMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ShiftMasterDaoImpl:updateShift Starting");
		Connection conn = null;
		PreparedStatement pstmt=null;
		int result=0;
		try{
			 conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.UPDATE_SHIFT_DETAILS);
			pstmt.setString(1, shiftMasterPOJO.getAi_shift_name());
			pstmt.setString(2, shiftMasterPOJO.getAi_shift_start_time());
			pstmt.setString(3, shiftMasterPOJO.getAi_shift_end_time());
			pstmt.setString(4, shiftMasterPOJO.getAi_shift_ltoc());
			pstmt.setString(5, shiftMasterPOJO.getAi_shift_etog()); 
			pstmt.setString(6, shiftMasterPOJO.getAi_shift_ltoc_gc());
			pstmt.setString(7, shiftMasterPOJO.getAi_shift_etog_gc());
			pstmt.setInt(8, Integer.parseInt(shiftMasterPOJO.getAi_shift_ltoc_no_exec()));
			pstmt.setInt(9,Integer.parseInt(shiftMasterPOJO.getAi_shift_etog_no_exec()));
			pstmt.setFloat(10, Float.valueOf(shiftMasterPOJO.getAi_shift_ltoc_ld()));
			pstmt.setFloat(11, Float.valueOf(shiftMasterPOJO.getAi_shift_etog_ld()));

			pstmt.setString(12, shiftMasterPOJO.getCreateuser());
			pstmt.setString(13, shiftMasterPOJO.getCreatetime());
			pstmt.setString(14, shiftMasterPOJO.getLocation());
			pstmt.setString(15,shiftMasterPOJO.getAi_shift_id());
			System.out.println(pstmt.toString());
		result=	pstmt.executeUpdate();
			

		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					 if(pstmt!=null && !pstmt.isClosed()){
						 
						 pstmt.close();
					 }
					 
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:updateShift Ending");
		
		if(result==1){
			return "update";
		}
		
		return null;
	}

	@Override
	public synchronized String shiftDelete(ShiftMasterPOJO shiftMasterPOJO) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:deleteShift Starting");
		
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		int result=0;
		ResultSet rs=null;
		String status=null;
		PreparedStatement pstmt1=null;
		try{
			conn= getConnection();
			
			 pstmt=conn.prepareStatement(SQLutilConstants.CHECK_SHIFT_EMPLOYEE_MAP);
			 pstmt.setString(1, shiftMasterPOJO.getAi_shift_id());
			 rs=pstmt.executeQuery();
			 
				while(rs.next()){
					
					result=rs.getInt(1);
					
					 if(result>0){
						 
						 status="Unable to Delete : Shift is in Use";
						 
						 
					 }else{
						 pstmt1=conn.prepareStatement(SQLutilConstants.DELETE_SHIFT_DETAILS);
						 pstmt1.setString(1, shiftMasterPOJO.getAi_shift_id());
						 	result=pstmt1.executeUpdate();
						 	if(result>0){
						 		
						 		 status="Shift deleted successfully";
						 	}else{
						 		
						 		 status="Shift not deleted successfully";
						 	}
					 }
		
		
		}
		}catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					if(rs!=null && !rs.isClosed()){
						rs.close();
						
					}
                     if(pstmt1!=null && !pstmt.isClosed()){
						 
                    	 pstmt1.close(); 
					 }
					 if(pstmt!=null && !pstmt.isClosed()){
						 
						 pstmt.close(); 
					 }
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:deleteShift Ending");
		
		
		return status;
	}

	@Override
	public synchronized int checkShiftName(String shiftname,String locationcode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:checkShiftName Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		int count=0;
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.CHECT_SHIFT_LOCATION_DUPLICATE);
			pstmt.setString(1, shiftname);
			pstmt.setString(2, locationcode);
			
			System.out.println(pstmt.toString());
			 rsshiftnames=pstmt.executeQuery();
			while(rsshiftnames.next()){
				
				count=rsshiftnames.getInt(1);
				System.out.println(count);
			}
			
		
		
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					 if(rsshiftnames!=null && !rsshiftnames.isClosed()){
						 
						 rsshiftnames.close();
					 }
                  
					 if(pstmt!=null && !pstmt.isClosed()){
						 
						 pstmt.close();
					 }
					 
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:checkShiftName Ending");
		
		return count;
	}
	
	@Override
	public synchronized int checkShiftNameUpdate(String shiftname,String locationcode,String shiftid){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:checkShiftNameUpdate Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		int count=0;
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.CHECK_SHIFT_LOCATION_DUPLICATE_UPDATE);
			pstmt.setString(1, shiftname);
			pstmt.setString(2, locationcode);
			pstmt.setString(3, shiftid);
			
			System.out.println(pstmt.toString());
			 rsshiftnames=pstmt.executeQuery();
			while(rsshiftnames.next()){
				
				count=rsshiftnames.getInt(1);
				System.out.println(count);
			}
			
		
		
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					 if(rsshiftnames!=null && !rsshiftnames.isClosed()){
						 rsshiftnames.close();
					 }
                  
					 if(pstmt!=null && !pstmt.isClosed()){
						 pstmt.close();
						 
					 }
					 
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:checkShiftNameUpdate Ending");
		
		return count;
	}
	
	
	
	public synchronized List<ShiftMasterVO> getShiftByLocation(String location,String group) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftByLocation Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		ArrayList<ShiftMasterVO>	shiftList=new ArrayList<ShiftMasterVO>();
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_SHIFT_BY_LOCATION);
			
			System.out.println("In Dao Group"+location);
			
				pstmt.setString(1,location);
				pstmt.setString(2,group);
		
			System.out.println("Shift in Dao With All"+group);
			 rsshiftnames=pstmt.executeQuery();
			System.out.println("After Exceute::::"+pstmt);
			ShiftMasterVO shiftMasterVO=null;
			while(rsshiftnames.next()){
				 shiftMasterVO=new ShiftMasterVO();
				shiftMasterVO.setAi_shift_id(rsshiftnames.getString("AI_SHIFT_ID"));
				shiftMasterVO.setAi_shift_name(rsshiftnames.getString("AI_SHIFT_NAME"));
				shiftList.add(shiftMasterVO);
			}
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					 if(rsshiftnames!=null && !rsshiftnames.isClosed()){
						 rsshiftnames.close();
					 }
					 
					 if(pstmt!=null && !pstmt.isClosed()){
						 pstmt.close();
					 }
									 				 
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftByLocation Ending");
		
		return shiftList;
	}
	
	public synchronized List<ShiftMasterVO> getShiftBasedLocation(String location) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftBasedLocation Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		ArrayList<ShiftMasterVO>	shiftList=new ArrayList<ShiftMasterVO>();
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_LOCATION_BASED_SHIFT);
			
			System.out.println("In Dao Group"+location);
			
				pstmt.setString(1,location);
				
		
			
			 rsshiftnames=pstmt.executeQuery();
			System.out.println("After Exceute::::"+pstmt);
			ShiftMasterVO shiftMasterVO=null;
			while(rsshiftnames.next()){
				 shiftMasterVO=new ShiftMasterVO();
				shiftMasterVO.setAi_shift_id(rsshiftnames.getString("AI_SHIFT_ID"));
				shiftMasterVO.setAi_shift_name(rsshiftnames.getString("AI_SHIFT_NAME"));
				System.out.println(rsshiftnames.getString("LocationCode")+"   "+rsshiftnames.getString("Location"));
				shiftMasterVO.setLocationId(rsshiftnames.getString("LocationCode"));
				shiftMasterVO.setLocation(rsshiftnames.getString("Location"));
				shiftList.add(shiftMasterVO);
			}
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
					 if(rsshiftnames!=null && !rsshiftnames.isClosed()){
						 rsshiftnames.close();
					 }
                  
					 if(pstmt!=null && !pstmt.isClosed()){
						 pstmt.close();
						 
					 }
					 if(!conn.isClosed()){
						 conn.close();
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftBasedLocation Ending");
		
		return shiftList;
	}
	
	/*public List<ShiftMasterVO> getGroupbasedShift(String group) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getGroupbasedShift Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		ArrayList<ShiftMasterVO>	shiftList=new ArrayList<ShiftMasterVO>();
		try{
			conn= getConnection();
			pstmt=conn.prepareStatement(SQLutilConstants.GET_GROUP_BASED_SHIFT);
			
				pstmt.setString(1,group);
			
			 rsshiftnames=pstmt.executeQuery();
			 
			ShiftMasterVO shiftMasterVO=null;
			while(rsshiftnames.next()){
				 shiftMasterVO=new ShiftMasterVO();
				shiftMasterVO.setAi_shift_id(rsshiftnames.getString("AI_SHIFT_ID"));
				shiftMasterVO.setAi_shift_name(rsshiftnames.getString("AI_SHIFT_NAME"));
				shiftList.add(shiftMasterVO);
			}
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
                  
					 if(conn !=null){
						 closeAll(pstmt, rsshiftnames);
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getGroupbasedShift Ending");
		
		return shiftList;
	}*/
	


	@Override
	public synchronized List<ShiftMasterVO> getShiftByMultipleLocation(String location,String group) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftByLocation Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		ArrayList<ShiftMasterVO>	shiftList=new ArrayList<ShiftMasterVO>();
		try{
			conn= getConnection();
			String temp_location="'"+location.replaceAll(",","','")+"'";
			pstmt=conn.prepareStatement("select * from ai_shift_deatails sd  where sd.Location in ( "+temp_location+" ) and sd.Location in (select LocationCode from onsite_groupmapping where Groupid=?)");
			pstmt.setString(1,group);
			System.out.println("After Exceute::::"+pstmt);
			rsshiftnames=pstmt.executeQuery();
		
			ShiftMasterVO shiftMasterVO=null;
			while(rsshiftnames.next()){
				 shiftMasterVO=new ShiftMasterVO();
				shiftMasterVO.setAi_shift_id(rsshiftnames.getString("AI_SHIFT_ID"));
				shiftMasterVO.setAi_shift_name(rsshiftnames.getString("AI_SHIFT_NAME"));
				shiftList.add(shiftMasterVO);
			}
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 try {
	                
                  
					 if(conn !=null){
						 closeAll(pstmt, rsshiftnames);
					 }
					
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftByLocation Ending");
		
		return shiftList;
	}
	
	
	
	public synchronized List<ShiftDetails> getShiftBasedLocationONETL(String location,Connection datbaseConnection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftBasedLocation Starting");
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsshiftnames=null;
		ArrayList<ShiftDetails>	shiftList=new ArrayList<ShiftDetails>();
		try{
			conn= datbaseConnection;
			pstmt=conn.prepareStatement(SQLutilConstants.ETL_SHIFT_FETCH);
			
			System.out.println("In Dao Group - "+location);
			
				pstmt.setString(1,location);
				
		
			
			 rsshiftnames=pstmt.executeQuery();
			System.out.println("After Exceute::::"+pstmt);
		   	while(rsshiftnames.next()){
				 ShiftDetails shiftMasterVO =new ShiftDetails();
				shiftMasterVO.setAI_SHIFT_ID(rsshiftnames.getString("AI_SHIFT_ID"));
				shiftMasterVO.setAI_SHIFT_NAME(rsshiftnames.getString("AI_SHIFT_NAME"));
				System.out.println(rsshiftnames.getString("LocationCode")+"   "+rsshiftnames.getString("Location"));
				shiftMasterVO.setLocationId(rsshiftnames.getString("LocationCode"));
				shiftMasterVO.setLocation(rsshiftnames.getString("Location"));
				shiftMasterVO.setAI_SHIFT_START_TIME(rsshiftnames.getTime(SQLutilConstants.AI_SHIFT_START_TIME));
				shiftMasterVO.setAI_SHIFT_END_TIME(rsshiftnames.getTime(SQLutilConstants.AI_SHIFT_END_TIME));
				shiftMasterVO.setAI_SHIFT_LTOC(rsshiftnames.getTime(SQLutilConstants.AI_SHIFT_LTOC));
				shiftMasterVO.setAI_SHIFT_ETOG(rsshiftnames.getTime(SQLutilConstants.AI_SHIFT_ETOG));
				
				
				
				
				shiftList.add(shiftMasterVO);
			}
		   	
		   	
		   		pstmt.close();
		} catch (SQLException e) {
			   
	        e.printStackTrace();
	      }catch (Exception e) {
				
				e.printStackTrace();
			}
			finally{
				
				 
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterDaoImpl:getShiftBasedLocation Ending");
		
		return shiftList;
	}
	
	public static void main(String[] args) {
	
	}
	
}
