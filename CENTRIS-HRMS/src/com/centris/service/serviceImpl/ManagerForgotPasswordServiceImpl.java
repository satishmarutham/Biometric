/**
 * 
 */
package com.centris.service.serviceImpl;

import com.centris.DAO.DAOIMPL.ManagerForgetPasswordDaoImpl;
import com.centris.delegate.ManagerForgotPasswordBD;
import com.centris.service.ManagerForgotPasswordService;

/**
 * @author sathish
 *
 */
public class ManagerForgotPasswordServiceImpl implements ManagerForgotPasswordService{

	@Override
	public int resetManagerPassword(String username, String email) {
		// TODO Auto-generated method stub
		return new ManagerForgetPasswordDaoImpl().resetManagerPassword(username,email);
	}

}
