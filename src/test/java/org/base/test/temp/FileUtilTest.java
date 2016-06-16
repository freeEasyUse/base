package org.base.test.temp;

import org.base.util.common.FileDealUtil;

public class FileUtilTest {
	
	public static void main(String[] args) {
		FileDealUtil.getFileFromWeb("http://mirrors.hust.edu.cn/apache//commons/net/binaries/commons-net-3.5-bin.tar.gz", "E:\\logs\\test2\\","commons-net-3.5-bin.tar.gz");
	}
	
}
