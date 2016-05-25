package org.base.mq.produt;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>
 * Title:SendMessageServie
 * </p>
 * <p>
 * description:生产/发送消息
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年5月19日
 * 
 */
@Service
public class SendMessageServie {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	// 使用字符串 识别队列
	@Value("${mq.queue}")
	private String queue1;

	//使用定义的Destination
	@Autowired
	@Qualifier("queueDestination")
	private Destination queueDestination;
	
	//发送到会产生回复的消息通道
	@Value("${mq.sessionAwareQueue}")
	private String queueAwareSession;
	
	//主题
	@Autowired
	@Qualifier("topicDestination")
	private Destination topic;

	/**
	 * 发送str消息
	 * 
	 * @param content
	 */
	public void sendStrMessage(final String content) {
		// 使用字符串识别消息队列
		/*jmsTemplate.send(queue1, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(content);
			}
		});*/
		// 使用定义的Destination
		jmsTemplate.send(queueDestination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(content);
			}
		});
	}
	
	
	
	/**
	 * 发送消息到会产生回复的通道中
	 */
	public void setMessageWithResponse(final String content){
		jmsTemplate.send(queueAwareSession, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(content);
			}
		});
	}
	
	
	
	/**
	 * 发送消息到topic
	 * @param content
	 */
	public void setMessageToTopic(final String content){
		jmsTemplate.send(topic,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(content);
			}
		});
	}
}
