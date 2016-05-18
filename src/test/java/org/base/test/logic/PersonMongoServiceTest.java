package org.base.test.logic;

import org.base.mongodb.entity.Person;
import org.base.service.logic.PersonMongoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class PersonMongoServiceTest extends BaseTest {

	@Autowired
	private PersonMongoService personMongoService;
	
	@Test
	public void addTest() throws Exception{
		Person p = new Person("test", 28, "good job");
		personMongoService.addPerson(p);
	}
	
	
}
