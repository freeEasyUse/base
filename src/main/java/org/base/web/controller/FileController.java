package org.base.web.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.base.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <p>
 * Title:FileController
 * </p>
 * <p>
 * description:文件处理controller
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年6月6日
 * 
 */
@Controller
@RequestMapping("file")
public class FileController extends BaseController {

	@RequestMapping(value = "/inputFile", method = RequestMethod.POST)
	@ResponseBody
	public void fileInput(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(file.isEmpty()){
			throw new Exception("文件为空！");
		}
		//获取文件内容
		InputStream inputStream = file.getInputStream();
		byte[] bytes = new byte[inputStream.available()];
		inputStream.read(bytes);
		String content = new String(bytes);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("content", content);
		returnSuccess(response, result);
	}

}
