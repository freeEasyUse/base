package org.base.aop;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 
 * <p>Title:LogicServiceImpl</p>
 * <p>description:演示aop实现</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月26日
 *
 */
@Service
public class LogicServiceImpl implements LogicService {

	@Override
	public void sayHello() {
		System.out.println("hello world");
	}

	@Override
	public String sayHelloWithContent(String content) throws Exception {
		if(StringUtils.endsWithIgnoreCase("hello world", content)){
			throw new Exception("不要说重复的话");
		}
		content = "正在打招呼说:"+content;
		System.out.println(content);
		return content;
	}

}
