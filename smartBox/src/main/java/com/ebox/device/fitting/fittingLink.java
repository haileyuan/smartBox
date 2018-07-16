package com.ebox.device.fitting;

import org.json.JSONObject;


/**
 * 
 * @author Lemon.Cao
 *
 * @version -- Ӳ����·�汾 18.06.01 -- Ӳ������汾 18.06.01-beta -- Ӧ�ð��汾 V6.001
 *  2018.06.01 <p>
 *  
 *  �������������������  
 *  1 �˰汾������������ֻ֧��  һ�������趨
 *  2 linkHeader ����Ϊ "TCP://" �� "SSL://"  ["SSL://"�趨Ҫ��֤���ڳ�ʼ��ʱ��¼��������������]
 *  3 userName��ָ�� Broker���趨���û���  
 *    
  * <table border="1">
 *<tr>
 *<th>��Ա</th>
 * *<th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *</tr>
 * <tr>
 *  <td> linkName </td><td> String </td><td> 16	</td><td>  			 ������������  </td>
 * </tr>
 * <tr>
 *  <td>serverIP	</td><td> String </td><td> 16	</td><td>	���ӵķ�����IP��ַ </td>
 * </tr>
 *	<tr>
 *  <td>port</td><td>Integer</td><td> 5	</td><td>	���ӵķ������Ķ˿ں�      </td>
 * </tr>
*	<tr>
 *  <td>userName </td><td> String </td><td> 10	</td><td>  	�û���         </td>
 *  </tr>
*	<tr>
 *  <td>passWord   </td><td> String </td><td> 10	</td><td>	�û���  </td>
 * </tr>
*   </table>
 */
public class fittingLink {
    private static final  String  linkName ="SHSX";
	private String  serverIP;
	private Integer port;
	private String  userName;
	private String  passWord;
	private String  linkHeader;    //"TCP://" �� "SSL://" 
	
	
	public  fittingLink() {
		super();
	}

	public JSONObject Fitting_Json(){
		JSONObject json = new JSONObject(this);
		return json;
	}


   /**
    * ������������
    * @return
    */
	public String getLinkName() {
		return linkName;
	}


   /**
    * ������������
    * @param linkName
    
	private void setLinkName(String linkName) {
		this.linkName = "SHSX";
	}
*/

   /**
    * ��ȡ�������������ӵ�broker��IP��ַ
    *  
    */
	public String getServerIP() {
		return serverIP;
	}


   /**
    * ���� �������������ӵ�broker��IP��ַ 
    * @param serverIP
    */
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}


   /**
    * ��ȡ�������������ӵ�broker�ϵ�IP��ַ�˿�
    * @return
    */
	public Integer getPort() {
		return port;
	}

  /**
   *  �����������������ӵ�broker�ϵ�IP��ַ�˿�     
   * @param port
   */

	public void setPort(Integer port) {
		this.port = port;
	}

   /**
    * ������������½���û���
    * @return
    */

	public String getUserName() {
		return userName;
	}


   /**
    * ��������������ĵ�½�û���
    * 
    * @param userName
    */
	public void setUserName(String userName) {
		this.userName = userName;
	}


  /**
   * �������������ĵ�½����
   * 
   */

	public String getPassWord() {
		return passWord;
	}


   /**
    * ��������������ĵ�½����
    * @param passWord
    */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
