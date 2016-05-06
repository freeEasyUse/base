package org.base.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.base.constant.WebConstant;
import org.base.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * <p>Title:LoginController</p>
 * <p>description:用户登录controller</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月6日
 *
 */

@Controller
@RequestMapping("/base/login")
public class LoginController extends BaseController {

	@RequestMapping(value = "/userLogin",method = { RequestMethod.POST, RequestMethod.GET })
	public void userLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//用户名或者密码为空 抛出异常
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			throw new Exception("用户名/密码为空 请检查！");
		}
		
		//登录成功
		else if(StringUtils.equals("admin", userName)&&StringUtils.equals("admin", password)){
			//设置session
			super.setValueToSession(WebConstant.USER_SESSION, userName, request);
			super.returnSuccess(response, null);
		}
		//登录失败
		else{
			throw new Exception("用户名/密码错误 请重试");
		}
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value="/exit",method={RequestMethod.GET,RequestMethod.POST})
	public void userlogout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//判断当前用户信息是否在session中存在
		Object userInfo = super.getValueFromSession(WebConstant.USER_SESSION, request);
		//用户信息不存在 无需退出
		if(userInfo==null){
			throw new Exception("没有用户信息无法退出");
		}
		//存在清空当前对应session
		else{
			super.setValueToSession(WebConstant.USER_SESSION, null, request);
			super.returnSuccess(response, null);
		}
	}
	
}
