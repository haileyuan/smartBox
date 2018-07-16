package com.yiibai.springmvc;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;  
import org.eclipse.paho.client.mqttv3.MqttMessage; 


public class PushCallback implements MqttCallback {
	 public void connectionLost(Throwable cause) {  
	 // ���Ӷ�ʧ��һ�����������������  
		 System.out.println("���ӶϿ�������������");  
	 }  
		    
	 public void deliveryComplete(IMqttDeliveryToken token) {
		 System.out.println("deliveryComplete---------" + token.isComplete());  
	 }
	 
	 public void messageArrived(String topic, MqttMessage message) throws Exception {
	 // subscribe��õ�����Ϣ��ִ�е�������  
		 System.out.println("������Ϣ���� : " + topic);  
		 System.out.println("������ϢQos : " + message.getQos());  
		 System.out.println("������Ϣ���� : " + new String(message.getPayload()));  
	}  
}

