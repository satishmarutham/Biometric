package com.centris.exception;
import org.apache.log4j.Logger;
public class AITrackerException extends Exception{

	private static Logger log = Logger.getLogger(AITrackerException.class);
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorDescription;

	public AITrackerException(String errorCode) {
		this.errorCode = errorCode;
	}

	public AITrackerException(String errorCode, String errorDescription) {

		this(errorCode, errorDescription, null);

	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public AITrackerException(String errorCode, String errorDescription,
			Throwable rootCause) {

		super("<" + errorCode + "> " + errorDescription, rootCause);

		this.errorCode = errorCode;

		this.errorDescription = errorDescription;

	}

	public String getErrorCode() {

		return errorCode;

	}

	public String getErrorDescription() {

		return errorDescription;

	}

	public AITrackerException() {
		super();
		printStackTrace();
		log.debug("Exception in AI-TRACKER EXCEPTION" + super.getStackTrace());

	}

	public AITrackerException(String classname, Exception ex) {

		super(ex);
		log.debug("Exception in " + classname + " : " + ex);
	}

	public static void main(String a[]) {
		try {
			@SuppressWarnings("unused")
			int i = 1 / 0;

			throw new AITrackerException();
		} catch (AITrackerException ee1) {
 		}
	}

}
