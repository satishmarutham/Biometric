/**
 * 
 */
package com.centris.DAO;

import java.util.List;

import com.centris.VO.WeekOffSettingVo;
import com.centris.form.WeekoffSettingForm;

/**
 * @author satish
 *
 */
public interface WeekOffSettingDao {
public List<WeekOffSettingVo> getWeekofDetailsByEmployeeId(String empId);
public String insertWeekOffDetails(WeekoffSettingForm settingForm);
}
