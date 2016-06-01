package org.base.timer.quartz;

import java.util.Map;

public class JobDescription {

	private Map<String, Object> detailInfo;
	
	private Map<String, Object> simpleTrigger;
	
	private Map<String, Object> cronTrigger;

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
}
