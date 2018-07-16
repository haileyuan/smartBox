package com.mqtt;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.context.ContextLoaderListener;

 

import com.Iot.IotClient;

public class SHSXClient{
	
   public void start(){	 
	String time = new Date().toString();
    IotClient.initMessage(time);
   }
 
 
public static void main(String[] args) throws MqttException {
	 SHSXClient sh = new SHSXClient();
	 sh.start();
}
}