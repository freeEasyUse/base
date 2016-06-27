package org.base.web.vo;

import java.util.List;

public class PageInfo<T> extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int pageIndex;
	
	private int rowCount;
	
	private int allCount;
	
	private List<T> result;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
