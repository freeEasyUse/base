package org.base.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title:MqTopicMessageConsumer</p>
 * <p>description:主题消费者</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月25日
 *
 */
@Service("topicConsumer")
public class MqTopicMessageConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("收到主题");
		try {
			System.out.println(((TextMessage)message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
