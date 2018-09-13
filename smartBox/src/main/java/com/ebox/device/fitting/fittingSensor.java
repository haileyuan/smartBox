package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**class description
 * 设备类 <p>
 * 
 * -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
 * 
 * 智能物联箱的传感器功能件
 * 1 此硬件版的传感器为温度传感器 
 * 
 ** <table border="1">
 *<tr>
 *<th>成员</th>
 * <th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *</tr>
 * <tr>
 *  <td> sensorName </td><td> String </td><td> 16	</td><td>  			传感器名称 </td>
 * </tr>
 * <tr>
 *  <td>reportInterval	</td><td> Integer </td><td> 5	</td><td>	报告间隔时间 </td>
 * </tr>
 *	<tr>
 *  <td>alterValue</td><td> double </td><td> 4.3	</td><td>		报警值      </td>
 * </tr>
*	<tr>
 *  <td>reportTime </td><td> Integer </td><td> 3	</td><td>  	报告时间         </td>
 *  </tr>
*	<tr>
 *  <td>alterAvilable     </td><td> Integer </td><td> 1	</td><td>	报警报告  </td>
 * </tr>

 * </tr>
 *	<tr> </table>
 */

public class fittingSensor {
	private String  sensorName;
	private Integer reportInterval;
	private Integer  alterValue;
	private Integer reportTime;
	private Integer alterAvilable;

	
	public fittingSensor(String sensorName){
		setSensorName(sensorName);
		
	}
	
	/**
	 * 获取传感器名称
	 */
	public String getSensorName() {

		return this.sensorName;
	}

	/**
	 * 设置传感器名称
	 * 
	 * [TE] 温度传感器
	 * [HR] 湿度传感器
	 */
	public void setSensorName(String sensor_name) {
        if (sensor_name.equals("TH") || sensor_name.equals("HR"))
		this.sensorName = sensor_name;
        else
        	throw new deviceException("设置传感器名称错误！"+sensor_name);
	}

	/**
	 * 获取传感器报告间隔时间 ， 单位是秒
	 */
	public Integer getReportInterval() {

		return this.reportInterval;
	}

	/**
	 * 设置传感器报告间隔时间 ， 单位是秒 ,最大值 60000
	 */
	public void setReportInterval(Integer reportInterval) {

		if (reportInterval > 0 && reportInterval < 60000) {
			this.reportInterval = reportInterval;
		} else
			throw new deviceException("设置传感器报告间隔时间 在 0 到 60000范围内");
	}

	/**
	 * 获取传感器警报值
	 */
	public Integer getAlterValue() {

		return this.alterValue;
	}

	/**
	 * 设置传感器警报值
	 */
	public void setAlterValue(Integer alterValue) {

		this.alterValue = alterValue;
	}

	/**
	 * 获取传感器固定报告时间
	 */
	public Integer getReportTime() {

		return reportTime;
	}

	/**
	 * 设置传感器固定报告时间 ,是指每小时的第几分钟
	 */
	public void setReportTime(Integer reportTime) {

		this.reportTime = reportTime;
	}

	/**
	 * 传感器是否上报警告值
	 */
	public Integer getAlterAvilable() {

		return this.alterAvilable;
	}

	/**
	 * 设置传感器是否上报警告值
	 * 
	 * @param alterAvilable 值为
	 *            0：不上报 1：上报
	 */

	public void setAlterAvilable(Integer alterAvilable) {

		if (alterAvilable == 0 || alterAvilable == 1) {

			this.alterAvilable = alterAvilable;
		} else
			throw new deviceException("设置传感器是否上报警告值错误！");
	}

	public JSONObject Fitting_Json(){
		if (this.getSensorName().equals(null)) {
			throw new deviceException("传感器名称不能为空");
		}
		JSONObject json = new JSONObject(this);
		return json;
	}
	
}