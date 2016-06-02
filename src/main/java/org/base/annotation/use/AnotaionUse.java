package org.base.annotation.use;

import org.base.annotation.AnotationInFile;

public class AnotaionUse {
	
	@AnotationInFile(aliName = "aliName")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
