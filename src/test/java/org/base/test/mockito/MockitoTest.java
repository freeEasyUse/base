package org.base.test.mockito;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import base.BaseTest;

/**
 * mockito 测试使用
 * @author GeL
 *
 */
public class MockitoTest extends BaseTest {

	 @Test  
	    public void simpleTest(){  
	          
	        //创建mock对象，参数可以是类，也可以是接口  
	        List<String> list = Mockito.mock(List.class);  
	          
	        //设置方法的预期返回值  
	        Mockito.when(list.get(0)).thenReturn("helloworld");  
	      
	        String result = list.get(0);  
	          
	        //验证方法调用(是否调用了get(0))  
	        Mockito.verify(list).get(0);  
	          
	        //junit测试  
	        Assert.assertEquals("helloworld", result);  
	    }  
	
}
