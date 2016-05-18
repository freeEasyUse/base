package org.base.service.logicImpl;

import org.base.mongodb.dao.PersonMongoDao;
import org.base.mongodb.entity.Person;
import org.base.service.AbastractMongoService;
import org.base.service.logic.PersonMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 
 * <p>Title:PersonMongoServiceImpl</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
@Service
public class PersonMongoServiceImpl extends AbastractMongoService<Person> implements PersonMongoService {

	@Autowired
	private PersonMongoDao personMongoDao;
	
	@Autowired
	public void setBaseMongoDao() {
		super.setBaseMongoDao(personMongoDao);
	}
	
	@SuppressWarnings("unused")
	@Override
	public int addPerson(Person person) throws Exception {
		super.insert(person);
		if(true){
			throw new Exception();
		}
		return 1;
	}

}
