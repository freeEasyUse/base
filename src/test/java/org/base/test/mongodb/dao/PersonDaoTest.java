package org.base.test.mongodb.dao;


import java.util.List;

import org.base.mongodb.dao.PersonMongoDao;
import org.base.mongodb.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

import com.mongodb.CommandResult;

/**
 * 
 * <p>Title:PersonDaoTest</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月10日
 *
 */
public class PersonDaoTest extends BaseTest {
	
	@Autowired
	private PersonMongoDao personMongoDao;
	
	/**
	 * test insert
	 */
	@Test
	public void insertTest(){
		Person p = new Person("p1",21,"work1");
		personMongoDao.insert(p);
	}
	
	
	/**
	 * test query
	 */
	@Test
	public void queryTest(){
		Person p = new Person();
		p.setName("p1");
		p.setAge(21);
		List<Person> persons = personMongoDao.queryEntity(p, "person");
		Assert.assertEquals(21, persons.get(0).getAge());
	}
	
	@Test
	public void exexJsonCommandTest(){
		CommandResult result = personMongoDao.execCommand("{name:'p1',age:21}");
		result.get("values");
	}
}
