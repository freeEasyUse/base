package org.base.test.email;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.EmailAttachment;
import org.base.email.EmailType;
import org.base.email.EmailUtil;
import org.base.email.MailInfo;
import org.junit.Test;

import base.BaseTest;

/**
 * 
 * <p>Title:EmailTest</p>
 * <p>description:邮件测试</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月13日
 *
 */
public class EmailTest extends BaseTest {
	
	/**
	 * 简单邮件测试
	 */
	@Test
	public void simpleTest(){
		MailInfo mailInfo = new MailInfo();
		mailInfo.setContent("this is simple email");
		mailInfo.setSendEmails(Arrays.asList("geyueliang_89@163.com"));
		mailInfo.setSubject("simple");
		mailInfo.setEmailType(EmailType.SIMPLE);
		EmailUtil.sendMail(mailInfo);
	}
	
	
	/**
	 * 带附件邮件测试
	 * @throws MalformedURLException 
	 */
	@Test
	public void attachmentTest() throws MalformedURLException{
		MailInfo mailInfo = new MailInfo();
		mailInfo.setContent("this is attachement email");
		mailInfo.setSendEmails(Arrays.asList("geyueliang_89@163.com"));
		mailInfo.setSubject("attachement");
		mailInfo.setEmailType(EmailType.ATTACHMENT);
		
		EmailAttachment attachement = new EmailAttachment();
		attachement.setDescription("attachement");
		attachement.setDisposition(EmailAttachment.ATTACHMENT);
		//attachement.setPath("C:\\Users\\GeL\\Desktop\\JavaScript权威指南(第6版)(中文版).pdf");
		attachement.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
		mailInfo.setEmailAttachment(attachement);
		EmailUtil.sendMail(mailInfo);
	}
	
	
	/**
	 * html类型的邮件测试
	 */
	@Test
	public void htmlEmailTest(){
		MailInfo mailInfo = new MailInfo();
		mailInfo.setContent("this is html email");
		mailInfo.setSendEmails(Arrays.asList("geyueliang_89@163.com"));
		mailInfo.setSubject("html");
		mailInfo.setEmailType(EmailType.HTML);
		Map<String, Object> htmlMap = new HashMap<String, Object>();
		htmlMap.put("htmlMsg", "<html>The apache logo - <a href=\"www.baidu.com\">lianjie</a></html>");
		htmlMap.put("textMsg", "html textmsg");
		mailInfo.setHtmlMap(htmlMap);
		EmailUtil.sendMail(mailInfo);
	}
}
