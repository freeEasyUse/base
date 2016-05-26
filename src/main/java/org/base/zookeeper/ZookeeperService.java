package org.base.zookeeper;

/**
 * 
 * <p>Title:ZookeeperService</p>
 * <p>description:zookeeper service</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
public interface ZookeeperService {

	//获取节点上的数据
	String getNodeData(String path);
	
	//创建节点
	String createNode(String path,String data) throws Exception;
	
	//删除节点
	boolean deleteNode(String path);
	
	//修改节点关联的内容
	boolean updateNodeData(String path,String data);
	
}
