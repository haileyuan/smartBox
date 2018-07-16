package com.ebox.device.fitting;

import org.json.JSONObject;


/**
 * 
 * @author Lemon.Cao
 *
 * @version -- 硬件电路版本 18.06.01 -- 硬件软件版本 18.06.01-beta -- 应用包版本 V6.001
 *  2018.06.01 <p>
 *  
 *  智能物联箱的网络设置  
 *  1 此版本的智能物联箱只支持  一个网络设定
 *  2 linkHeader 设置为 "TCP://" 或 "SSL://"  ["SSL://"设定要把证书在初始化时烧录到智能物联箱中]
 *  3 userName是指的 Broker上设定的用户名  
 *    
  * <table border="1">
 *<tr>
 *<th>成员</th>
 * *<th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *</tr>
 * <tr>
 *  <td> linkName </td><td> String </td><td> 16	</td><td>  			 连接网络名称  </td>
 * </tr>
 * <tr>
 *  <td>serverIP	</td><td> String </td><td> 16	</td><td>	连接的服务器IP地址 </td>
 * </tr>
 *	<tr>
 *  <td>port</td><td>Integer</td><td> 5	</td><td>	连接的服务器的端口号      </td>
 * </tr>
*	<tr>
 *  <td>userName </td><td> String </td><td> 10	</td><td>  	用户名         </td>
 *  </tr>
*	<tr>
 *  <td>passWord   </td><td> String </td><td> 10	</td><td>	用户名  </td>
 * </tr>
*   </table>
 */
public class fittingLink {
    private static final  String  linkName ="SHSX";
	private String  serverIP;
	private Integer port;
	private String  userName;
	private String  passWord;
	private String  linkHeader;    //"TCP://" 或 "SSL://" 
	
	
	public  fittingLink() {
		super();
	}

	public JSONObject Fitting_Json(){
		JSONObject json = new JSONObject(this);
		return json;
	}


   /**
    * 连接网络名称
    * @return
    */
	public String getLinkName() {
		return linkName;
	}


   /**
    * 设置连接名称
    * @param linkName
    
	private void setLinkName(String linkName) {
		this.linkName = "SHSX";
	}
*/

   /**
    * 获取智能物联箱连接的broker的IP地址
    *  
    */
	public String getServerIP() {
		return serverIP;
	}


   /**
    * 设置 智能物联箱连接的broker的IP地址 
    * @param serverIP
    */
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}


   /**
    * 获取智能物联箱连接的broker上的IP地址端口
    * @return
    */
	public Integer getPort() {
		return port;
	}

  /**
   *  设置智能物联箱连接的broker上的IP地址端口     
   * @param port
   */

	public void setPort(Integer port) {
		this.port = port;
	}

   /**
    * 活动智能物联箱登陆的用户名
    * @return
    */

	public String getUserName() {
		return userName;
	}


   /**
    * 设置智能物联箱的登陆用户名
    * 
    * @param userName
    */
	public void setUserName(String userName) {
		this.userName = userName;
	}


  /**
   * 获得智能物联箱的登陆密码
   * 
   */

	public String getPassWord() {
		return passWord;
	}


   /**
    * 设置智能物联箱的登陆密码
    * @param passWord
    */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
