package org.base.test.logic;

import org.base.dao.entity_t.Person;
import org.base.service.logic.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

/**
 * 
 * <p>Title:PersonServiceTest</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public class PersonServiceTest extends BaseTest {

	@Autowired
	private PersonService personService;
	
	@Test
	public void testUpdateAgeByName(){
		personService.updatePersonAgeByName("test", 15);
	}
	
	
	@Test
	public void addTwoPersonTest() throws Exception{
		Person p = new Person();
		p.setName("123455678");
		p.setAge(43);
		personService.addTwoPerson(p);
	}
	
}
