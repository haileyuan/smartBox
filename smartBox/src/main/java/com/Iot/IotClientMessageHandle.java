package com.Iot;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.*;
import org.springframework.integration.handler.AbstractMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.util.Assert;

import com.ebox.device.device;

//	import youway.service.mqtt.msg.IMsgHandle;
//	import youway.service.mqtt.msg.impl.AaaMsgHandle;
//	import youway.service.mqtt.msg.impl.BbbMsgHandle;

//	import com.fuzhi.util.SpringContextUtils;

public class IotClientMessageHandle extends AbstractMessageHandler implements
		MqttCallback {
	private IMqttClient client;
	private String topic;
	private boolean messagesRetained;

	// private QualityOfService qualityOfService =
	// QualityOfService.AT_LEAST_ONCE;

	public IotClientMessageHandle(IMqttClient client, String topic) {
		setClient(client);
		setTopic(topic);
	}

	@Override
	protected void onInit() throws Exception {
		Assert.notNull(this.client, String.format(
				"you must specify a valid %s instance! ",
				MqttClient.class.getName()));
		Assert.hasText(this.topic, "you must specify a 'topic'");

	}

	public void setClient(IMqttClient client) {
		this.client = client;
	}

	public void setMessagesRetained(boolean messagesRetained) {
		this.messagesRetained = messagesRetained;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public IMqttClient getClient() {
		return client;
	}

	@Override
	protected void handleMessageInternal(Message<?> message) throws Exception {
		Object payload = message.getPayload();
		Assert.isTrue(payload instanceof byte[], String.format(
				"the payload for %s must be of type byte[]", getClass()
						.getName()));
		byte[] payloadOfBytes = (byte[]) payload;

		// client.publish(this.topic, payloadOfBytes,
		// this.qualityOfService.ordinal(), this.messagesRetained);
		// client.subscribe(MqttHeaders.TOPIC);
		//client.subscribe("a");
		//client.subscribe("b");
		MqttMessage msg =new MqttMessage(payloadOfBytes);
		System.out.println(this.topic);
		client.publish(this.topic, msg);
		client.subscribe(this.topic);
		client.setCallback(this);
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// 处理重连
		logger.debug("开始重连......");
		String time = (new Date()).toString();
		while (true) {
			try {
				client.connect();
				break;
			} catch (MqttSecurityException e) {
				e.printStackTrace();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		IotClient.initMessage("重连：" + time);

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String topic, MqttMessage msg) {
		try {
			String content = new String(msg.getPayload(), "UTF-8");
			logger.debug("主题：" + topic + "  内容：" + content);
			// IMsgHandle msgHandle = getHandle(topic);
			// msgHandle.handle(topic, content);
			 System.out.println(content);
			 logger.debug("..................消息处理完成................");
			 switch(topic){
				 case "/Iot/regedit" :				 
					 
					 device dev = Json.fromJson(content,device.class );
					 dev.allocDeviceId();// 没有deviceId 则系统分配一个 
					 
					 
					 System.out.println("Parse json is "+ dev.Device_Json().toString());
			 }
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据接收的topic，生成对应的消息处理对象
	 * 
	 * @param topic
	 * @return
	 * 
	 *         public IMsgHandle getHandle(String topic) { IMsgHandle msgHandle
	 *         = null; switch (topic) { case "/a": // msgHandle =
	 *         SpringContextUtils.getBean("AaaMsgHandle", //
	 *         AaaMsgHandle.class); break; case "/b": // msgHandle =
	 *         SpringContextUtils.getBean("BbbMsgHandle", //
	 *         BbbMsgHandle.class); break; return msgHandle; }
	 */
	
	public IMsgHandle getHandle(String topic){
		IMsgHandle msgHandle =null;
		switch(topic) {
		case "/Iot/regedit" :
			
		
		}
		
		return msgHandle;
	}
	
	
}