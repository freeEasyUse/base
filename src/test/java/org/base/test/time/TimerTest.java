package org.base.test.time;

import org.base.timer.quartz.service.DealTimeJobService;
import org.junit.Test;
import org.quartz.DateBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;


public class TimerTest extends BaseTest {

	@Autowired
	private DealTimeJobService dealTimeJobService;
	
	@Test
	public void start(){
		while(true){
		}
	}
	
	@Test
	public void dealTimerTest(){
		
		dealTimeJobService.interruptGroup("jobGroup");
		dealTimeJobService.interruptJob("jobRun2","jobGroup2");
		//dealTimeJobService.removeAllJob();
		while(true){
		}
	}
	
}
