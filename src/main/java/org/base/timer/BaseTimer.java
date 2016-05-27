package org.base.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title:BaseTimer</p>
 * <p>description:spring timer</p>
 * <p>company:</p>
 * cron表达式
 * http://cron.qqe2.com/
 * @author gel
 * @date 2016年5月27日
 *
 */
@Component
public class BaseTimer {

	@Scheduled(cron = "0/5 * * * * ? ")
	public void syaHelloTime(){
		System.out.println("每一秒说一次hello");
	}
	
}
