package base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p>Title:BaseTest</p>
 * <p>description:���Ի�����</p>
 * <p>company:org.easyuse</p>
 * @author gel
 * @date 2016��5��6��
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
