package org.base.redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RList;
import org.redisson.core.RLock;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 支持锁的redis client
 * @author GeL
 *
 */
@Component("redisClientWithLock")
public class RedisClientWithLock implements InitializingBean {

	private Redisson redisson;
	
	public void afterPropertiesSet() throws Exception {
		Config config = new Config();
		config.setConnectionPoolSize(10);  
        config.addAddress("127.0.0.1:6379"); 
		this.redisson = Redisson.create(config);
	}
	
	/**
	 * 设置list中的值
	 * @param key
	 * @param value
	 */
	public void setValue(String key,String value){
		//获取锁
		RLock rlock = redisson.getLock(key);
		rlock.lock();
		RList<String> list = redisson.getList(key);
		System.out.println(list.size());
		list.add(value);
		//释放锁
		rlock.unlock();
	}
	
	/**
	 * 获取list集合
	 * @param key
	 * @return
	 */
	public RList<String> getList(String key){
		return redisson.getList(key);
	}
	
}
