package org.base.email;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;

/**
 * 
 * <p>Title:MailInfo</p>
 * <p>description:发送邮件信息</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年6月12日
 *
 */
public class MailInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String content;	//邮件内容
	
	private List<String> sendEmails;	//发送方地址
	
	private String subject;		//主题
	
	private EmailAttachment emailAttachment;	//附件

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getSendEmails() {
		return sendEmails;
	}

	public void setSendEmails(List<String> sendEmails) {
		this.sendEmails = sendEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public EmailAttachment getEmailAttachment() {
		return emailAttachment;
	}

	public void setEmailAttachment(EmailAttachment emailAttachment) {
		this.emailAttachment = emailAttachment;
	}
	
	
	
}
