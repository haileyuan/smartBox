package com.yiibai.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("x")
public class HelloController{
	 
	 private static final String HOST = "tcp://localhost:1883"; 
	 private String TOPIC;
	 private String MESSAGE;
	 private static final String clientid = "server";  
	  
	 private MqttClient client;  
	 private MqttTopic topic;  

	 private String userName = "admin";  
	 private String passWord = "password";  
	  
	 private MqttMessage message;  

	   //(value="/",method = RequestMethod.GET)
	@RequestMapping
	   public String publish0() {
		System.out.println("11111111111111");
	      return "publish";
	   }
	
   @RequestMapping(value="/publish",method = RequestMethod.GET)
   public String publish() {
      return "publish";
   }
   
   @RequestMapping(value="/redirect")
   public String doPublish(HttpServletRequest request) throws MqttException {
	  //��ȡǰ̨����������������
	  TOPIC=request.getParameter("topic");
	  MESSAGE=request.getParameter("message");
	  //new mqttClient
	  //MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��
	  client = new MqttClient(HOST, clientid, new MemoryPersistence());  
      //��activeMQ���ӵķ���
	  connect();
	  //new mqttMessage
      message = new MqttMessage();  
      //���÷�������
      message.setQos(2);  
      //�����Ƿ��ڷ������б�����Ϣ�� 
      message.setRetained(true);
      //������Ϣ������
      message.setPayload(MESSAGE.getBytes());  
      //����
      publish(topic, message); 

      System.out.println("�ѷ���");  

      return "result";
   }
   
   private void connect() {  
       // new mqttConnection ��������һЩ���ӵ�����
	   MqttConnectOptions options = new MqttConnectOptions();  
	   // �����Ƿ����session,�����������Ϊfalse��ʾ�������ᱣ���ͻ��˵����Ӽ�¼����������Ϊtrue��ʾÿ�����ӵ������������µ�������� 
	   // ������֮������Ϊfalseʱ���Կͻ��˿��Խ���������Ϣ
       options.setCleanSession(false);  
       // �������ӵ��û���������
       options.setUserName(userName);  
       options.setPassword(passWord.toCharArray());  
       // ���ó�ʱʱ��  
       options.setConnectionTimeout(10);  
       // ���ûỰ����ʱ��  
       options.setKeepAliveInterval(20);  
       try {  
    	   // ���ûص���
           client.setCallback(new PushCallback());  
           // ����
           client.connect(options);
           // ��ȡactiveMQ����ΪTOPIC��topic
           topic = client.getTopic(TOPIC);  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
   }  
 
   public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException,  MqttException {  
	   // �����ķ���
	   // new mqttDeliveryToken
       MqttDeliveryToken token = topic.publish(message);
       // ����
       token.waitForCompletion();  
       System.out.println("message is published completely! "  
               + token.isComplete());  
   }

}
