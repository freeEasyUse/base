package org.base.mongodb.entity;

import java.io.Serializable;

/**
 * 
 * <p>Title:Person</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月10日
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;
	
	private String id;
	
	private String work;

	public Person(){
		
	}
	
	public Person(String name, int age,String work) {
		super();
		this.name = name;
		this.age = age;
		this.work = work;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
}
