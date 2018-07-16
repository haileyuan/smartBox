package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**class description
 * �豸�� <p>
 * 
 * -- 2018.06.01  <p>
 * -- Ӳ����·�汾    18.06.01<p>
 * -- Ӳ������汾     18.06.01-beta<p>
 * -- Ӧ�ð��汾         V6.001<p>
 * 
 * ����������Ĵ��������ܼ�
 * 1 ��Ӳ����Ĵ�����Ϊ�¶ȴ����� 
 * 
 ** <table border="1">
 *<tr>
 *<th>��Ա</th>
 * <th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *</tr>
 * <tr>
 *  <td> sensorName </td><td> String </td><td> 16	</td><td>  			���������� </td>
 * </tr>
 * <tr>
 *  <td>reportInterval	</td><td> Integer </td><td> 5	</td><td>	������ʱ�� </td>
 * </tr>
 *	<tr>
 *  <td>alterValue</td><td> double </td><td> 4.3	</td><td>		����ֵ      </td>
 * </tr>
*	<tr>
 *  <td>reportTime </td><td> Integer </td><td> 3	</td><td>  	����ʱ��         </td>
 *  </tr>
*	<tr>
 *  <td>alterAvilable     </td><td> Integer </td><td> 1	</td><td>	��������  </td>
 * </tr>

 * </tr>
 *	<tr> </table>
 */

public class fittingSensor {
	private String  sensorName;
	private Integer reportInterval;
	private String  alterValue;
	private Integer reportTime;
	private Integer alterAvilable;

	/**
	 * ��ȡ����������
	 */
	public String getSensorName() {

		return sensorName;
	}

	/**
	 * ���ô���������
	 */
	public void setSensorName(String sensor_name) {

		sensorName = sensor_name;
	}

	/**
	 * ��ȡ������������ʱ�� �� ��λ����
	 */
	public Integer getReportInterval() {

		return reportInterval;
	}

	/**
	 * ���ô�����������ʱ�� �� ��λ���� ,���ֵ 60000
	 */
	public void setReportInterval(Integer reportInterval) {

		if (reportInterval > 0 && reportInterval < 60000) {
			reportInterval = reportInterval;
		} else
			throw new deviceException("���ô�����������ʱ�� �� 0 �� 60000��Χ��");
	}

	/**
	 * ��ȡ����������ֵ
	 */
	public String getAlterValue() {

		return alterValue;
	}

	/**
	 * ���ô���������ֵ
	 */
	public void setAlterValue(String alterValue) {

		alterValue = alterValue;
	}

	/**
	 * ��ȡ�������̶�����ʱ��
	 */
	public Integer getReportTime() {

		return reportTime;
	}

	/**
	 * ���ô������̶�����ʱ�� ,��ָÿСʱ�ĵڼ�����
	 */
	public void setReportTime(Integer reportTime) {

		reportTime = reportTime;
	}

	/**
	 * �������Ƿ��ϱ�����ֵ
	 */
	public Integer getAlterAvilable() {

		return alterAvilable;
	}

	/**
	 * ���ô������Ƿ��ϱ�����ֵ
	 * 
	 * @param alterAvilable ֵΪ
	 *            0�����ϱ� 1���ϱ�
	 */

	public void setAlterAvilable(Integer alterAvilable) {

		if (alterAvilable == 0 || alterAvilable == 1) {

			alterAvilable = alterAvilable;
		} else
			throw new deviceException("���ô������Ƿ��ϱ�����ֵ����");
	}

	public JSONObject Fitting_Json(){
		if (this.getSensorName().equals(null)) {
			throw new deviceException("���������Ʋ���Ϊ��");
		}
		JSONObject json = new JSONObject(this);
		return json;
	}
	
}