package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * 
 * @author Lemon。Cao
 * @version -- 硬件电路版本 18.06.01 -- 硬件软件版本 18.06.01-beta -- 应用包版本 V6.001
 *  2018.06.01 <p>
 *  智能箱灯设置
 *  1 智能物联箱此版本有2个灯开关 ,一个是内部灯 (设置名称"InLight") ,一个是外部灯(设置名称"OutLight") <p>
 *  2 灯的状态有 3种 "ON","OFF","Err"  ,"Err"表示灯损坏
 
 * <table border="1">
 *<tr>
 *<th>成员</th>
 * <th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *</tr>
 * <tr>
 *  <td> lightName </td><td> String </td><td> 16	</td><td>  			灯名[inLight ,outLight]</td>
 * </tr>
 * <tr>
 *  <td>lightCommand	</td><td> String </td><td> 8	</td><td>	开关灯[ON,OFF] </td>
 * </tr>
 *	<tr>
 *  <td>lightState</td><td> String </td><td>8	</td><td>	灯状态[ ON,OFF,Err]        </td>
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
     * 构建灯类 一定要设置灯明
     * @param lightName  "InLight"  和 "OutLight"
     */
	public   fittingLight(String lightName){
		setLightName(lightName);
	}
	
	public String getLightName() {
		return lightName;
	}
	
	/**
	 * 设置灯名 
	 * @param lightName  "InLight"  和 "OutLight"
	 */
	public void setLightName(String lightName) {
		if (lightName.equals("InLight")||lightName.equals("OutLight")){
		this.lightName = lightName;
		}
		else
		{
			throw new deviceException("灯名不正确");
		}
	}
	public String getLightCommand() {
		return lightCommand;
	}
	
	/**
	 * 灯的开关指令
	 * @param Command  “ON” 开  ;  "OFF" 关
	 */
	public void setLightCommand(String Command) {
		if (Command.equals("ON")|| Command.equals("OFF")){
		lightCommand = Command;
		}
		else {
			throw new deviceException("开关指令不正确");
		}
	}
	
	/**
	 * 获取灯的状态
	 * @return  "ON" ,"OFF" ,"Err"
	 */
	public String getLightState() {
		return lightState;
	}
	
	/**
	 * 设置灯的状态
	 * @param lightState "ON" ,"OFF" ,"Err"
	 */
	public void setLightState(String lightState) {
		if (lightState.equals("ON")|| lightState.equals("OFF")||lightState.equals("Err")){
			this.lightState = lightState;
		}
		else {
			throw new deviceException("状态值不正确");
		}
	}
 
	public JSONObject Fitting_Json(){
		 
		JSONObject json = new JSONObject(this);
		return json;
	}
	
}