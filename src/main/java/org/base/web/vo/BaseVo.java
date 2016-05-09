package org.base.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>Title:BaseVo</p>
 * <p>description:base web vo</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月9日
 *
 */
public class BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String oprator;
	
	private Date opratorTime;

	public String getOprator() {
		return oprator;
	}

	public void setOprator(String oprator) {
		this.oprator = oprator;
	}

	public Date getOpratorTime() {
		return opratorTime;
	}

	public void setOpratorTime(Date opratorTime) {
		this.opratorTime = opratorTime;
	}
}
