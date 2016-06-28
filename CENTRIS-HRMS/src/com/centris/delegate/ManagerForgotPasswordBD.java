/**
 * 
 */
package com.centris.delegate;

import com.centris.service.serviceImpl.ManagerForgotPasswordServiceImpl;

/**
 * @author sathish
 *
 */
public class ManagerForgotPasswordBD {
public int resetManagerPassword(String username,String email){
	return new ManagerForgotPasswordServiceImpl().resetManagerPassword(username, email);
}
}
