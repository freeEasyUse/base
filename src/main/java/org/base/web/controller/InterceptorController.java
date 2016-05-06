package org.base.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.base.web.BaseController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * <p>Title:InterceptorController</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月6日
 *
 */
@Component
@RequestMapping("/interceptor")
public class InterceptorController extends BaseController {

	@RequestMapping(value = "/view",method = {RequestMethod.GET,RequestMethod.GET})
	public void interceptorView(HttpServletRequest request,HttpServletResponse response,@RequestParam("value") String value){
		super.returnSuccess(response, null);
	}
	
	
	
	
	
}
