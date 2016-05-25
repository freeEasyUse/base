package org.base.test.mq;

import org.base.mq.produt.SendMessageServie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;

public class SendMessageServiceTest extends BaseTest {

	@Autowired
	private SendMessageServie sendMessageServie;

	@Test
	public void setStrMessageTest() throws Exception {

		sendMessageServie.sendStrMessage("7654321");
	}

	
	@Test
	public void sendMessageWithResponseTest() {
		sendMessageServie.setMessageWithResponse("这个是一个带有回复消息的消息");
		while (true) {

		}
	}
	
	@Test
	public void sendMessageToTopicTest(){
		for(int i = 0;i<10;i++){
			sendMessageServie.setMessageToTopic("topic"+i);
		}
		while (true) {

		}
	}
	
	@Test
	public void start(){
		while (true) {

		}
	}
}
