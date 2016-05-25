package org.base.mq.consumer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title:MqSessionAwareMessageConsumer</p>
 * <p>description:接收到消息后发送一个回复的消息</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月19日
 *
 */

@Service("mqSessionAwareMessageConsumer")
public class MqSessionAwareMessageConsumer implements SessionAwareMessageListener<Message> {

	@Autowired
	@Qualifier("receiveMessageFromConsumer")
	private Destination destination;
	
	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		//开始处理消息
		System.out.println("mqsessionAwareMessageConsumer开始处理消息");
		System.out.println("消息内容是：" + ((TextMessage) message).getText());
		//获取更加消息队列 创建生产者
		MessageProducer producer = session.createProducer(destination);
		//发送消息
		Message textMessage = session.createTextMessage("在消费者中处理完成回复的消息");
		producer.send(textMessage);
		/*if(1==1){
			try {
				throw new Exception("抛出异常测试 回滚");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

}
