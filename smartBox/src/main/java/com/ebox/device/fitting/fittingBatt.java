package com.ebox.device.fitting;


import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * 
 * @author Lemon��Cao
 * @version 
* -- 2018.06.01  <p>
 * -- Ӳ����·�汾    18.06.01<p>
 * -- Ӳ������汾     18.06.01-beta<p>
 * -- Ӧ�ð��汾         V6.001<p>
*
*  ��ع��ܼ�
*
*
 * <table border="1">
 *<tr>
 *<th>��Ա</th>
 *<th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *
 *</tr>
 * <tr>
 *  <td> battAlterVol </td><td> String </td><td> 16	</td><td>	�������</td>
 * </tr>
 * <tr>
 *  <td> battVolumn </td><td> Integer </td><td> 3	</td><td>	����[�ǰٷֱ�ֵ]</td>
 * </tr>
 * <tr>
 *  <td> battAlterVol </td><td> Integer </td><td> 2	</td><td>	������� [�ǰٷֱ�ֵ]</td>
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
	 * ��ȡ�������
	 * @return
	 */
	public String getBattName() {
		return battName;
	}
	
	/**
	 * 
	 * ���õ��������
	 * @param battName
	 */
	public void setBattName(String battName) {
		this.battName = battName;
	}
	
	/*
	 * ��ȡ������� [�ǰٷֱ�]
	 */
	public Integer getBattVolumn() {
		return battVolumn;
	}
	
	/**
	 * ���õ������
	 * 
	 * @param battVolumn
	 */
	public void setBattVolumn(Integer battVolumn) {
		this.battVolumn = battVolumn;
	}
	
	/**
	 * ��ȡ��ؾ���ֵ
	 * @return
	 */
	public Integer getBattAlterVol() {
		return battAlterVol;
	}
	
	/**
	 * ���õ�ؾ���ֵ
	 * @param battAlterVol
	 */
	public void setBattAlterVol(Integer battAlterVol) {
		this.battAlterVol = battAlterVol;
	}
	
}

 
