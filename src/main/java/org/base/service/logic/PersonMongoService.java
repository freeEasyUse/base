package org.base.service.logic;

import org.base.mongodb.entity.Person;

/**
 * 
 * <p>Title:PersonMongoService</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public interface PersonMongoService {

	int addPerson(Person person) throws Exception;
	
}
