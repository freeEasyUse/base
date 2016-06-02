package org.base.timer.quartz;

import java.util.Map;

public class JobDescription {

	// jobDetail配置
	private Map<String, Object> detailInfo;

	// simple触发器
	private Map<String, Object> simpleTrigger;

	// cron触发器
	private Map<String, Object> cronTrigger;

	// 是否自定义触发器
	private boolean isCustomTrigger = false;

	public Map<String, Object> getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(Map<String, Object> detailInfo) {
		this.detailInfo = detailInfo;
	}

	public Map<String, Object> getSimpleTrigger() {
		return simpleTrigger;
	}

	public void setSimpleTrigger(Map<String, Object> simpleTrigger) {
		this.simpleTrigger = simpleTrigger;
	}

	public Map<String, Object> getCronTrigger() {
		return cronTrigger;
	}

	public void setCronTrigger(Map<String, Object> cronTrigger) {
		this.cronTrigger = cronTrigger;
	}

	public boolean isCustomTrigger() {
		return isCustomTrigger;
	}

	public void setCustomTrigger(boolean isCustomTrigger) {
		this.isCustomTrigger = isCustomTrigger;
	}
}
