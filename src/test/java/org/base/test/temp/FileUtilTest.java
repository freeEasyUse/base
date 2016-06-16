package org.base.test.temp;

import org.base.util.common.FileDealUtil;

public class FileUtilTest {
	
	public static void main(String[] args) {
		FileDealUtil.getFileFromWeb("http://mirrors.hust.edu.cn/apache//commons/net/binaries/commons-net-3.5-bin.tar.gz", "E:\\logs\\test3\\","commons-net-3.5-bin.tar.gz");
		//FileDealUtil.getFileFromWeb("ftp://ygdy8:ygdy8@y219.dydytt.net:9125/[阳光电影www.ygdy8.com].天空之眼.BD.720p.中英双字幕.rmvb", "E:\\logs\\test3\\","[阳光电影www.ygdy8.com].天空之眼.BD.720p.中英双字幕.rmvb");
	}
	
}
