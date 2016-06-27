package org.base.web.vo;

import java.util.HashMap;
import java.util.Map;

public class Comment extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String author;
	
	private String text;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Map<String, Object> returnMap(){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("author", this.author);
		m.put("text", this.text);
		return m;
	}
}
