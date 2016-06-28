package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.UserRolePermissionDAO;
import com.centris.VO.PermissionVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.form.UserRolePermissionForm;
import com.centris.util.HelperClass;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.SQLUtils.UserRolePermission;

public class UserRolePermissionDAOImpl extends DBService implements
		UserRolePermissionDAO {
	private static Logger logger = Logger.getLogger(UserRolePermissionDAOImpl.class);;
	@Override
	public synchronized UserRolePermissionVO getUserRolePermission() {
		UserRolePermissionVO userRolePermissionVO = new UserRolePermissionVO();
		try {
			userRolePermissionVO.setPermissionList(getPermissionDetails());
			userRolePermissionVO
					.setRoleList(new RoleMasterDaoImpl().getRoles());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return userRolePermissionVO;
	}

	public synchronized List<PermissionVO> getPermissionDetails() {
		PreparedStatement ps_Permission = null;
		ResultSet rs_Permission = null;
		Connection connection = null;
		List<PermissionVO> permissionVOList = new ArrayList<PermissionVO>();
		try {
			connection = getConnection();
			PermissionVO permissionVO = null;
			ps_Permission = connection
					.prepareStatement(UserRolePermission.GET_PERMISSION);
			rs_Permission = ps_Permission.executeQuery();
			while (rs_Permission.next()) {
				permissionVO = new PermissionVO();
				permissionVO.setPermissionId(rs_Permission
						.getString("PermissionCode"));
				permissionVO.setPermissionName(rs_Permission
						.getString("permission"));
				permissionVO.setPermissionShortName(rs_Permission
						.getString("shortName"));
				permissionVOList.add(permissionVO);
			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if (ps_Permission!=null && (!ps_Permission.isClosed())){
					ps_Permission.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return permissionVOList;
	}

	public synchronized List<PermissionVO> getPermissionByRole(String roleCode) {
		PreparedStatement ps_Permission = null;
		ResultSet rs_Permission = null;
		Connection connection = null;
		List<PermissionVO> permissionVOList = new ArrayList<PermissionVO>();
		try {
			connection = getConnection();
			PermissionVO permissionVO = null;
			ps_Permission = connection
					.prepareStatement(UserRolePermission.GET_PERMISSION_BY_ROLE);
			ps_Permission.setString(1, roleCode);
			rs_Permission = ps_Permission.executeQuery();
			while (rs_Permission.next()) {
				permissionVO = new PermissionVO();
				permissionVO.setPermissionId(rs_Permission
						.getString("permissionCode"));
				permissionVO.setPermissionIsApplicable(rs_Permission
						.getString("isApplicable"));
				permissionVOList.add(permissionVO);
			}
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {
				if (ps_Permission!=null && (!ps_Permission.isClosed())){
					ps_Permission.getConnection().close();
				}
			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return permissionVOList;
	}

	@Override
	public synchronized UserRolePermissionVO insertRolePermission(
			UserRolePermissionForm userRolePermission) {

		Connection connection = null;
		PreparedStatement ps_Permission = null;
		UserRolePermissionVO userRolePermissionVO = new UserRolePermissionVO();
		try {
			connection = getConnection();
			PermissionVO permissionVO = removePermission(
					userRolePermission.getRoleCode(),
					userRolePermission.getRoleName());

			ps_Permission = connection
					.prepareStatement(UserRolePermission.INSERT_ROLE_PERMISSION_MAPPING);
			for (int i = 0; i < userRolePermission.getPermissionCode().length; i++) {
				int inserCount = 0;
				ps_Permission.setString(1,
						userRolePermission.getPermissionCode()[i]);
				ps_Permission.setString(2, userRolePermission.getRoleCode());
				ps_Permission.setString(3,
						userRolePermission.getPermissionShortName()[i]);
				ps_Permission.setString(4,userRolePermission.getIsPermissionAllowed()[i]);
				ps_Permission.setString(5,userRolePermission.getPermission()[i]);
				ps_Permission.setString(6,userRolePermission.getCreatedBy());
				ps_Permission.setTimestamp(7,HelperClass.getCurrentTimestamp());
				inserCount = ps_Permission.executeUpdate();
				if (inserCount > 0) {
					userRolePermissionVO.setServerMessage(userRolePermission
							.getRoleName() + " Permissions Saved Successfully");
				}
			}
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (ps_Permission!=null && (!ps_Permission.isClosed())){
					ps_Permission.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return userRolePermissionVO;
	}

	@Override
	public synchronized PermissionVO removePermission(String roleCode,
			String roleName) {
		PreparedStatement ps_Permission = null;
		Connection connection = null;
		PermissionVO permissionVO = new PermissionVO();
		try {
			connection = getConnection();
			ps_Permission = connection
					.prepareStatement(UserRolePermission.DELETE_ROLE_PERMISSION_MAPPING);
			ps_Permission.setString(1, roleCode);
			int i = ps_Permission.executeUpdate();
			if (i > 0) {
				if (roleCode != null && roleCode.equals("All"))
					permissionVO.setServerMessage("Clear All Permission");
				else
					permissionVO.setServerMessage("Clear " + roleName
							+ " Permissions");
			}
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {

			try {

				if (ps_Permission!=null && (!ps_Permission.isClosed())){
					ps_Permission.getConnection().close();
				}

			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		return permissionVO;
	}

}
