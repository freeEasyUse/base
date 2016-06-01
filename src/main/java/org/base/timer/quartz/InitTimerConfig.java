package org.base.timer.quartz;

import java.util.Map;
import java.util.ResourceBundle;

import org.base.util.common.CommonUtil;
import org.base.util.common.DateUtil;
import org.quartz.Trigger;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class InitTimerConfig implements InitializingBean,ApplicationContextAware {

	
	private ApplicationContext context;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//加载定时任务设置文件
		ResourceBundle timerProperties = ResourceBundle.getBundle("config/time/jobDetail");
		Trigger[] triggers = new Trigger[timerProperties.keySet().size()];
		int i = 0;
		for(String jobName:timerProperties.keySet()){
			//将配置文件转化
			JobDescription jobDescription = JSON.parseObject(timerProperties.getString(jobName),JobDescription.class);
			JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
			//获取具体job处理类
			QuartzJobBean job = (QuartzJobBean) this.context.getBean(jobName);
			jobDetail.setJobClass(job.getClass());
			Map<String, Object> detailInfo = jobDescription.getDetailInfo();
			CommonUtil.setBeanProp(jobDetail, detailInfo);
			jobDetail.afterPropertiesSet();
			//创建simpleTrigger
			SimpleTriggerFactoryBean simpleTrigger = new SimpleTriggerFactoryBean();
			simpleTrigger.setJobDetail(jobDetail.getObject());
			Map<String, Object> simpleTrigerDes = jobDescription.getSimpleTrigger();
			//开始时间
			if(simpleTrigerDes.get("startTime")!=null){
				simpleTrigerDes.put("startTime", DateUtil.strToDate((String) simpleTrigerDes.get("startTime")));
			}
			else{
				simpleTrigerDes.put("startTime",DateUtil.getNowDateShort());
			}
			CommonUtil.setBeanProp(simpleTrigger,simpleTrigerDes);
			simpleTrigger.setName((String) detailInfo.get("name"));
			simpleTrigger.setGroup((String) detailInfo.get("group"));
			simpleTrigger.afterPropertiesSet();
			triggers[i] = simpleTrigger.getObject();
			i++;
		}
		/*
		
		
		
		//加载定时任务设置文件
		ResourceBundle bundle = ResourceBundle.getBundle("config/simpleTimeConfig");
		List<Trigger> trigger = new ArrayList<Trigger>();
        for (String jobName : bundle.keySet()) {
            try {
            	//获取job
            	QuartzJobBean job = (QuartzJobBean) this.context.getBean(jobName);
            	//创建job detail
            	JobDetailFactoryBean jobDetail = new JobDetailFactoryBean();
            	jobDetail.setJobClass(job.getClass());
            	jobDetail.setDurability(true);
            	jobDetail.setGroup("group");
            	jobDetail.setName("job");
            	jobDetail.afterPropertiesSet();
            	//创建触发器
            	SimpleTriggerFactoryBean simpleTriger = new SimpleTriggerFactoryBean();
            	simpleTriger.setJobDetail(jobDetail.getObject());
            	simpleTriger.setName("jon");
            	simpleTriger.setGroup("group");
            	//获取job触发设置
                String json = bundle.getString(jobName);
                Map<String, Object> propSet = JSON.parseObject(json,Map.class);
                CommonUtil.setBeanProp(simpleTriger, propSet);
                simpleTriger.afterPropertiesSet();
                trigger.add(simpleTriger.getObject());
            } catch (Exception e) {
              
            }
        }
        Trigger[] arr = new Trigger[trigger.size()];
        for(int i = 0;i<trigger.size();i++){
        	arr[i] = (Trigger)trigger.get(i);
        }*/
        schedulerFactoryBean.setTriggers(triggers);
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("config/time/quratz.properties"));
        schedulerFactoryBean.afterPropertiesSet();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.context = applicationContext;
	}

}
