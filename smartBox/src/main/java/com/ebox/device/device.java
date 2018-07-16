package com.ebox.device ;

 
import org.json.JSONObject;

import com.ebox.device.fitting.*;

/**class description
 * 设备类 <p>
 * 
 * -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
 * @author Lemon.Cao
 * <p>
 * <table border="1">
 *<tr>
 *<th>成员</th>
 *<th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *
 *</tr>
 * <tr>
 *  <td> ccid </td><td> String </td><td> 16	</td><td>		通信卡ID号 </td>
 * </tr>
 * <tr>
 *  <td>deviceId	</td><td>  String </td><td> 16	</td><td>	注册后分配的设备号 </td>
 * </tr>
 *	<tr>
 *  <td>deviceName</td><td>	  String </td><td> 16	</td><td>	设备名称          </td>
 * </tr>
*	<tr>
 *  <td>deviceType </td><td>   String </td><td> 8	</td><td>	设备类别         </td>
 *  </tr>
*	<tr>
 *  <td>hdVer        </td><td>  String </td><td> 16	</td><td>	设备的硬件版本  </td>
 * </tr>
*	<tr>
 *  <td>regeditDate   </td><td> String </td><td> 16	</td><td>	注册日期         </td>
 * </tr>
*	<tr>
 *  <td>softVer< </td><td> String </td><td> 16	</td><td>     	设备的软件版本        </td>
 * </tr>
 *	<tr>
 *  <td>token </td><td> String </td><td> 16	</td><td>		令牌                 <p>
 * </tr>
 *	<tr> </table>
 * 1,设备初始化时只有CCID,hdVer,softVer有值，需要在应用系统中获得唯一的 deviceId <p>
 * 2,token 是智能箱用来检验接受的命令的，智能箱只在设备初始化时接受token的值,正常运行中不修改此值。如果不给就忽略<p>
 * 
 * 
 * 
 */

public  class device   {

	private String ccid;  			//CCID 			通信卡ID号
	private String deviceId;		//Device_id		注册后分配的设备号
	private String deviceName;     //Device_name	设备名称
	private String deviceType;     //Device_type   设备类别
	private String hdVer;          //Hd_ver        设备的硬件版本
	private String regeditDate ;   //Regedit_date  注册日期 
	private String softVer;        //Soft_ver      软件版本 
	private String token;           //Token 		令牌
	
	
	public device(){
		   super();
	}
	
	public JSONObject Device_Json(){
		JSONObject json = new JSONObject(this);
		return json;
	}




	public String getCcid() {
		return ccid;
	}




	public void setCcid(String ccid) {
		this.ccid = ccid;
	}




	public String getDeviceId() {
		return deviceId;
	}




	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}




	public String getDeviceName() {
		return deviceName;
	}




	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}




	public String getDeviceType() {
		return deviceType;
	}




	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}




	public String getHdVer() {
		return hdVer;
	}




	public void setHdVer(String hdVer) {
		this.hdVer = hdVer;
	}




	public String getRegeditDate() {
		return regeditDate;
	}




	public void setRegeditDate(String regeditDate) {
		this.regeditDate = regeditDate;
	}




	public String getSoftVer() {
		return softVer;
	}




	public void setSoftVer(String softVer) {
		this.softVer = softVer;
	}




	public String getToken() {
		return token;
	}




	public void setToken(String token) {
		this.token = token;
	}
	
	}