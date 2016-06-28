/**
 * 
 */
package com.centris.VO;

import java.io.Serializable;

/**
 * @author satish
 *
 */
public class DirectorVo implements Serializable {
private String directorCode;
private String directorName;
public String getDirectorCode() {
	return directorCode;
}
public void setDirectorCode(String directorCode) {
	this.directorCode = directorCode;
}
public String getDirectorName() {
	return directorName;
}
public void setDirectorName(String directorName) {
	this.directorName = directorName;
}


}
