package org.base.email;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

/**
 * 
 * <p>
 * Title:EmailFactory
 * </p>
 * <p>
 * description:根据发送内容 返回Email具体实例
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年6月12日
 * 
 */
public class EmailFactory {

	/**
	 * 根据邮件内容类型 创建具体邮件
	 * 
	 * @param mailInfo
	 * @return
	 */
	public static Email createEmial(MailInfo mailInfo) {
		Email email = null;
		switch (mailInfo.getEmailType()) {
		// 简单邮件
		case SIMPLE:
			email = new SimpleEmail();
			break;
		// 附件邮件
		case ATTACHMENT:
			email = new MultiPartEmail();
			break;
		// html邮件
		case HTML:
			email = new HtmlEmail();
			break;
		// 图片邮件
		case IMAGEHTML:
			email = new ImageHtmlEmail();
			break;
		default:
			break;
		}
		return email;
	}

	/**
	 * 设置邮件内容
	 * 
	 * @param mailInfo
	 * @throws EmailException
	 * @throws MalformedURLException 
	 */
	public static Email setEmail(MailInfo mailInfo) throws EmailException, MalformedURLException {
		// 获取邮件基本配置信息
		ResourceBundle emailConfig = ResourceBundle.getBundle("config/email");
		Email email = EmailFactory.createEmial(mailInfo);
		// 设置基本信息
		email.setHostName(emailConfig.getString("host"));
		email.setSmtpPort(Integer.parseInt(emailConfig.getString("port")));
		email.setAuthenticator(new DefaultAuthenticator(emailConfig.getString("userName"), emailConfig.getString("password")));
		email.setSSLOnConnect(true);
		email.setFrom(emailConfig.getString("userName"));
		email.setSubject(mailInfo.getSubject());
		String[] sends = new String[mailInfo.getSendEmails().size()];
		mailInfo.getSendEmails().toArray(sends);
		email.addTo(sends);
		email.setMsg(mailInfo.getContent());
		// 根据邮件类型 设置对应信息
		switch (mailInfo.getEmailType()) {
		// 带附件的邮件
		case ATTACHMENT:
			((MultiPartEmail) email).attach(mailInfo.getEmailAttachment());
			break;
		case HTML:
			Map<String, Object> htmlMap = mailInfo.getHtmlMap();

			// set the html message
			((HtmlEmail) email).setHtmlMsg((String) htmlMap.get("htmlMsg"));

			// set the alternative message
			((HtmlEmail) email).setTextMsg((String) htmlMap.get("textMsg"));
			break;
		case IMAGEHTML:
			Map<String, Object> htmlMapImage = mailInfo.getHtmlMap();
			((ImageHtmlEmail) email).setHtmlMsg((String) htmlMapImage.get("htmlMsg"));
			((ImageHtmlEmail) email).setTextMsg((String) htmlMapImage.get("textMsg"));
			((ImageHtmlEmail) email).setDataSourceResolver(new DataSourceUrlResolver(new URL((String)htmlMapImage.get("url"))));
			break;

		default:
			break;
		}
		return email;
	}
}
