package com.ebox.ebox;

import org.json.JSONException;
import org.json.JSONObject;

import com.ebox.device.device;

public interface IEbox_command{
	
	/**
	 * ������
	 * @throws JSONException 
	 * 
	 */
	public JSONObject OpenDoor(device device) throws JSONException;


    /**
     * �ر�����
     * 
     */
    
	public JSONObject CloseDoor(device device) throws JSONException;

     
    /**
     * īˮƿ��ʾ�ַ���
 
     * 
     * @param device �豸��
     * @param text ��Ҫ��ʾ���ַ���
     * @param X    ��ʼ����X --��Ϊ��ֵ
     * @param Y    ��ʼ����Y --��Ϊ��ֵ 
     */
    public JSONObject ShowText(device device ,String text, Integer X ,Integer Y) throws JSONException;
  
    /**
     * īˮƿ��ʾ��ά��
     */
    
   public JSONObject ShowQC(device device ,String QC,Integer X,Integer Y) throws JSONException; 

}