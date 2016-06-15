package org.base.timer.quartz.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DealTimeJobServiceImpl implements DealTimeJobService,ApplicationContextAware {

	//spring上下文
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	/**
	 * 暂停定时任务
	 */
	@Override
	public boolean interruptJob(String name,String group) {
		boolean result = false;
		Scheduler scheduler = this.getScheduler();
		try {
			//暂停任务
			JobKey jobKey = getObjectKey(group,name,scheduler,false);
			//暂停触发器
			TriggerKey triggerKey = getObjectKey(group, name, scheduler, true);
			if(jobKey!=null&&triggerKey!=null){
				scheduler.interrupt(jobKey);
				scheduler.pauseTrigger(triggerKey);
			}
			result = scheduler.interrupt(new JobKey(name, group));
		} catch (Exception e) {
		}
		return result;
	}

	
	/**
	 * 重启定时任务
	 */
	@Override
	public boolean startJob(String name,String group) {
		Scheduler scheduler = this.getScheduler();
		try {
			//获取暂停的组
			Set<String> pauseds = scheduler.getPausedTriggerGroups();
			for(String pausedGroup:pauseds){
				if(StringUtils.endsWithIgnoreCase(pausedGroup, group)){
					Set<JobKey>  jobkeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group));
					for(JobKey jobKey:jobkeys){
						if(StringUtils.endsWithIgnoreCase(name, jobKey.getName())){
							scheduler.resumeJob(jobKey);
						}
					}
					Set<TriggerKey> triggers = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(group));
					for(TriggerKey triggerKey:triggers){
						if(StringUtils.endsWithIgnoreCase(name, triggerKey.getName())){
							scheduler.resumeTrigger(triggerKey);
						}
					}
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	/**
	 * 修改触发器
	 */
	@Override
	public boolean updateJobTrriger(Map<String, Object> condition,String name,String group) {
		Scheduler scheduler = this.getScheduler();
		//获取trigger
		try {
			TriggerKey triggerKey = getObjectKey(group, name, scheduler, true);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			//cron 触发器
			if(condition.get("cronExpression")!=null){
				((CronTriggerImpl)trigger).setCronExpression((String) condition.get("cronExpression"));
			}
			//simple 触发器
			else{
				if(condition.get("repeatInterval")!=null){
					((SimpleTriggerImpl)trigger).setRepeatInterval(Long.parseLong(condition.get("repeatInterval")+"") );
				}
				if(condition.get("repeatCount")!=null){
					((SimpleTriggerImpl)trigger).setRepeatCount((int) condition.get("repeatCount"));
				}
			}
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	/**
	 * 获取任务容器
	 * @return
	 */
	private Scheduler getScheduler(){
		SchedulerFactoryBean scheduler = context.getBean(SchedulerFactoryBean.class);
		return scheduler.getObject();
	}

	@Override
	public boolean removeAllJob() {
		//org.quartz.plugins.xml.XMLSchedulingDataProcessorPlugin
		boolean result = false;
		Scheduler scheduler = this.getScheduler();
		try {
			List<String> groups = scheduler.getJobGroupNames();
			for(String group:groups){
				Set<JobKey>  jobkeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group));
				Set<TriggerKey> triggers = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(group));
				for(JobKey job:jobkeys){
					scheduler.deleteJob(job);
				}
				for(TriggerKey trigger:triggers){
					scheduler.unscheduleJob(trigger);
				}
			}
			result = true;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	/**
	 * 获取TriggerKey 或 JobKey
	 * @return
	 * @throws Exception 
	 */
	private <T> T getObjectKey(String group,String name,Scheduler scheduler,boolean isTriggerKey) throws Exception{
		if(isTriggerKey){
			Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(group));
			for(TriggerKey triggerKey:triggerKeys){
				if(StringUtils.endsWithIgnoreCase(name, triggerKey.getName())){
					//scheduler.resumeTrigger(triggerKey);
					return (T) triggerKey;
				}
			}
		}
		else{
			Set<JobKey>  jobkeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group));
			for(JobKey jobKey:jobkeys){
				if(StringUtils.endsWithIgnoreCase(name, jobKey.getName())){
					//scheduler.resumeJob(jobKey);
					return (T) jobKey;
				}
			}
		}
		return null;
	}

	@Override
	public boolean interruptGroup(String group) {
		Scheduler scheduler = this.getScheduler();
		try {
			scheduler.pauseJobs(GroupMatcher.jobGroupEquals(group));
			scheduler.pauseTriggers(GroupMatcher.triggerGroupEquals(group));
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
