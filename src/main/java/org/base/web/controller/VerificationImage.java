package org.base.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.base.util.webUtil.ImageUtil;
import org.base.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 创建验证码
 * @author GeL
 *
 */
@Controller
@RequestMapping("verification")
public class VerificationImage extends BaseController {

	@RequestMapping(value = "create",method = RequestMethod.GET)
	public void createVerifictionImage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//利用图片工具生成图片
		//第一个参数是生成的验证码，第二个参数是生成的图片
		Object[] objs = ImageUtil.createImage();
		BufferedImage image = (BufferedImage) objs[1];
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}
	
	
}
