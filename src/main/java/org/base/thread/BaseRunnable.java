package org.base.thread;

/**
 * 
 * <p>Title:BaseRunnable</p>
 * <p>description:多线程</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public class BaseRunnable implements Runnable {

	private String runnableName;
	
	public BaseRunnable() {
	}
	
	public BaseRunnable(String runnableName) {
		this.runnableName = runnableName;
	}
	
	@Override
	public void run() {
		System.out.println("this is "+runnableName+"start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("this is "+runnableName+"end");
	}

	public String getRunnableName() {
		return runnableName;
	}

	public void setRunnableName(String runnableName) {
		this.runnableName = runnableName;
	}
}
