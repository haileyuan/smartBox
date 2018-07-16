package com.ebox.ebox;

import org.json.JSONException;
import org.json.JSONObject;

import com.ebox.device.device;

public interface IEbox_command{
	
	/**
	 * 打开门锁
	 * @throws JSONException 
	 * 
	 */
	public JSONObject OpenDoor(device device) throws JSONException;


    /**
     * 关闭门锁
     * 
     */
    
	public JSONObject CloseDoor(device device) throws JSONException;

     
    /**
     * 墨水瓶显示字符串
 
     * 
     * @param device 设备号
     * @param text 是要显示的字符。
     * @param X    起始坐标X --可为空值
     * @param Y    起始坐标Y --可为空值 
     */
    public JSONObject ShowText(device device ,String text, Integer X ,Integer Y) throws JSONException;
  
    /**
     * 墨水瓶显示二维码
     */
    
   public JSONObject ShowQC(device device ,String QC,Integer X,Integer Y) throws JSONException; 

}