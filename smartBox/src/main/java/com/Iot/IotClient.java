package com.Iot;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.support.ConcurrentExecutorAdapter;
 
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.mqtt.MessageSubscriber;

/**
 *  �������ͻ��� 
 * -- 2018.06.01  <p>
 * -- Ӳ����·�汾    18.06.01<p>
 * -- Ӳ������汾     18.06.01-beta<p>
 * -- Ӧ�ð��汾         V6.001<p>
 * 
 * @author Lemon��Cao
 * 
 * �������ͻ��� ���ڽ�������������Ĳ���ָ��͵�ָ���������������� <p>
 * ����
 * ע���  A:���������ָ��ͬһʱ��ֻ����һ����¼���������������û��ȡ�ߴ���Ϣ������Ϣ���ᱻ����ֱ�����µ���Ϣ�����ǡ�<p>
 *     B�����ָ�����ñ�������ô�����ͻ��˿���һֱ��ȡ����Ϣ��ֱ�����²˵���Ϣ�滻<p>
 * 
 *
 */

public class IotClient {

	private static final Logger logger = getLogger(IotClient.class);

	private static AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(MqttConfiguration.class);
	private static AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(MqttConfiguration.class);
	private static AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(MqttConfiguration.class);

	private static AnnotationConfigApplicationContext context4 = new AnnotationConfigApplicationContext(MqttConfiguration.class);

	
	private static final String TOPIC_CTRL_MSG = "/ctrlMsg/";  //����� hd_ver�汾��
	private static final String TOPIC_HOST_MSG = "/hostMsg/";  //�����Ӧ������汾��

	/**
	 * �����������ʼ��Ϣͨ��
	 * @param content
	 */
	
	public static void initMessage(String content) {
		reConnect(context1); //����
		System.out.println("initMessage start");
		logger.debug("------------initMessage start---------------");
		MessageChannel messageChannel = context1.getBean("initMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
	}

	/**
	 * ���Ϳ��Ʒ�����Ϣͨ��
	 * 
	 * @param content
	 * @throws Exception
	 */
	public static void sendCtrlMsg(String content) {
		reConnect(context2); //����
		System.out.println("sendCtrlMsg");
		logger.debug("------------sendCtrlMsg ---------------");
		MessageChannel messageChannel = context2.getBean("ctrlMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
		
		 
	}
    
	
	/**
	 * 
	 * ���͸��������������ָ��
	 * @param content
	 */
	
	public static void sendCommandMsg(String content ) {
		reConnect(context4); //����
		System.out.println("sendCommandMsg");
		logger.debug("------------sendCtrlMsg ---------------");
		MessageChannel messageChannel = context4.getBean("commandMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
	}
	
	/**
	 * ����������Ϣͨ��
	 * 
	 * @param content
	 * @throws Exception
	 */
	public static void sendHostMsg(String content) {
		reConnect(context3); //����
		System.out.println("sendHostMsg");
		logger.debug("------------sendHostMsg ---------------");
		MessageChannel messageChannel = context3.getBean("hostMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
	}

	@Configuration
	@ImportResource("classpath*:/applicationContext-mqtt.xml")
	public static class MqttConfiguration {
		/**
		 * ����IotClient���� 
		 * ��ȡ�����ļ��� IP,PORT,USERNAME ,PASSWD����Ϣ
	 
		 */
		@Bean
		public IotClientFactoryBean mqttClientFactoryBean() {
			
			
		     Properties properties = new Properties();
		       // System.out.println(System.getProperty("user.dir"));
		        try {
					properties.load( this.getClass().getClassLoader().getResourceAsStream( "IotClient.properties")) ;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		      
			// return new IotClientFactoryBean("114.55.72.41"); 
			
			return new IotClientFactoryBean(  properties.getProperty("host")); 
		}
		
		@Bean
		
		/**
		 * ��ȡ�����������豸��״̬��Ϣ
		 * 
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle mqttInitMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, "/Iot/event/*");
		}
		@Bean
		
		/**
		 * ���Ͷ������������豸�Ŀ�����Ϣ <p>
		 *  ---�������������豸������������豸�ĳ�ʶ��
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle sendCtrlMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, TOPIC_CTRL_MSG);
		}
		@Bean
		
		/**
		 * ���ͷ������˵���Ϣ
		 * ---�������������豸����ͳһ����Ϣ
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle sendHostMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, TOPIC_HOST_MSG);
		}
		@Bean
		
		/**
		 * ���Ͷ������������豸������ʱ�Ŀ�����Ϣ
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle sendCommandMsg(IMqttClient client) {
	       // System.out.println("into sendCommandMsg");
			//return new IotClientMessageHandle(client,"/Iot");
			return new IotClientMessageHandle(client,"/World");
		}
		
	}
	
	/**
	 * ����
	 * @throws InterruptedException
	 */
	private static void reConnect(AnnotationConfigApplicationContext context){
		while(context==null){
			logger.debug("-----reConnect()--------");
			context = new AnnotationConfigApplicationContext(
					MqttConfiguration.class);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ConcurrentHashMap<String, MessageSubscriber> registry=new ConcurrentHashMap<String, MessageSubscriber>();
	
	
	/**
	 * �趨��Ϣ����Ľӿ� 
	 * @param topic
	 * @param subscriber
	 
	public void subsrcibe(String topic,MessageSubscriber subscriber){
		if(null!=registry.putIfAbsent(topic, subscriber)){
			throw new IllegalStateException(topic+" already mapped.");
		}
	}
	*/
	/**
	 * �յ���Ϣ 
	 * @param topic
	 * @param message
	
	void messageArrbed(String topic,MqttMessage message){
		MessageSubscriber sub=registry.get(topic);
		if(null!=sub)
			sub.onMessage(topic, message);
	}
	 */
}
