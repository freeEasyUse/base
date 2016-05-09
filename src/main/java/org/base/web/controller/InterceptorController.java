package org.base.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.base.web.BaseController;
import org.base.web.vo.BaseVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/view",method = {RequestMethod.POST})
	public void interceptorView(HttpServletRequest request,HttpServletResponse response,@RequestBody BaseVo vo){
		System.out.println(vo);
		super.returnSuccess(response, null);
	}
	
	
	
	
	
}
