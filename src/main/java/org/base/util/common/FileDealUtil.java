package org.base.util.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * <p>Title:FileDealUtil</p>
 * <p>description:文件操作</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月16日
 *
 */
public class FileDealUtil {

	private static Logger log = LoggerFactory.getLogger(FileDealUtil.class);
	
	
	public static void getFileFromWeb(String url,String localPath,String name){
		File file = new File(localPath+name);
		try {
			FileUtils.copyURLToFile(new URL(url), file,1000*60*60*24,1000*60*60*24);
		} catch (IOException e) {
			log.info("下载文件错误");
		}
	}
	
}
