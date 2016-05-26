package base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p>Title:BaseTest</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月10日
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml" })
public class BaseTest {

	@Before
	public void beforeTest(){
		System.out.println("junit before");
	}
	
	
}
