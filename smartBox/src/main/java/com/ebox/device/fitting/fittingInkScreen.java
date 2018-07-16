package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * @author Lemon.Cao
 * 
 * @version -- Ӳ����·�汾 18.06.01 -- Ӳ������汾 18.06.01-beta -- Ӧ�ð��汾 V6.001
 *          2018.06.01
 *          <p>
 *          ����īˮ������ģ��
 *          <p>
 *          1 īˮ��������ʾ �ַ��� ����ά�� ��ͼƬ 2 īˮ��������ʾ ����ɫ��3�� ,�Ҷȿɵ���16�� 3
 *          2 īˮ����Ӳ������һ��ָ��ֻˢ��ָ�Χ�ڵ����ݣ�������ȫ��ˢ��
 
  * <table border="1">
 *<tr>
 *<th>��Ա</th>
 *<th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *</tr>
 * <tr>
 *  <td> showtype </td><td> Integer </td><td> 1	</td><td>  			��ʾ���[1���ַ���  2����ά�� ] </td>
 * </tr>
 * <tr>
 *  <td>inkScreen_y	</td><td>Integer </td><td> 3	</td><td>	��ʾX����ʼλ��[Ӳ������汾 18.06.01-beta ��֧��]</td>
 * </tr>
 *	<tr>
 *  <td>inkScreen_x</td><td> Integer </td><td> 3	</td><td>	��ʾY����ʼλ��[Ӳ������汾 18.06.01-beta ��֧��]        </td>
 * </tr>
*	<tr>
 *  <td>contextString </td><td> String </td><td> 200</td><td>  	��ʾ����[��ά����Ϣ]     </td>
 *  </tr>
*	<tr>
 *  <td>color        </td><td> Integer</td><td> 1	</td><td>	0 �� 1�� 2�� ,Ĭ�����ĵ�ɫΪ1��ɫ    </td>
 * </tr>
*	<tr>
 *  <td>gray  </td><td> Integer </td><td> 2	</td><td>	�Ҷ� [0~15]         </td>
 * </tr>
*	
 *	<tr> </table>
 */
public class fittingInkScreen {
	private Integer showtype;
	private Integer inkScreen_y;
	private Integer inkScreen_x;
	private String  contextString;
	private Integer color;
	private Integer gray;

	/**
	 * ��ȡ��ʾ���ݵ�����
	 * 
	 * @return
	 */
	public Integer getShowtype() {
		return showtype;
	}

	/**
	 * ������ʾ���ݵ�����
	 * 
	 * @param showtype  1 �ַ���   2 QC ��ά��    3 ͼƬ
	 */
	public void setShowtype(Integer showtype) {
		if (showtype >= 1 && showtype <= 3)
			showtype = showtype;
		else
			throw new deviceException("�������Ͳ�ʶ��");
	}

	/**
	 * ���������ʾ��Y����
	 * 
	 * @return
	 */
	public Integer getInkScreen_y() {
		return inkScreen_y;
	}

	/**
	 * ����������ʾ��Y����
	 * 
	 * @param inkScreen_y
	 */
	public void setInkScreen_y(Integer inkScreen_y) {
		inkScreen_y = inkScreen_y;
	}

	/**
	 * ��ȡ��ʾ���ݵ�X����
	 * 
	 * @return
	 */
	public Integer getInkScreen_x() {
		return inkScreen_x;
	}

	/**
	 * ������ʾ���ݵ�Y����
	 * 
	 * @param inkScreen_x
	 */
	public void setInkScreen_x(Integer inkScreen_x) {
		inkScreen_x = inkScreen_x;
	}

	/**
	 * ��ȡ��ʾ������
	 * 
	 * @return
	 */
	public String getContextString() {
		return contextString;
	}

	/**
	 * ������ʾ������
	 * 
	 * @param contextString
	 */
	public void setContextString(String contextString) {
		contextString = contextString;
	}

	/**
	 * ��ȡ���ݵ���ɫ����
	 * 
	 * @return
	 */
	public Integer getColor() {
		return color;
	}

	/**
	 * ������ʾ���ݵ���ɫ
	 * 
	 * @param color
	 *            ��ȡֵ��Χ�� 0 �� 1�� 2�� ,Ĭ�����ĵ�ɫΪ��ɫ
	 */
	public void setColor(Integer color) {
		if (color >= 0 && color <= 2) {
			color = color;
		} else {
			throw new deviceException("��ɫ������0~2֮��");
		}

	}

	/**
	 * ��ȡ������ʾ�ĻҶ�����
	 * 
	 * @return
	 */
	public Integer getGray() {
		return gray;
	}

	/**
	 * ����������ʾ�ĻҶ�����
	 * 
	 * @param gray
	 */
	public void setGray(Integer gray) {
		if (gray > 0 && gray < 15) {
			gray = gray;
		} else {
			throw new deviceException("�Ҷ�������0~15֮��");
		}
	}

	public JSONObject Fitting_Json() {
		JSONObject json = new JSONObject(this);
		return json;
	}

}