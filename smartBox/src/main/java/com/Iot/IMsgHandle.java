package com.Iot;


/**
 * ���������䷴����Ϣ�����ӿ�
 * @author Lemon.Cao
 *
 */
public interface IMsgHandle {
	 
	void handle(String topic,String content);
}
