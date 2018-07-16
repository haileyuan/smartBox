package com.mqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MessageSubscriber {

	
	void onMessage(String topic, MqttMessage message);
}
