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
 *  物联网客户端 
 * -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
 * 
 * @author Lemon。Cao
 * 
 * 物联网客户端 用于将对智能物联箱的操作指令传送到指定的智能物联箱上 <p>
 * 保留
 * 注意点  A:对物联箱的指令同一时间只保留一条记录，智能物联箱如果没有取走次信息，改信息将会被保留直到有新的信息来覆盖。<p>
 *     B：如果指令设置保留，那么其他客户端可以一直读取此消息，直到被新菜单消息替换<p>
 * 
 *
 */

public class IotClient {

	private static final Logger logger = getLogger(IotClient.class);

	private static AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(MqttConfiguration.class);
	private static AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(MqttConfiguration.class);
	private static AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(MqttConfiguration.class);

	private static AnnotationConfigApplicationContext context4 = new AnnotationConfigApplicationContext(MqttConfiguration.class);

	
	private static final String TOPIC_CTRL_MSG = "/ctrlMsg/";  //后面跟 hd_ver版本号
	private static final String TOPIC_HOST_MSG = "/hostMsg/";  //后面跟应用软件版本号

	/**
	 * 发送物流箱初始信息通道
	 * @param content
	 */
	
	public static void initMessage(String content) {
		reConnect(context1); //重连
		System.out.println("initMessage start");
		logger.debug("------------initMessage start---------------");
		MessageChannel messageChannel = context1.getBean("initMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
	}

	/**
	 * 发送控制方案信息通道
	 * 
	 * @param content
	 * @throws Exception
	 */
	public static void sendCtrlMsg(String content) {
		reConnect(context2); //重连
		System.out.println("sendCtrlMsg");
		logger.debug("------------sendCtrlMsg ---------------");
		MessageChannel messageChannel = context2.getBean("ctrlMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
		
		 
	}
    
	
	/**
	 * 
	 * 发送给智能物联网箱的指令
	 * @param content
	 */
	
	public static void sendCommandMsg(String content ) {
		reConnect(context4); //重连
		System.out.println("sendCommandMsg");
		logger.debug("------------sendCtrlMsg ---------------");
		MessageChannel messageChannel = context4.getBean("commandMsgChannel",
				MessageChannel.class);
		messageChannel.send(MessageBuilder.withPayload(content.getBytes())
				.build());
	}
	
	/**
	 * 发送主机信息通道
	 * 
	 * @param content
	 * @throws Exception
	 */
	public static void sendHostMsg(String content) {
		reConnect(context3); //重连
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
		 * 建立IotClient工场 
		 * 读取配置文件中 IP,PORT,USERNAME ,PASSWD等信息
	 
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
		 * 获取智能物联网设备的状态信息
		 * 
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle mqttInitMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, "/Iot/event/*");
		}
		@Bean
		
		/**
		 * 发送对智能物联网设备的控制信息 <p>
		 *  ---对智能物联网设备的软件升级及设备的初识话
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle sendCtrlMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, TOPIC_CTRL_MSG);
		}
		@Bean
		
		/**
		 * 发送服务器端的消息
		 * ---对智能物联网设备发送统一的信息
		 * @param client
		 * @return
		 */
		public IotClientMessageHandle sendHostMsg(IMqttClient client) {
			return new IotClientMessageHandle(client, TOPIC_HOST_MSG);
		}
		@Bean
		
		/**
		 * 发送对智能物联网设备的运行时的控制信息
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
	 * 重连
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
	 * 设定消息处理的接口 
	 * @param topic
	 * @param subscriber
	 
	public void subsrcibe(String topic,MessageSubscriber subscriber){
		if(null!=registry.putIfAbsent(topic, subscriber)){
			throw new IllegalStateException(topic+" already mapped.");
		}
	}
	*/
	/**
	 * 收到消息 
	 * @param topic
	 * @param message
	
	void messageArrbed(String topic,MqttMessage message){
		MessageSubscriber sub=registry.get(topic);
		if(null!=sub)
			sub.onMessage(topic, message);
	}
	 */
}
