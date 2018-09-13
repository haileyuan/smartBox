package com.ebox.device.fitting;


import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * 
 * @author Lemon。Cao
 * @version 
* -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
*
*  电池功能件
*
*
 * <table border="1">
 *<tr>
 *<th>成员</th>
 *<th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *
 *</tr>
 * <tr>
 *  <td> battAlterVol </td><td> String </td><td> 16	</td><td>	电池组名</td>
 * </tr>
 * <tr>
 *  <td> battVolumn </td><td> Integer </td><td> 3	</td><td>	电量[是百分比值]</td>
 * </tr>
 * <tr>
 *  <td> battAlterVol </td><td> Integer </td><td> 2	</td><td>	警告电量 [是百分比值]</td>
 * </tr>
*
 
*/

public class  fittingBatt  {
 
	
	private  String  battName;
	private  Integer battVolumn;
	private  Integer battAlterVol;
	
	public fittingBatt(String battName) {
		// TODO Auto-generated constructor stub
		this.battName = battName;
	}

	/**
	 *
	 * 获取电池名称
	 * @return
	 */
	public String getBattName() {
		return battName;
	}
	
	/**
	 * 
	 * 设置电池组名称
	 * @param battName
	 */
	public void setBattName(String battName) {
		this.battName = battName;
	}
	
	/*
	 * 获取电池容量 [是百分比]
	 */
	public Integer getBattVolumn() {
		return battVolumn;
	}
	
	/**
	 * 设置电池容量
	 * 
	 * @param battVolumn
	 */
	public void setBattVolumn(Integer battVolumn) {
		this.battVolumn = battVolumn;
	}
	
	/**
	 * 获取电池警报值
	 * @return
	 */
	public Integer getBattAlterVol() {
		return battAlterVol;
	}
	
	/**
	 * 设置电池警报值
	 * @param battAlterVol
	 */
	public void setBattAlterVol(Integer battAlterVol) {
		this.battAlterVol = battAlterVol;
	}
	
}

 
