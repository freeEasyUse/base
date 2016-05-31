package org.base.timer.quartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.base.util.common.CommonUtil;
import org.quartz.Trigger;
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

//@Component
public class InitTimerConfig implements InitializingBean,ApplicationContextAware {

	
	private ApplicationContext context;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	@Override
	public void afterPropertiesSet() throws Exception {
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
        }
        schedulerFactoryBean.setTriggers(arr);
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("config/quratz.properties"));
        schedulerFactoryBean.afterPropertiesSet();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.context = applicationContext;
	}

}
