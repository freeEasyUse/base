package org.base.email;

import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * 
 * <p>
 * Title:EmailSend
 * </p>
 * <p>
 * description:邮件工具类
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年6月12日
 * 
 */
public class EmailUtil {
	/**
	 * 发送邮件工具类
	 * 
	 * @param mailInfo
	 */
	public static void sendMail(MailInfo mailInfo) {
		// 创建邮件发送
		try {
			Email email = EmailFactory.setEmail(mailInfo);
			email.send();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) throws Exception { Email email =
	 * new SimpleEmail(); email.setHostName("smtp.163.com");
	 * email.setSmtpPort(25); email.setAuthenticator(new
	 * DefaultAuthenticator("geyueliang_89@163.com", "890905"));
	 * email.setSSLOnConnect(true); email.setFrom("geyueliang_89@163.com");
	 * email.setSubject("TestMail"); email.setMsg("This is a test mail ...");
	 * email.addTo("geyueliang_89@163.com"); email.send(); }
	 */
}
