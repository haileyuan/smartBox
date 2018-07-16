package com.mqtt;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.Iot.IotClient;

public class SHmqttClient {
	public void start() {
		String time = new Date().toString();
		IotClient.sendCommandMsg("ppppppp");
	}

	public static void main(String[] args) throws MqttException {
		SHmqttClient sh = new SHmqttClient();
		sh.start();
	}
}
