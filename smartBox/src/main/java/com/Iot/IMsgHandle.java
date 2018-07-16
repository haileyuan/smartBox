package com.Iot;


/**
 * 智能物联箱反馈信息操作接口
 * @author Lemon.Cao
 *
 */
public interface IMsgHandle {
	 
	void handle(String topic,String content);
}
