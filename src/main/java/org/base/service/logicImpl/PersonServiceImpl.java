package org.base.service.logicImpl;

import org.base.dao.entity_t.Person;
import org.base.dao_t.PersonMapper;
import org.base.service.AbastractLogicService;
import org.base.service.logic.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * <p>Title:PersonServiceImpl</p>
 * <p>description:测试接口实现</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
@Service
public class PersonServiceImpl extends AbastractLogicService<Person> implements PersonService {

	//引入dao
	@Autowired
	private PersonMapper personMapper;
	
	//设置base中对到的引用
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(personMapper);
	}
	
	
	@Override
	public int updatePersonAgeByName(String name, int age) {
		return personMapper.updatePersonAgeByName(name, age);
	}


	/**
	 * 测试事物回滚
	 * @throws Exception 
	 */
	@Override
	@Transactional(rollbackFor=Exception.class,value="mysql2")
	public boolean addTwoPerson(Person person) throws Exception {
		super.insert(person);
		throwException();
		super.insert(person);
		return true;
	}
	
	
	private void throwException() throws Exception{
		throw new Exception();
	}

}
