package org.base.test.dao;

import org.base.dao.entity_t.Person;
import org.base.dao_t.PersonMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * 
 * <p>Title:PersonMapperTest</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月16日
 *
 */
public class PersonMapperTest extends BaseTest {
	
	@Autowired
	private PersonMapper personMapper;
	
	
	@Test
	public void insertTest(){
		Person p = new Person();
		p.setAge(12);
		p.setName("test");
		int i  = personMapper.insert(p);
		Assert.assertTrue(i>0);
	}
}
