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
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存    
            client = new MqttClient(HOST, clientid, new MemoryPersistence());    
            // MQTT的连接设置    
            options = new MqttConnectOptions();    
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接    
            options.setCleanSession(true);    
            // 设置连接的用户名    
            options.setUserName(userName);    
            // 设置连接的密码    
            options.setPassword(passWord.toCharArray());    
            // 设置超时时间 单位为秒    
            options.setConnectionTimeout(10);    
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制    
            options.setKeepAliveInterval(20);    
            // 设置回调    
            // client.setCallback(new PushCallback());  
            client.setCallback(new MqttCallback() {
				
				@Override
				public void messageArrived(String topic, MqttMessage message)
						throws Exception {
					// TODO Auto-generated method stub
					 System.out.println("接收消息主题 是是是: " + topic);    
			         System.out.println("接收消息Qos 是是是: " + message.getQos());    
			         System.out.println("接收消息内容 是是是: " + new String(message.getPayload(),"UTF8"));  
			         subscriber.onMessage(topic, message);
				}
				
				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					// TODO Auto-generated method stub
					System.out.println("发送完毕");
				}
				
				@Override
				public void connectionLost(Throwable cause) {
					// TODO Auto-generated method stub
					
				}
			});
            MqttTopic topic = client.getTopic(TOPIC);    
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息      
            //options.setWill(topic, "close".getBytes(), 2, true);    
                
            client.connect(options);    
            //订阅消息    
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
    
    