package org.base.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.base.web.BaseController;
import org.base.web.vo.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * <p>Title:PageCommentContrlller</p>
 * <p>description:分页插件</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月27日
 *
 */
@Controller
@RequestMapping("/pageInfo")
public class PageCommentContrlller extends BaseController {

	@RequestMapping(value="/getIndex",method = RequestMethod.POST)
	@ResponseBody
	public void getPageIndex(PageInfo<String> pageInfo,HttpServletResponse response){
		pageInfo.setAllCount(100);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", pageInfo);
		returnSuccess(response, result);
	}
	
}
