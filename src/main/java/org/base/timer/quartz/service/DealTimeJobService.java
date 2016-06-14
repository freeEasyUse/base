package org.base.timer.quartz.service;

import java.util.Map;

/**
 * 
 * <p>Title:DealTimeJobService</p>
 * <p>description:操作定时任务接口</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月14日
 *
 */
public interface DealTimeJobService {

	/**
	 * 按组暂停任务
	 * @param group
	 * @return
	 */
	public boolean interruptGroup(String group);
	
	/**
	 * 暂停任务
	 * @param name
	 * @return
	 */
	public boolean interruptJob(String name,String group);
	
	/**
	 * 启动任务
	 * @param name
	 * @return
	 */
	public boolean startJob(String name,String group);

	
	/**
	 * 修改任务触发条件
	 * @param condition
	 * @return
	 */
	public boolean updateJobTrriger(Map<String, Object> condition);
	
	public boolean removeAllJob();
}
