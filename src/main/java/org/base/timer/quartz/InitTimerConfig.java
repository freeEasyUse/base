package org.base.timer.quartz;

import java.util.Map;
import java.util.ResourceBundle;

import org.base.util.common.CommonUtil;
import org.base.util.common.DateUtil;
import org.quartz.Trigger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class InitTimerConfig implements InitializingBean, ApplicationContextAware {

	// spring上下文
	private ApplicationContext context;

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public void afterPropertiesSet() throws Exception {
		// 加载定时任务设置文件
		ResourceBundle timerProperties = ResourceBundle.getBundle("config/time/jobDetail");
		Trigger[] triggers = new Trigger[timerProperties.keySet().size()];
		// 采用配置文件 配置任务信息
		int i = 0;
		for (String jobName : timerProperties.keySet()) {
			// 将配置文件转化
			JobDescription jobDescription = JSON.parseObject(timerProperties.getString(jobName), JobDescription.class);
			//创建jobDetail
			JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
			// 获取具体job处理类
			QuartzJobBean job = (QuartzJobBean) this.context.getBean(jobName);
			jobDetail.setJobClass(job.getClass());
			Map<String, Object> detailInfo = jobDescription.getDetailInfo();
			CommonUtil.setBeanProp(jobDetail, detailInfo);
			jobDetail.afterPropertiesSet();
			//simpleTrigger
			if(jobDescription.getSimpleTrigger()!=null){
				// 创建simpleTrigger
				SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
				simpleTrigger.setJobDetail(jobDetail.getObject());
				Map<String, Object> simpleTrigerDes = jobDescription.getSimpleTrigger();
				// 开始时间
				if (simpleTrigerDes.get("startTime") != null) {
					simpleTrigerDes.put("startTime", DateUtil.strToDate((String) simpleTrigerDes.get("startTime")));
				} else {
					simpleTrigerDes.put("startTime", DateUtil.getNowDateShort());
				}
				CommonUtil.setBeanProp(simpleTrigger, simpleTrigerDes);
				simpleTrigger.setName((String) detailInfo.get("name"));
				simpleTrigger.setGroup((String) detailInfo.get("group"));
				simpleTrigger.afterPropertiesSet();
				triggers[i] = simpleTrigger.getObject();
				i++;
			}
			//配置cron表达式
			else{
				//创建cronTrigger
				CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
				cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
				Map<String, Object> cronDes = jobDescription.getCronTrigger();
				CommonUtil.setBeanProp(cronTriggerFactoryBean, cronDes);
				cronTriggerFactoryBean.setName((String) detailInfo.get("name"));
				cronTriggerFactoryBean.setGroup((String) detailInfo.get("group"));
				cronTriggerFactoryBean.afterPropertiesSet();
				triggers[i] = cronTriggerFactoryBean.getObject();
				i++;
			}
			
		}

		schedulerFactoryBean.setTriggers(triggers);
		schedulerFactoryBean.setConfigLocation(new ClassPathResource("config/time/quratz.properties"));
		schedulerFactoryBean.afterPropertiesSet();

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

}
