package org.base.test.zookeeper;

import org.base.zookeeper.ZookeeperService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * 
 * <p>Title:ZookeeperServiceTest</p>
 * <p>description:zookeeper test</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public class ZookeeperServiceTest extends BaseTest {
	
	@Autowired
	private ZookeeperService zookeeperService;
	
	//测试创建节点
	@Test
	public void testCreateNode() throws Exception{
		//返回的结果是 创建的节点的名字
		String result = zookeeperService.createNode("/myapp", "this is data");
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testGetNodeData(){
		String result = zookeeperService.getNodeData("/myapp");
		Assert.assertNotNull(result);
	}
	
	@Test
	public void testUpdateNodeData(){
		boolean result = zookeeperService.updateNodeData("/myapp", "new data");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testCreateNodeNodeData() throws Exception{
		String result = zookeeperService.createNode("/teseapp", null);
		Assert.assertEquals(result, "/teseapp");
	}
	
	@Test
	public void testView(){
		String data = zookeeperService.getNodeData("/teseapp");
		//重新设置值
		zookeeperService.updateNodeData("/teseapp", "objje");
		String data2 = zookeeperService.getNodeData("/teseapp");
	}
	
}
