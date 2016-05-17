package org.base.service.logic;

import org.base.dao.entity_t.Person;

/**
 * 
 * <p>Title:PersonService</p>
 * <p>description:测试接口</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public interface PersonService{

	/**
	 * 测试接口方法
	 * @param name
	 * @param age
	 * @return
	 */
	public int updatePersonAgeByName(String name,int age);
	
	
	/**
	 * 添加两个person 测试事务回滚
	 * @param person
	 * @return
	 */
	public boolean addTwoPerson(Person person) throws Exception;
	
	
}
