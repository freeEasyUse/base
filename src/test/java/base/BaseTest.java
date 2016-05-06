package base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p>Title:BaseTest</p>
 * <p>description:测试基础类</p>
 * <p>company:org.easyuse</p>
 * @author gel
 * @date 2016年5月6日
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class BaseTest {

	@Before
	public void beforeTest(){
		System.out.println("before");
	}
	
	
}
