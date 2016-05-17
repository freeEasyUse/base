package org.base.dao_t;

import org.apache.ibatis.annotations.Param;
import org.base.dao.entity_t.Person;

import tk.mybatis.mapper.common.Mapper;

public interface PersonMapper extends Mapper<Person> {
	
	/**
	 * 测试自定义方法
	 * @param name
	 * @param age
	 * @return
	 */
	int updatePersonAgeByName(@Param("name")  String name, @Param("age") int age);

}