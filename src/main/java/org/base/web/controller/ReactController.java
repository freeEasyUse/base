package org.base.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.base.web.BaseController;
import org.base.web.vo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>Title:ReactController</p>
 * <p>description:提供react数据源</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月17日
 *
 */
@Controller
@RequestMapping("/react")
public class ReactController extends BaseController {


	private static List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();
	
	static{
		Map<String, Object> comment1 = new HashMap<String, Object>();
		comment1.put("author", "Pete Hunt");
		comment1.put("text", "This is one comment");
		
		Map<String, Object> comment2 = new HashMap<String, Object>();
		comment2.put("author", "Jordan Walke");
		comment2.put("text", "This is *another* comment");
		
		lists.add(comment1);
		lists.add(comment2);
	}
	
	@RequestMapping("/getData")
	public void getData(HttpServletResponse response){
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", lists);
		returnSuccess(response, result);
	}

	@RequestMapping("/addComment")
	public void addComment(HttpServletResponse response,Comment comment){
		lists.add(comment.returnMap());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", lists);
		returnSuccess(response, result);
	}
	
	
	
}
