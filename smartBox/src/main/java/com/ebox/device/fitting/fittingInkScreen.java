package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * @author Lemon.Cao
 * 
 * @version -- 硬件电路版本 18.06.01 -- 硬件软件版本 18.06.01-beta -- 应用包版本 V6.001
 *          2018.06.01
 *          <p>
 *          电子墨水屏功能模块
 *          <p>
 *          1 墨水屏可以显示 字符串 ，二维码 ，图片 2 墨水屏可以显示 的颜色有3种 ,灰度可调节16度 3
 *          2 墨水屏此硬件版是一次指令只刷新指令范围内的内容，而不是全屏刷新
 
  * <table border="1">
 *<tr>
 *<th>成员</th>
 *<th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *</tr>
 * <tr>
 *  <td> showtype </td><td> Integer </td><td> 1	</td><td>  			显示类别[1：字符串  2：二维码 ] </td>
 * </tr>
 * <tr>
 *  <td>inkScreen_y	</td><td>Integer </td><td> 3	</td><td>	显示X的起始位置[硬件软件版本 18.06.01-beta 不支持]</td>
 * </tr>
 *	<tr>
 *  <td>inkScreen_x</td><td> Integer </td><td> 3	</td><td>	显示Y的起始位置[硬件软件版本 18.06.01-beta 不支持]        </td>
 * </tr>
*	<tr>
 *  <td>contextString </td><td> String </td><td> 200</td><td>  	显示内容[二维码信息]     </td>
 *  </tr>
*	<tr>
 *  <td>color        </td><td> Integer</td><td> 1	</td><td>	0 白 1黑 2红 ,默认屏的底色为1黑色    </td>
 * </tr>
*	<tr>
 *  <td>gray  </td><td> Integer </td><td> 2	</td><td>	灰度 [0~15]         </td>
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
	 * 获取显示内容的类型
	 * 
	 * @return
	 */
	public Integer getShowtype() {
		return showtype;
	}

	/**
	 * 设置显示内容的类型
	 * 
	 * @param showtype  1 字符串   2 QC 二维码    3 图片
	 */
	public void setShowtype(Integer showtype) {
		if (showtype >= 1 && showtype <= 3)
			showtype = showtype;
		else
			throw new deviceException("内容类型不识别");
	}

	/**
	 * 获得内容显示的Y坐标
	 * 
	 * @return
	 */
	public Integer getInkScreen_y() {
		return inkScreen_y;
	}

	/**
	 * 设置内容显示的Y坐标
	 * 
	 * @param inkScreen_y
	 */
	public void setInkScreen_y(Integer inkScreen_y) {
		inkScreen_y = inkScreen_y;
	}

	/**
	 * 获取显示内容的X坐标
	 * 
	 * @return
	 */
	public Integer getInkScreen_x() {
		return inkScreen_x;
	}

	/**
	 * 设置显示内容的Y坐标
	 * 
	 * @param inkScreen_x
	 */
	public void setInkScreen_x(Integer inkScreen_x) {
		inkScreen_x = inkScreen_x;
	}

	/**
	 * 获取显示的内容
	 * 
	 * @return
	 */
	public String getContextString() {
		return contextString;
	}

	/**
	 * 设置显示的内容
	 * 
	 * @param contextString
	 */
	public void setContextString(String contextString) {
		contextString = contextString;
	}

	/**
	 * 获取内容的颜色设置
	 * 
	 * @return
	 */
	public Integer getColor() {
		return color;
	}

	/**
	 * 设置显示内容的颜色
	 * 
	 * @param color
	 *            的取值范围是 0 白 1黑 2红 ,默认屏的底色为白色
	 */
	public void setColor(Integer color) {
		if (color >= 0 && color <= 2) {
			color = color;
		} else {
			throw new deviceException("颜色设置在0~2之间");
		}

	}

	/**
	 * 获取内容显示的灰度设置
	 * 
	 * @return
	 */
	public Integer getGray() {
		return gray;
	}

	/**
	 * 设置内容显示的灰度设置
	 * 
	 * @param gray
	 */
	public void setGray(Integer gray) {
		if (gray > 0 && gray < 15) {
			gray = gray;
		} else {
			throw new deviceException("灰度设置在0~15之间");
		}
	}

	public JSONObject Fitting_Json() {
		JSONObject json = new JSONObject(this);
		return json;
	}

}