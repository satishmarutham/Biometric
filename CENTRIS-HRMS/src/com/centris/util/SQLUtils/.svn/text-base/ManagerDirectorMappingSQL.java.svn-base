package com.centris.util.SQLUtils;

public class ManagerDirectorMappingSQL {
	public static final String GET_DIRECTORS = "select emp.bioid,emp.First_Name,dir.DirectorCode from hrms_director dir ,hrms_employee emp where emp.EMPID=dir.EMPID and dir.isActive='Y'";
    public static final String GET_AVAILABLE_MANAGERS="select e.bioid,m.ManagerCode,m.FirstName from hrms_manager m ,hrms_employee e where m.ManagerCode NOT IN(select em.ManagerCode from hrms_manager_director_mapping em) and  m.isActive='Y' and m.EMPID=e.EMPID";
    public static final String DELETE_MANAGER_DIRECTOR_MAP = "delete from hrms_manager_director_mapping where DirectorCode=?";
    public static final String INSERT_MANAGER_DIRECTOR = "insert into hrms_manager_director_mapping(ManagerCode,DirectorCode,CreatedBy,CreateTime) values(?,?,?,now())";
    public static final String GET_MAPPED_MANAGERS="select ManagerCode from hrms_manager_director_mapping where DirectorCode=?";
    public static final String GET_MAPPED_MANAGER_DETAILS="select e.First_Name,e.bioid from hrms_employee e where  e.EMPID=(select EMPID from hrms_manager where ManagerCode=?)";


}
