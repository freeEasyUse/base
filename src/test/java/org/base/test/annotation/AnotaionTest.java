package org.base.test.annotation;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.base.annotation.AnotationInFile;
import org.base.annotation.use.AnotaionUse;
import org.base.constant.UseContent;
import org.base.util.common.ReflectUtil;
import org.junit.Assert;
import org.junit.Test;

import base.BaseTest;

public class AnotaionTest extends BaseTest {
	
	@Test
	public void getAnotationTest(){
		AnotaionUse annotaionUse = new AnotaionUse();
		Map<String, Annotation> annotations = ReflectUtil.getAnotaionInfo(annotaionUse, UseContent.ANNOTAION_IN_FIELD, AnotationInFile.class);
		Assert.assertTrue(!annotations.isEmpty());
	}
	
	
}
