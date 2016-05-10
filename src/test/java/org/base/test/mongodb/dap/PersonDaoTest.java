package org.base.test.mongodb.dap;

import org.base.mongodb.dao.PersonMongoDao;
import org.base.mongodb.entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

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
	
	
	@Test
	public void insertTest(){
		Person p = new Person("p1",21,"work1");
		personMongoDao.insert(p);
	}
	
	
}
