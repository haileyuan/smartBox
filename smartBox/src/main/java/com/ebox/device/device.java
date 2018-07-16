package com.ebox.device ;

 
import org.json.JSONObject;

import com.ebox.device.fitting.*;

/**class description
 * �豸�� <p>
 * 
 * -- 2018.06.01  <p>
 * -- Ӳ����·�汾    18.06.01<p>
 * -- Ӳ������汾     18.06.01-beta<p>
 * -- Ӧ�ð��汾         V6.001<p>
 * @author Lemon.Cao
 * <p>
 * <table border="1">
 *<tr>
 *<th>��Ա</th>
 *<th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *
 *</tr>
 * <tr>
 *  <td> ccid </td><td> String </td><td> 16	</td><td>		ͨ�ſ�ID�� </td>
 * </tr>
 * <tr>
 *  <td>deviceId	</td><td>  String </td><td> 16	</td><td>	ע��������豸�� </td>
 * </tr>
 *	<tr>
 *  <td>deviceName</td><td>	  String </td><td> 16	</td><td>	�豸����          </td>
 * </tr>
*	<tr>
 *  <td>deviceType </td><td>   String </td><td> 8	</td><td>	�豸���         </td>
 *  </tr>
*	<tr>
 *  <td>hdVer        </td><td>  String </td><td> 16	</td><td>	�豸��Ӳ���汾  </td>
 * </tr>
*	<tr>
 *  <td>regeditDate   </td><td> String </td><td> 16	</td><td>	ע������         </td>
 * </tr>
*	<tr>
 *  <td>softVer< </td><td> String </td><td> 16	</td><td>     	�豸������汾        </td>
 * </tr>
 *	<tr>
 *  <td>token </td><td> String </td><td> 16	</td><td>		����                 <p>
 * </tr>
 *	<tr> </table>
 * 1,�豸��ʼ��ʱֻ��CCID,hdVer,softVer��ֵ����Ҫ��Ӧ��ϵͳ�л��Ψһ�� deviceId <p>
 * 2,token ������������������ܵ�����ģ�������ֻ���豸��ʼ��ʱ����token��ֵ,���������в��޸Ĵ�ֵ����������ͺ���<p>
 * 
 * 
 * 
 */

public  class device   {

	private String ccid;  			//CCID 			ͨ�ſ�ID��
	private String deviceId;		//Device_id		ע��������豸��
	private String deviceName;     //Device_name	�豸����
	private String deviceType;     //Device_type   �豸���
	private String hdVer;          //Hd_ver        �豸��Ӳ���汾
	private String regeditDate ;   //Regedit_date  ע������ 
	private String softVer;        //Soft_ver      ����汾 
	private String token;           //Token 		����
	
	
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