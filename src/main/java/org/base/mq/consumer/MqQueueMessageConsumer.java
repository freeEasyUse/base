package org.base.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
 * 
 * <p>
 * Title:MqMessageConsumer
 * </p>
 * <p>
 * description:消息消费者 最原始的消息监听器 用来监听处理队列里面的消息
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年5月19日
 * 
 */
@Service(value = "queueMessageConsumer")
public class MqQueueMessageConsumer implements MessageListener {

	@Override
	public void onMessage(Message message){
		System.out.println("这是消费者");
		TextMessage textMessage = (TextMessage)message;
		try {
			System.out.println("刚刚消费的消息为" + textMessage.getText());
			/* if (1 == 1) {  
                 throw new RuntimeException("Error");  
             } */
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
