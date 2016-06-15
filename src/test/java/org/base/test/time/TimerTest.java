package org.base.test.time;

import java.util.HashMap;
import java.util.Map;

import org.base.timer.BaseTimer;
import org.base.timer.quartz.service.DealTimeJobService;
import org.base.util.common.SpringContextUtil;
import org.base.web.controller.FileController;
import org.junit.Test;
import org.quartz.DateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import base.BaseTest;

public class TimerTest extends BaseTest {

	@Autowired
	private DealTimeJobService dealTimeJobService;

	@Test
	public void start() {
		while (true) {
		}
	}

	@Test
	public void dealTimerTest() {

		dealTimeJobService.interruptGroup("jobGroup");
		dealTimeJobService.interruptJob("jobRun2", "jobGroup2");
		// dealTimeJobService.removeAllJob();
		while (true) {
		}
	}

	@Test
	public void updateJobTrrigerTestforCron() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cronExpression", "0 0 12/1 * * ? *");
		dealTimeJobService.updateJobTrriger(map, "weatherJob", "weatherJob");
	}

	@Test
	public void updateJobTrrigerTestForSimple() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("repeatCount", -1);
		map.put("repeatInterval", 200);
		dealTimeJobService.updateJobTrriger(map, "jobRun", "jobGroup");
		while (true) {

		}
	}

	@Test
	public void startJobTest() {
		dealTimeJobService.startJob("jobRun", "jobGroup");
		while (true) {

		}
	}
	
	@Test
	public void applicationTest(){
		ApplicationContext context = SpringContextUtil.getApplicationContext();
		BaseTimer baseTimer = context.getBean(BaseTimer.class);
	}
}
