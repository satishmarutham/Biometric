package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeResumeCreationDao;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.EmployeeResumeCreationVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeResumeCreation;
import com.centris.util.constants.MessageConstants;

public class EmployeeResumeCreationDaoImpl extends DBService implements
		EmployeeResumeCreationDao {
	private static Logger logger = Logger
			.getLogger(EmployeeResumeCreationDaoImpl.class);

	
	public Map<String, List<EmployeeResumeCreationPojo>> getResumeDetails(
			String employeeCode) throws Exception {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl:getDayReportDetails Starting");

		List<EmployeeResumeCreationPojo> respoList = new ArrayList<EmployeeResumeCreationPojo>();
		List<EmployeeResumeCreationPojo> hobbiesList = new ArrayList<EmployeeResumeCreationPojo>();
		List<EmployeeResumeCreationPojo> technicalSkillsList = new ArrayList<EmployeeResumeCreationPojo>();
		List<EmployeeResumeCreationPojo> pursuitsList = new ArrayList<EmployeeResumeCreationPojo>();

		List<EmployeeResumeCreationPojo> careerObjectiveList = new ArrayList<EmployeeResumeCreationPojo>();
		List<EmployeeResumeCreationPojo> employeeDetailsList = new ArrayList<EmployeeResumeCreationPojo>();
		List<EmployeeResumeCreationPojo> experienceList = new ArrayList<EmployeeResumeCreationPojo>();
		Map<String, List<EmployeeResumeCreationPojo>> resumeDetails = new HashMap<String, List<EmployeeResumeCreationPojo>>();

		Connection connection = null;
		//
		PreparedStatement preparedStatement = null;
		EmployeeResumeCreationVo creationVo = new EmployeeResumeCreationVo();
		ResultSet resultSet = null;
		String successMessage="";
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_RESPONSIBILITIES);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setResponsibilities(resultSet
						.getString("RESPONSIBILITIES"));
				employeeResumeCreationPojo.setResponsibilitiesSno(resultSet
						.getString("SNO"));
				employeeResumeCreationPojo.setResponsibilitiesCode(resultSet
						.getString("ResCode"));

				respoList.add(employeeResumeCreationPojo);

			}

			resumeDetails.put("Responsibilities", respoList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_HOBBIES_SPORTS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setHobbies(resultSet
						.getString("HOBBIES"));
				employeeResumeCreationPojo.setHobbiesCode(resultSet
						.getString("HOBCode"));
				employeeResumeCreationPojo.setHobbiesSno(resultSet
						.getString("SNO"));
				hobbiesList.add(employeeResumeCreationPojo);

			}
			resumeDetails.put("Hobbies", hobbiesList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_TECHNICALSKILLS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setTechnicalSkills(resultSet
						.getString("TECHNICALSKILL"));
				employeeResumeCreationPojo.setTechnicalSkillsSno(resultSet
						.getString("SNO"));
				employeeResumeCreationPojo.setTechnicalSkillsCode(resultSet
						.getString("TECHCode"));

				technicalSkillsList.add(employeeResumeCreationPojo);

			}

			resumeDetails.put("TechnicalSkills", technicalSkillsList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_PURSUITS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setPursuitsCode(resultSet
						.getString("PURSITCode"));
				employeeResumeCreationPojo.setPursuitSno(resultSet
						.getString("SN"));
				employeeResumeCreationPojo.setPursuits(resultSet
						.getString("PURSUITS"));
				pursuitsList.add(employeeResumeCreationPojo);

			}

			resumeDetails.put("PursuitsList", pursuitsList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GETCARRER_OBJECTIVE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setCarrerObjective(resultSet
						.getString("Objective"));
				employeeResumeCreationPojo.setCarrerObjectiveCode(resultSet
						.getString("CBCode"));
				employeeResumeCreationPojo.setEmployeeId(resultSet.getString("EMPCODE"));
				employeeResumeCreationPojo.setCarrerObjectSno(resultSet.getString("SN"));
				careerObjectiveList.add(employeeResumeCreationPojo);

			}
			resumeDetails.put("CareerObjective", careerObjectiveList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_EMPLOYEE_DETAILS_BY_CODE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setEmployeeName(resultSet
						.getString("First_Name").trim());
				employeeResumeCreationPojo.setEmail(resultSet
						.getString("Personal_Email_ID").trim());
				employeeResumeCreationPojo.setPhoneNo(resultSet
						.getString("Mobile_Number").trim());
				employeeResumeCreationPojo.setDob(HelperClass.convertDatabaseToUI(resultSet.getString("DOB")));
				employeeResumeCreationPojo.setMartialStatus(resultSet
						.getString("Marital_Status"));
				employeeResumeCreationPojo.setBaseLocation(resultSet
						.getString("BaseLocation"));
				employeeResumeCreationPojo.setGender(resultSet
						.getString("gender"));

				employeeResumeCreationPojo.setMajorQualification(resultSet
						.getString("Major_Qualification"));

				employeeResumeCreationPojo.setYearofPassing(resultSet
						.getString("Year_of_passing"));

				employeeResumeCreationPojo.setUniversity(resultSet
						.getString("University_Board"));

				employeeResumeCreationPojo.setPresentAddress(resultSet
						.getString("Present_Address"));
				employeeResumeCreationPojo
						.setCollageInStitute("College_Institute");

				employeeDetailsList.add(employeeResumeCreationPojo);

			}
			resumeDetails.put("EmployeeDetails", employeeDetailsList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_EXPERIENCE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();
				employeeResumeCreationPojo.setExperience(resultSet
						.getString("EXPERIENCE"));
				employeeResumeCreationPojo.setExperienceCode(resultSet
						.getString("EXPCode"));
				employeeResumeCreationPojo.setExperienceSno(resultSet
						.getString("SNO"));
				experienceList.add(employeeResumeCreationPojo);

			}
			resumeDetails.put("Experience", experienceList);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (preparedStatement != null
						&& (!preparedStatement.isClosed())) {
					preparedStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl Ending");

		// TODO Auto-generated method stub
		return resumeDetails;

		// TODO Auto-generated method stub

	}

	public List<EmployeeResumeCreationPojo> getResumeDetailsDownload(
			String employeeCode) throws Exception {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl:getDayReportDetails Starting");
List<EmployeeResumeCreationPojo> resumeDetails = new ArrayList<EmployeeResumeCreationPojo>();

		Connection connection = null;
		//
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GETCARRER_OBJECTIVE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();
			
			boolean flag1=false;

			while (resultSet.next()) {
				flag1=true;
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setDescription(resultSet
						.getString("Objective").trim());
				employeeResumeCreationPojo.setType("CarrerObjective");
				employeeResumeCreationPojo.setEmployeeId(resultSet.getString("EMPCODE"));
				employeeResumeCreationPojo.setSno("");
				
				
resumeDetails.add(employeeResumeCreationPojo);
			}
			
			if(!flag1){
				
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();
				employeeResumeCreationPojo.setType("CarrerObjective");
				resumeDetails.add(employeeResumeCreationPojo);
				employeeResumeCreationPojo.setDescription("");
				employeeResumeCreationPojo.setSno("");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_PURSUITS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setDescription(resultSet
						.getString("PURSUITS"));
				employeeResumeCreationPojo.setType("Pursuits");

				employeeResumeCreationPojo.setSno(resultSet.getString("SN"));

				resumeDetails.add(employeeResumeCreationPojo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_HOBBIES_SPORTS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setDescription(resultSet
						.getString("HOBBIES"));
				employeeResumeCreationPojo.setType("Hobbies");

				employeeResumeCreationPojo.setSno(resultSet.getString("SNO"));
				resumeDetails.add(employeeResumeCreationPojo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_EMPLOYEE_DETAILS_BY_CODE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeResumeCreationPojo qualificationPojo = new EmployeeResumeCreationPojo();

				String qualification = resultSet
						.getString("Major_Qualification");
				if (qualification != null || qualification != "")
					qualificationPojo.setSno("Qualification:");
				qualificationPojo.setDescription(resultSet
						.getString("Major_Qualification"));
				qualificationPojo.setType("Education Details");
				resumeDetails.add(qualificationPojo);

				EmployeeResumeCreationPojo university = new EmployeeResumeCreationPojo();
				String University = resultSet.getString("University_Board");

				if (University != null || University != "") {

					university.setSno("University :".trim());
					university.setDescription(resultSet
							.getString("University_Board"));
					university.setType("Education Details");
					resumeDetails.add(university);
				}
				EmployeeResumeCreationPojo collegePojo = new EmployeeResumeCreationPojo();
				String college = resultSet.getString("College_Institute");
				if (college != null || college != "") {
					collegePojo.setSno("College	  :".trim());
					collegePojo.setDescription(resultSet
							.getString("College_Institute"));
					collegePojo.setType("Education Details");
					resumeDetails.add(collegePojo);
				}
				EmployeeResumeCreationPojo martialStatusPojo = new EmployeeResumeCreationPojo();
				String martial = resultSet.getString("Marital_Status");
			
				if (martial != null) {
					martialStatusPojo.setSno("MaritalStatus:");
					martialStatusPojo.setDescription(resultSet
							.getString("Marital_Status"));
					martialStatusPojo.setType("Personal Details");
					resumeDetails.add(martialStatusPojo);

				}
				EmployeeResumeCreationPojo dateofBirthPojo = new EmployeeResumeCreationPojo();

				dateofBirthPojo.setSno("DOB         :".trim());
				dateofBirthPojo.setDescription(HelperClass.convertDatabaseToUI(resultSet.getString("DOB")));
				dateofBirthPojo.setType("Personal Details");
				resumeDetails.add(dateofBirthPojo);
				EmployeeResumeCreationPojo contactNoPojo = new EmployeeResumeCreationPojo();
				String mobileNo = resultSet.getString("Mobile_Number");
				if (mobileNo != null || mobileNo != "") {
					contactNoPojo.setSno("Phone No :".trim());
					contactNoPojo.setDescription(resultSet
							.getString("Mobile_Number"));
					contactNoPojo.setType("Personal Details");
					resumeDetails.add(contactNoPojo);
				}
				
				EmployeeResumeCreationPojo genderPojo = new EmployeeResumeCreationPojo();
				String gender = resultSet.getString("gender");
				if (gender != null) {
					genderPojo.setDescription(resultSet.getString("gender"));
					genderPojo.setSno(""+"Gender    :".trim());
					genderPojo.setType("Personal Details");
					genderPojo.setEmployeeName(resultSet
							.getString("First_Name"));
					resumeDetails.add(genderPojo);

				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}
		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_TECHNICALSKILLS);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();

				employeeResumeCreationPojo.setDescription(resultSet
						.getString("TECHNICALSKILL"));
				employeeResumeCreationPojo.setType("Technical Skills");

				employeeResumeCreationPojo.setSno(resultSet.getString("SNO"));

				resumeDetails.add(employeeResumeCreationPojo);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_RESPONSIBILITIES);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();
				employeeResumeCreationPojo.setSno(resultSet.getString("SNO"));
				employeeResumeCreationPojo.setDescription(resultSet
						.getString("RESPONSIBILITIES"));
				employeeResumeCreationPojo.setType("Responsibilities");

				resumeDetails.add(employeeResumeCreationPojo);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		try {
			connection = getConnection();
			preparedStatement = connection
					.prepareStatement(EmployeeResumeCreation.GET_EXPERIENCE);
			preparedStatement.setString(1, employeeCode);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				EmployeeResumeCreationPojo employeeResumeCreationPojo = new EmployeeResumeCreationPojo();
				employeeResumeCreationPojo.setDescription(resultSet
						.getString("EXPERIENCE"));
				employeeResumeCreationPojo.setType("Experience");
				employeeResumeCreationPojo.setSno(resultSet.getString("SNO"));

				resumeDetails.add(employeeResumeCreationPojo);

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (preparedStatement != null
						&& (!preparedStatement.isClosed())) {
					preparedStatement.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl Ending");

		// TODO Auto-generated method stub
		return resumeDetails;

		// TODO Auto-generated method stub

	}

	
	public EmployeeResumeCreationPojo personalDetailsById(String employeeCode)
			throws Exception {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeResumeCreationDaoImpl:createResume Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
	
		conn = getConnection();
	
		EmployeeResumeCreationPojo creationPojo = null;
		try {

			pstmt = conn
					.prepareStatement(EmployeeResumeCreation.GET_EMPLOYEE_DETAILS);
			pstmt.setString(1, employeeCode);
			
			System.out.println("pstmt ::: "+pstmt.toString());
			
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				System.out.println("in while");
				creationPojo = new EmployeeResumeCreationPojo();

				creationPojo.setEmployeeName(resultSet.getString("First_Name"));
				creationPojo.setEmail(resultSet.getString("Username"));
				creationPojo.setPresentAddress(resultSet
						.getString("Present_Address"));
				creationPojo.setPhoneNo(resultSet.getString("Mobile_Number"));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		}

		return creationPojo;

	}

	
	
	public String createResumeEmployee(EmployeeResumeCreationPojo createResumePojo)
			throws Exception {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeResumeCreationDaoImpl:createResume Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		IDGenerator generator = new IDGenerator();
		
		int employeeCodeCount = 0;
		String[] pursuitsArray = createResumePojo.getPursuits().split(",");
		
		String[] hobbiesArray =createResumePojo.getHobbies().split(",");
		String[] responsibilitiesArray = createResumePojo.getResponsibilities().split(",");
		String[] technicalSkillsArray=createResumePojo.getTechnicalSkills().split(",");
		String[] experienceArray=createResumePojo.getExperience().split(",");
		String[] hobbiesSno=createResumePojo.getHobbiesSno().split(",");
		String[] pursuitsSnoArray=createResumePojo.getPursuitSno().split(",");
		
		String[] technicalSkillsSnoArray=createResumePojo.getTechnicalSkillsSno().split(",");
		String[] experienceSnoArray=createResumePojo.getExperienceSno().split(",");
		String[] responsibilitiesSnoArray = createResumePojo.getResponsibilitiesSno().split(",");
		
		List<String> hobbiesList=new ArrayList<String>();
		hobbiesList=(List<String>)Arrays.asList(hobbiesArray);
		List<String> responsibilitiesList=new ArrayList<String>();
		responsibilitiesList=(List<String>)Arrays.asList(responsibilitiesArray);
		
		
		
		List<String> pursuitsList=new ArrayList<String>();
		pursuitsList=(List<String>)Arrays.asList(pursuitsArray);
		
		
		

		List<String> technicalList=new ArrayList<String>();
		technicalList=(List<String>)Arrays.asList(technicalSkillsArray);
		
		List<String> experienceList=new ArrayList<String>();
		experienceList=(List<String>)Arrays.asList(experienceArray);
		
		List<String> hobbiesSnoList=new ArrayList<String>();
		hobbiesSnoList=(List<String>)Arrays.asList(hobbiesSno);
		
	
		List<String> pursuitsSnoList=new ArrayList<String>();
		pursuitsSnoList=(List<String>)Arrays.asList(pursuitsSnoArray);
		
		
		List<String> technicalSkillsSnoList=new ArrayList<String>();
		technicalSkillsSnoList=(List<String>)Arrays.asList(technicalSkillsSnoArray);
		
		
		List<String> experienceSnoList=new ArrayList<String>();
		experienceSnoList=(List<String>)Arrays.asList(experienceSnoArray);
		
		
		String successMessage="";
		
		List<String> responsibilitiesSnoList=new ArrayList<String>();
		responsibilitiesSnoList=(List<String>)Arrays.asList(responsibilitiesSnoArray);
		
		try {
			conn = getConnection();
				
				int carrierCount = 0;
				
				try {
pstmt = conn.prepareStatement(EmployeeResumeCreation.COUNT_CARRER_OBJECTIVE);
					pstmt.setString(1,createResumePojo.getEmployeeId());
					pstmt.setString(2,createResumePojo.getCarrerObjectSno());
					resultSet = pstmt.executeQuery();
while (resultSet.next()) {
						carrierCount = resultSet.getInt(1);
					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				}
				if(carrierCount==0)
				{
					carrierCount++;
					pstmt = conn
							.prepareStatement(EmployeeResumeCreation.INSERT_CARRER_OBJECTIVE);

				
					pstmt.setString(1, generator
							.getPrimaryKeyID("hrms_resume_careerobjective"));
					pstmt.setString(2,createResumePojo.getEmployeeId());

					pstmt.setInt(3,carrierCount);

					pstmt.setString(4,createResumePojo.getCarrerObjective().trim());
					pstmt.setString(5,createResumePojo.getEmployeeId());
					pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
					int carreObjMsg=pstmt.executeUpdate();
					if(carreObjMsg>0){
						successMessage="Resume Created Successfully";
					}
					
					
				}
				else
				{
					pstmt = conn
							.prepareStatement(EmployeeResumeCreation.UPDATE_CARRER_OBJECTIVE);

					pstmt.setString(1,createResumePojo.getCarrerObjective().trim());
					pstmt.setString(2,createResumePojo.getEmployeeId());

					pstmt.setTimestamp(3,HelperClass.getCurrentTimestamp());

					pstmt.setString(4,createResumePojo.getEmployeeId());
					pstmt.setString(5,createResumePojo.getCarrerObjectSno());
					
					int carreObjUpMsg=pstmt.executeUpdate();
					if(carreObjUpMsg>0){
						successMessage="Resume Saved Successfully";
					}
				}
				
			for (int j = 0; j < hobbiesList.size();j++) {
				int hobbiesCount=0;
				try {


					pstmt = conn
							.prepareStatement(EmployeeResumeCreation.COUNT_HOBBIES_SPORTS);
				
					if(hobbiesSnoList.get(j)!=""){
					
						pstmt.setString(1,createResumePojo.getEmployeeId());
					pstmt.setInt(2,Integer.parseInt(hobbiesSnoList.get(j).trim()));
					resultSet = pstmt.executeQuery();
					}
					

					while (resultSet.next()) {
						hobbiesCount = resultSet.getInt(1);
					}

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				}
				
				if(hobbiesCount==0){
					int hobbiesInsertMessage=0;
			
				pstmt = conn
						.prepareStatement(EmployeeResumeCreation.INSERT_HOBBIES_SPORTS);
				if(hobbiesSnoList.get(j)!=""){
				pstmt.setString(1, generator
						.getPrimaryKeyID("hrms_resume_hobbiesnsports"));
				pstmt.setString(2,createResumePojo.getEmployeeId());
				pstmt.setInt(3,Integer.parseInt(hobbiesSnoList.get(j).trim()));
				pstmt.setString(4,hobbiesList.get(j));
				pstmt.setString(5, createResumePojo.getEmployeeId());
				pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
				hobbiesInsertMessage=pstmt.executeUpdate();
				}
				if(hobbiesInsertMessage>0){
					successMessage="Resume Saved Successfully";
				}
			
				}
				else
				{
					if(hobbiesSnoList.get(j)!=""){
						int hobbiesUpdateMessage=0;
					pstmt = conn
							.prepareStatement(EmployeeResumeCreation.UPDATE_HOBBIES_SPORTS);
pstmt.setString(1,hobbiesList.get(j));

					pstmt.setString(2,createResumePojo.getEmployeeId());
					pstmt.setTimestamp(3,HelperClass.getCurrentTimestamp());
					pstmt.setString(4,createResumePojo.getEmployeeId());
					pstmt.setInt(5,Integer.parseInt(hobbiesSnoList.get(j).trim()));
					 hobbiesUpdateMessage=pstmt.executeUpdate();
					 if(hobbiesUpdateMessage>0){
							successMessage="Resume Saved Successfully";
						}
					}
					
				
			}
			}
			
			for (int k = 0; k < responsibilitiesList.size(); k++) {
				int responsibilities = 0;
				try {


					pstmt = conn
							.prepareStatement(EmployeeResumeCreation.COUNT_RESPONSIBILITIES);
					if(responsibilitiesSnoList.get(k)!=""){
					pstmt.setString(1,createResumePojo.getEmployeeId());
					pstmt.setInt(2,Integer.parseInt(responsibilitiesSnoList.get(k).trim()));
			
					resultSet = pstmt.executeQuery();

					while (resultSet.next()) {
						responsibilities = resultSet.getInt(1);
					}
}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				}
				if(responsibilities==0){
					int responCount=0;
			pstmt = conn.prepareStatement(EmployeeResumeCreation.INSERT_RESPONSIBILITIES);
if(responsibilitiesSnoList.get(k)!=""){
				pstmt.setString(1, generator.getPrimaryKeyID("hrms_resume_responsibilities"));
				pstmt.setString(2,createResumePojo.getEmployeeId());

				pstmt.setInt(3,Integer.parseInt(responsibilitiesSnoList.get(k).trim()));

				pstmt.setString(4,responsibilitiesList.get(k).trim());
				pstmt.setString(5,createResumePojo.getEmployeeId());
				pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
				responCount=pstmt.executeUpdate();
}
				if(responCount>0){
					successMessage="Resume Saved Successfully";
				}
}else {
	int responCount=0;
			pstmt = conn.prepareStatement(EmployeeResumeCreation.UPDATE_RESPONSIBILITIES);
			if(responsibilitiesSnoList.get(k)!=""){
				
			
pstmt.setString(1,responsibilitiesList.get(k));
			pstmt.setString(2,createResumePojo.getEmployeeId());
			pstmt.setTimestamp(3, HelperClass.getCurrentTimestamp());
			pstmt.setString(4,createResumePojo.getEmployeeId());
			pstmt.setInt(5,Integer.parseInt(responsibilitiesSnoList.get(k)));
			 responCount=pstmt.executeUpdate();
}
if(responCount>0){
				successMessage="Resume Saved Successfully";
			}
			}
			}
		
			
		
			for (int l = 0; l < pursuitsList.size(); l++) {
			
				
				int pursuitCount=0;
				try {
                    pstmt = conn.prepareStatement(EmployeeResumeCreation.COUNT_PURSUITS);
                    if(pursuitsSnoList.get(l)!=""){
					pstmt.setString(1,createResumePojo.getEmployeeId());
					pstmt.setInt(2,Integer.parseInt(pursuitsSnoList.get(l).trim()));
			
					resultSet = pstmt.executeQuery();

					while (resultSet.next()) {
						pursuitCount = resultSet.getInt(1);
					}
                    }
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				}
				
				if(pursuitCount==0){
			pstmt = conn
						.prepareStatement(EmployeeResumeCreation.INSERT_PURSUITS);
			 if(pursuitsSnoList.get(l)!=""){

				pstmt.setString(1,
						generator.getPrimaryKeyID("hrms_resume_pursuits"));
				pstmt.setString(2,createResumePojo.getEmployeeId());

				pstmt.setInt(3,Integer.parseInt(pursuitsSnoList.get(l).trim()));

				pstmt.setString(4,pursuitsList.get(l));
				pstmt.setString(5,createResumePojo.getEmployeeId());
				pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
			
				int pursuitMessage=pstmt.executeUpdate();
				if(pursuitMessage>0){
					successMessage="Resume Saved Successfully";
				}
			 }
			}
				else
				{
			pstmt = conn.prepareStatement(EmployeeResumeCreation.UPDATE_PURSUITS);
			 if(pursuitsSnoList.get(l)!=""){
				pstmt.setString(1,pursuitsList.get(l));
				pstmt.setString(2,createResumePojo.getEmployeeId());
				pstmt.setTimestamp(3,HelperClass.getCurrentTimestamp());
				pstmt.setString(4,createResumePojo.getEmployeeId());
				pstmt.setInt(5,Integer.parseInt(pursuitsSnoList.get(l).trim()));
				int pursuitMessage=pstmt.executeUpdate();
				if(pursuitMessage>0){
					successMessage="Resume Saved Successfully";
				}
			}
				}
			}
			for (int m = 0; m < technicalList.size(); m++) {
				int technicalSkillsCount=0;
				try {
					if(technicalSkillsSnoList.get(m)!=""){
pstmt = conn.prepareStatement(EmployeeResumeCreation.COUNT_TECHNICALSKILLS);
					pstmt.setString(1,createResumePojo.getEmployeeId());
					pstmt.setInt(2,Integer.parseInt(technicalSkillsSnoList.get(m).trim()));
			
					resultSet = pstmt.executeQuery();

					while (resultSet.next()) {
						technicalSkillsCount = resultSet.getInt(1);
					}
					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				}
				if(technicalSkillsCount==0){
				pstmt = conn
						.prepareStatement(EmployeeResumeCreation.INSERT_TECHNICALSKILLS);
				if(technicalSkillsSnoList.get(m)!=""){
				pstmt.setString(1, generator
						.getPrimaryKeyID("hrms_resume_technicalskills"));
				pstmt.setString(2,createResumePojo.getEmployeeId());

				pstmt.setInt(3,Integer.parseInt(technicalSkillsSnoList.get(m).trim()));

				pstmt.setString(4,technicalList.get(m));
				pstmt.setString(5,createResumePojo.getEmployeeId());
				pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
				int technicalSkillsMessage=pstmt.executeUpdate();
				if(technicalSkillsMessage>0){
					successMessage="Resume Saved Successfully";
				}
				}

			}
		
			else
			{
				
				pstmt = conn
						.prepareStatement(EmployeeResumeCreation.UPDATE_TECHNICALSKILLS);
				if(technicalSkillsSnoList.get(m)!=""){
				pstmt.setString(1,technicalList.get(m));

				pstmt.setString(2,createResumePojo.getEmployeeId());
				pstmt.setTimestamp(3,HelperClass.getCurrentTimestamp());
				pstmt.setString(4,createResumePojo.getEmployeeId());
				pstmt.setInt(5,Integer.parseInt(technicalSkillsSnoList.get(m).trim()));
			
				
				int technicalSkillsMessage=pstmt.executeUpdate();
				if(technicalSkillsMessage>0){
					successMessage="Resume Saved Successfully";
				}
}
			}
		}
		for (int n = 0; n < experienceList.size(); n++) {
				int experienceCnt = 0;
				try {
					pstmt = conn.prepareStatement(EmployeeResumeCreation.COUNT_EXPERIENCE);
					if(experienceSnoList.get(n)!=""){
										pstmt.setString(1,createResumePojo.getEmployeeId());
										pstmt.setInt(2,Integer.parseInt(experienceSnoList.get(n).trim()));
								
										resultSet = pstmt.executeQuery();

										while (resultSet.next()) {
											experienceCnt = resultSet.getInt(1);
										}
					}
									} catch (SQLException sqle) {
										sqle.printStackTrace();
										logger.error(sqle);
									}
				
				if(experienceCnt==0){
				
				pstmt = conn
						.prepareStatement(EmployeeResumeCreation.INSERT_EXPERIENCE);
				if(experienceSnoList.get(n)!=""){
				pstmt.setString(1,generator.getPrimaryKeyID("hrms_resume_experience"));
				pstmt.setString(2,createResumePojo.getEmployeeId());
pstmt.setInt(3,Integer.parseInt(experienceSnoList.get(n).trim()));
pstmt.setString(4,experienceList.get(n));
	pstmt.setString(5,createResumePojo.getEmployeeId());
	pstmt.setTimestamp(6,HelperClass.getCurrentTimestamp());
	int experienceMessage=pstmt.executeUpdate();
				if(experienceMessage>0){
					successMessage="Resume Saved Successfully";
				}	
				}
			else
			{
				int experienceMessage=0;
		
			pstmt = conn.prepareStatement(EmployeeResumeCreation.UPDATE_EXPERIENCE);
			if(experienceSnoList.get(n)!=""){
			pstmt.setString(1,experienceList.get(n));
            pstmt.setString(2,createResumePojo.getEmployeeId());
			pstmt.setTimestamp(3,HelperClass.getCurrentTimestamp());
			pstmt.setString(4,createResumePojo.getEmployeeId());
		      pstmt.setInt(5,Integer.parseInt(experienceSnoList.get(n).trim()));
		      
		      experienceMessage=pstmt.executeUpdate();
			}
				if(experienceMessage>0){
					successMessage="Resume Saved Successfully";
				}	
				
		
			}
			}
				
		}
		}
		
		
			
			catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			}
		finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
if(conn!=null && !conn.isClosed()){
	conn.close();
}
			
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}

		return successMessage;
	

}

	@Override
	public String deletePursuit(String employeeId, String deletePursuitSno) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pstmt=null;
		int deletePursuitCount=0;
		String deletePursuitMsg=null;
		try {
			pstmt = connection.prepareStatement(EmployeeResumeCreation.DELETE_PURSUITS);
								pstmt.setString(1,employeeId);
								pstmt.setInt(2,Integer.parseInt(deletePursuitSno.trim()));
								deletePursuitCount=pstmt.executeUpdate();
								if(deletePursuitCount>0){
									deletePursuitMsg="Pursuit Deleted Successfully";
								}
								else
								{
									deletePursuitMsg="Pursuit not Deleted";
								}
							} catch (SQLException sqle) {
								sqle.printStackTrace();
								logger.error(sqle);
							}
		// TODO Auto-generated method stub
		return deletePursuitMsg;
	}

	@Override
	public String deleteHobbies(String employeeId, String deleteHobbiesSno) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pstmt=null;
		int deleteHobbiesCount=0;
		String deleteHobbiesCountMsg=null;
		
		try {
			pstmt = connection.prepareStatement(EmployeeResumeCreation.DELETE_HOBBIES_SPORTS);
								pstmt.setString(1,employeeId);
								pstmt.setInt(2,Integer.parseInt(deleteHobbiesSno.trim()));
								deleteHobbiesCount=pstmt.executeUpdate();
								if(deleteHobbiesCount>0){
									deleteHobbiesCountMsg="Hobbies Deleted Successfully";
								}
								else
								{
									deleteHobbiesCountMsg="Hobbies Not Deleted";
								}
								
							} catch (SQLException sqle) {
								sqle.printStackTrace();
								logger.error(sqle);
							}
		return deleteHobbiesCountMsg;
	}

	@Override
	public String deleteTechnicalSkills(String employeeId,
			String deleteTechnicalSkillsSno) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pstmt=null;
		int deleteTechnicalSkillsCount=0;
		String deleteTechnicalSkillsCountMsg=null;
		try {
			pstmt = connection.prepareStatement(EmployeeResumeCreation.DELETE_TECHNICAL_SKILLS);
								pstmt.setString(1,employeeId);
								pstmt.setInt(2,Integer.parseInt(deleteTechnicalSkillsSno.trim()));
								pstmt.executeUpdate();
								if(deleteTechnicalSkillsCount>0){
									deleteTechnicalSkillsCountMsg="TechnicalSkills Deleted Successfully";
								}
								else
								{
									deleteTechnicalSkillsCountMsg="TechnicalSkills Not Deleted";
								}
								
							}
		
		
		catch (SQLException sqle) {
								sqle.printStackTrace();
								logger.error(sqle);
							}
		return deleteTechnicalSkillsCountMsg;
	}

	@Override
	public String deleteExperience(String employeeId, String deleteExperience) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pstmt=null;
		int experienceDeletCount=0;
		String deleteExpMessage=null;
		try {
			pstmt = connection.prepareStatement(EmployeeResumeCreation.DELETE_EXPERIENCE);
								pstmt.setString(1,employeeId);
								pstmt.setInt(2,Integer.parseInt(deleteExperience.trim()));
								experienceDeletCount=pstmt.executeUpdate();
								if(experienceDeletCount>0){
									deleteExpMessage="true";
								}
								else
								{
									deleteExpMessage="false";
								}
							} catch (SQLException sqle) {
								sqle.printStackTrace();
								logger.error(sqle);
							}
		return deleteExpMessage;
	}

	@Override
	public String deleteResponsibilities(String employeeId,
			String deleteResponsibilitiesSno) throws Exception {
		Connection connection = getConnection();
		PreparedStatement pstmt=null;
		int deleteResponsibilitiesCount=0;
		String deleteResponsibilitiesCountMsg=null;
		try {
			pstmt = connection.prepareStatement(EmployeeResumeCreation.DELETE_RESPONSIBILITIES);
								pstmt.setString(1,employeeId);
								pstmt.setInt(2,Integer.parseInt(deleteResponsibilitiesSno.trim()));
								pstmt.executeUpdate();
								if(deleteResponsibilitiesCount>0){
									deleteResponsibilitiesCountMsg="Responsibilities Deleted Successfully";
								}
								else
								{
									deleteResponsibilitiesCountMsg="Responsibilities Not Deleted";
								}
							} catch (SQLException sqle) {
								sqle.printStackTrace();
								logger.error(sqle);
							}
		return deleteResponsibilitiesCountMsg;
	}

}
	