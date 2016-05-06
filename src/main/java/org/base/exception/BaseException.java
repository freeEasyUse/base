package org.base.exception;

/**
 * 
 * <p>Title:BaseException</p>
 * <p>description:自定义异常</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月6日
 *
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//是否异常  前端判断
	private Boolean error;
	
	//异常原因
	private String reason;

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
