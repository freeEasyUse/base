package org.base.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>Title:ZookeeperServiceImpl</p>
 * <p>description:zookeeper service实现类
 * 		实现InitializingBean接口 在注入spring容器前可以调用afterPropertiesSet方法进行设置
 * </p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
@Component
public class ZookeeperServiceImpl implements InitializingBean,ZookeeperService {

	@Value("${zookeeperUrl}")
	private String zookeeperUrl;
	
	@Value("${baseSleepTimeMs}")
	private int baseSleepTimeMs;
	
	@Value("${maxRetries}")
	private int maxRetries;

	//apache提供的的对zookeeper操作的客户端
	private CuratorFramework client;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(this.baseSleepTimeMs, this.maxRetries);
		this.client = CuratorFrameworkFactory.newClient(this.zookeeperUrl, retryPolicy);
		this.client.start();
	}

	@Override
	public String getNodeData(String path) {
		String result = null;
		try {
			if(client.checkExists().forPath(path)!=null){
				result = new String(client.getData().forPath(path));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String createNode(String path, String data) throws Exception {
		String result = null;
		//存在节点不让创建
		if(client.checkExists().forPath(path)!=null){
			throw new Exception("存在当前节点 不能创建");
		}
		else{
			if(data==null){
				//当不给data是 默认使用创建端的ip作为关联
				result = client.create().creatingParentsIfNeeded().forPath(path);
			}
			else{
				result = client.create().creatingParentsIfNeeded().forPath(path,data.getBytes());
			}
		}
		return result;
	}

	@Override
	public boolean deleteNode(String path) {
		try {
			client.delete().deletingChildrenIfNeeded().forPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateNodeData(String path, String data) {
		Stat stat = null;
		try {
			stat  = client.setData().forPath(path, data.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stat!=null?true:false;
	}

}
