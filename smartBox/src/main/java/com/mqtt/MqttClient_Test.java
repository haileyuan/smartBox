package com.mqtt;   
    
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.Executors;    
import java.util.concurrent.ScheduledExecutorService;    
import java.util.concurrent.TimeUnit;    

import java.lang.String;
import java.lang.reflect.Field;
  
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;    
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;    
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;    
import org.eclipse.paho.client.mqttv3.MqttTopic;    
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONObject;

import com.ebox.device.device;
import com.ebox.ebox.Ebox;  
    
public class MqttClient_Test {    
    
    //public static final String HOST = "tcp://0.0.0.0:61613";   
    public static final String HOST = "tcp://localhost:1883";   
   // public static final String TOPIC = "webServer";    
    public static final String TOPIC = "abcd";    
    private static final String clientid = "client123";
	private static final MqttCallback MqttCallback = null;    
    private MqttClient client;    
    private byte[] payload;
    private MqttConnectOptions options;    
    private String userName = "qqq";  
    private String passWord = "qqqq";  
    
    private Ebox ebox;
    private ScheduledExecutorService scheduler;    
    
    private void start(final MessageSubscriber subscriber) {    
        try {    
            // hostΪ��������clientid������MQTT�Ŀͻ���ID��һ����Ψһ��ʶ����ʾ��MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��    
            client = new MqttClient(HOST, clientid, new MemoryPersistence());    
            // MQTT����������    
            options = new MqttConnectOptions();    
            // �����Ƿ����session,�����������Ϊfalse��ʾ�������ᱣ���ͻ��˵����Ӽ�¼����������Ϊtrue��ʾÿ�����ӵ������������µ��������    
            options.setCleanSession(true);    
            // �������ӵ��û���    
            options.setUserName(userName);    
            // �������ӵ�����    
            options.setPassword(passWord.toCharArray());    
            // ���ó�ʱʱ�� ��λΪ��    
            options.setConnectionTimeout(10);    
            // ���ûỰ����ʱ�� ��λΪ�� ��������ÿ��1.5*20���ʱ����ͻ��˷��͸���Ϣ�жϿͻ����Ƿ����ߣ������������û�������Ļ���    
            options.setKeepAliveInterval(20);    
            // ���ûص�    
            // client.setCallback(new PushCallback());  
            client.setCallback(new MqttCallback() {
				
				@Override
				public void messageArrived(String topic, MqttMessage message)
						throws Exception {
					// TODO Auto-generated method stub
					 System.out.println("������Ϣ���� ������: " + topic);    
			         System.out.println("������ϢQos ������: " + message.getQos());    
			         System.out.println("������Ϣ���� ������: " + new String(message.getPayload(),"UTF8"));  
			         subscriber.onMessage(topic, message);
				}
				
				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					// TODO Auto-generated method stub
					System.out.println("�������");
				}
				
				@Override
				public void connectionLost(Throwable cause) {
					// TODO Auto-generated method stub
					
				}
			});
            MqttTopic topic = client.getTopic(TOPIC);    
            //setWill�����������Ŀ����Ҫ֪���ͻ����Ƿ���߿��Ե��ø÷������������ն˿ڵ�֪ͨ��Ϣ      
            //options.setWill(topic, "close".getBytes(), 2, true);    
                
            client.connect(options);    
            //������Ϣ    
            int[] Qos  = {1};    
            String[] topic1 = {TOPIC};    
            client.subscribe(topic1, Qos);    
            
         //   String scontent ="I'm here" +new Date();
         //   final MqttMessage message = new MqttMessage(scontent.getBytes());
         //   message.setQos(0);
        //    client.publish("testddd",message);
            ebox = new Ebox();
            ebox.getDevice_main().setDeviceId("uad0391129332");
            
            String scontent = ebox.OpenDoor(ebox.getDevice_main()).toString();
            MqttMessage message = new MqttMessage(scontent.getBytes());
            
            message.setQos(1);
            message.setRetained(true);
            client.publish(ebox.getDevice_main().getDeviceId(), message) ;
            
          //  message.setPayload("hgel333".getBytes());
            client.publish("abcd",message);
            
          //  scontent = ebox.Open_in_light().toString();
          //  message.setPayload(scontent.getBytes());
          //  client.publish(ebox.getDevice_main().getDivice_id(), message) ;
          //  client.disconnect();
          // client.close();
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    }    
     
    public static void main(String[] args) throws MqttException {       
    	MqttClient_Test client = new MqttClient_Test();    
        client.start(new MessageSubscriber() {
			
			@Override
			public void onMessage(String topic, MqttMessage message) {
				try {
                String a = new String(message.getPayload(),"UTF8");
				System.out.println(a);
				
				JSONObject obj = new JSONObject(a);
				
				Field[] f = device.class.getDeclaredFields();
				for(Field fie : f){
		            System.out.println("Receive Field"+fie.getName());
		            System.out.println(fie.getName()+":" + obj.getString(fie.getName()));
		        }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}) ;   
    }} 
    
    