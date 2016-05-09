package org.base.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.base.constant.WebConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * <p>Title:BaseInterceptor</p>
 * <p>description:自定义基础拦截器</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月6日
 *
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res, Object handler){
		//获取session
		Object obj = req.getSession().getAttribute(WebConstant.USER_SESSION);
		if(obj==null){
			return false;
		}
		return true;
	}
}
