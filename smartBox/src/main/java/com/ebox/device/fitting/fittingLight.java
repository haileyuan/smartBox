package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * 
 * @author Lemon��Cao
 * @version -- Ӳ����·�汾 18.06.01 -- Ӳ������汾 18.06.01-beta -- Ӧ�ð��汾 V6.001
 *  2018.06.01 <p>
 *  �����������
 *  1 ����������˰汾��2���ƿ��� ,һ�����ڲ��� (��������"InLight") ,һ�����ⲿ��(��������"OutLight") <p>
 *  2 �Ƶ�״̬�� 3�� "ON","OFF","Err"  ,"Err"��ʾ����
 
 * <table border="1">
 *<tr>
 *<th>��Ա</th>
 * <th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *</tr>
 * <tr>
 *  <td> lightName </td><td> String </td><td> 16	</td><td>  			����[inLight ,outLight]</td>
 * </tr>
 * <tr>
 *  <td>lightCommand	</td><td> String </td><td> 8	</td><td>	���ص�[ON,OFF] </td>
 * </tr>
 *	<tr>
 *  <td>lightState</td><td> String </td><td>8	</td><td>	��״̬[ ON,OFF,Err]        </td>
 * </tr>
 
 *	  </table>
  
  
 */
public class  fittingLight {
	private String  lightName ;
	private String  lightCommand;
	private String  lightState ;
	
	 
    @SuppressWarnings("unused")
	private fittingLight(){
    	 
    };
    
    /**
     * �������� һ��Ҫ���õ���
     * @param lightName  "InLight"  �� "OutLight"
     */
	public   fittingLight(String lightName){
		setLightName(lightName);
	}
	
	public String getLightName() {
		return lightName;
	}
	
	/**
	 * ���õ��� 
	 * @param lightName  "InLight"  �� "OutLight"
	 */
	public void setLightName(String lightName) {
		if (lightName.equals("InLight")||lightName.equals("OutLight")){
		this.lightName = lightName;
		}
		else
		{
			throw new deviceException("��������ȷ");
		}
	}
	public String getLightCommand() {
		return lightCommand;
	}
	
	/**
	 * �ƵĿ���ָ��
	 * @param Command  ��ON�� ��  ;  "OFF" ��
	 */
	public void setLightCommand(String Command) {
		if (Command.equals("ON")|| Command.equals("OFF")){
		lightCommand = Command;
		}
		else {
			throw new deviceException("����ָ���ȷ");
		}
	}
	
	/**
	 * ��ȡ�Ƶ�״̬
	 * @return  "ON" ,"OFF" ,"Err"
	 */
	public String getLightState() {
		return lightState;
	}
	
	/**
	 * ���õƵ�״̬
	 * @param lightState "ON" ,"OFF" ,"Err"
	 */
	public void setLightState(String lightState) {
		if (lightState.equals("ON")|| lightState.equals("OFF")||lightState.equals("Err")){
			this.lightState = lightState;
		}
		else {
			throw new deviceException("״ֵ̬����ȷ");
		}
	}
 
	public JSONObject Fitting_Json(){
		 
		JSONObject json = new JSONObject(this);
		return json;
	}
	
}