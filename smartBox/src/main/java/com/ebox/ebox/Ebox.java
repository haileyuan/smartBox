package com.ebox.ebox;

import org.json.JSONException;
import org.json.JSONObject;

import com.ebox.device.*;
import com.ebox.device.fitting.*;

/**
 * 
  * 智能物联箱类 <p>
 * 
 * -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
 * @author Lemon.Cao
  
 *智能物联箱 由设备 和功能件组成  [device.calss AND Fitting_class ]
 *
 *智能物联箱类里封装了生成各种指令的功能
 */
public class Ebox implements IEbox_command {

	private device device  ;
	// private Fitting_lock Fitting_lock_doorlock = new
	// Fitting_lock("doorlock");// Ver1.SH.1
	// 食行版
	private fittingClass Fitting_class; // 门锁功能

	public Ebox() {
		super();

	}

	/*
	 * public Ebox(device device, Fitting_lock fitting_lock) { this.device_main
	 * = device; this.Fitting_lock_doorlock = fitting_lock; }
	 */
	/**
	 * 组装一个智能物联箱
	 * @param device
	 * @param fittingClass
	 */
	public Ebox(device device, fittingClass fittingClass) {
		this.setDevice_main(device);
		this.setFitting_class(fittingClass);
	}
    
	
	/**
	 * 建立BOX,只取设备号
	 * @param device
	 */
	public Ebox(device device ) {
		this.setDevice_main(device);
		 
	}
    
	
	/**
	 * 获得此智能盒的设备信息
	 * @return device 
	 */
	public device getDevice() {
		return device ;
	}
    
	/**
	 * 设置此智能盒的设备信息
	 */
	public void setDevice_main(device device ) {
		this.device  = device ;
		this.Fitting_class = new fittingClass();
	}

	/**
	 * 智能盒系统注册 要获得智能盒在系统的中的ID 和 Token
	 * 建议重写
	 * @param device_main
	 */

	public void Ebox_regedit(device device_main) {
		if (device_main.getDeviceId().equals(null) && device_main.getCcid().equals(null)) {
			device_main.setDeviceId("设置uid");

		}

	}

	/**
	 * 开门锁指令 指令参数请参考 
	 */
	public JSONObject OpenDoor(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("DOORLOCK");
		Fitting_lock_doorlock.openLock();
		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;
	};

	/**
	 * 关门锁指令 指令参数请参考  
	 */

	public JSONObject CloseDoor(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("DOORLOCK");
		Fitting_lock_doorlock.closeLock();
		JSONObject dev_json = device.Device_Json();
		//JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.closeLock();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;

	}

	/**
	 * 传感器设置 ,将 传感器的所有有设定都传送
	 *  
	 * @param device
	 * @param sensor
	 * @return JSONObject
	 * @throws JSONException
	 */
	public JSONObject SensorDefiniton(device device, fittingSensor sensor) throws JSONException {

		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = sensor.Fitting_Json();
		dev_json.put("fittingSensor", fitting_json);

		System.out.println(dev_json);
		return dev_json;

	}
	
	/**
	 * 传感器查询 ,获取 传感器的值
	 * A)如果只有传感器名称，没有要设定的参数值，则视为查询
	 * @param device
	 * @param sensor
	 * @return JSONObject
	 * @throws JSONException
	 */
	public JSONObject SensorQuery(device device, String sensorName) throws JSONException {

		JSONObject dev_json = device.Device_Json();
		fittingSensor  fittingSensor  = new fittingSensor(sensorName);
		JSONObject fitting_json = fittingSensor.Fitting_Json();
		dev_json.put("fittingSensor", fitting_json);

		System.out.println(dev_json);
		return dev_json;

	}

	/**
	 * 打开内置灯
	 * 
	 * @return device   要对那个设备操作
	 * @throws JSONException
	 */
	public JSONObject Open_in_light(device device) throws JSONException {
		JSONObject dev_json = this.device.Device_Json();
		fittingLight inLight = new fittingLight("InLight");

		inLight.setLightCommand("ON");
		JSONObject fitting_json = inLight.Fitting_Json();

		dev_json.put("fittingLight", fitting_json);
		System.out.println(dev_json);
		return dev_json;
	}

	/**
	 * 关闭 内置灯
	 * 
	 * @return 要对那个设备操作的指令串
	 * @throws JSONException
	 */
	public JSONObject Close_in_light(device device) throws JSONException {
		JSONObject dev_json = device.Device_Json();

		fittingLight inLight = new fittingLight("InLight");
		inLight.setLightCommand("OFF");

		JSONObject fitting_json = inLight.Fitting_Json();
		dev_json.put("fittingLight", fitting_json);

		System.out.println(dev_json);
		return dev_json;
	}

	/**
	 * 打开外置灯
	 * 
	 * @return  要对那个设备操作的指令串
	 * @throws JSONException
	 */
	public JSONObject Open_out_light(device device) throws JSONException {
		JSONObject dev_json = this.device.Device_Json();
		fittingLight outLight = new fittingLight("OutLight");

		outLight.setLightCommand("ON");
		JSONObject fitting_json = outLight.Fitting_Json();

		dev_json.put("fittingLight", fitting_json);
		System.out.println(dev_json);
		return dev_json;
	}

	/**
	 * 关闭 外置灯
	 * 
	 * @return  要对那个设备操作的指令串
	 * @throws JSONException
	 */
	public JSONObject Close_out_light(device device) throws JSONException {
		JSONObject dev_json = device.Device_Json();

		fittingLight outLight = new fittingLight("OutLight");
		outLight.setLightCommand("OFF");

		JSONObject fitting_json = outLight.Fitting_Json();
		dev_json.put("fittingLight", fitting_json);

		System.out.println(dev_json);
		return dev_json;
	}

	/**
	 * 生成开电池锁指令   要对那个设备操作的指令串
	 */
	public JSONObject OpenBattLock(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("BATTLOCK");
		Fitting_lock_doorlock.openLock();
		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;
	};

	/**
	 * 生成关闭电池锁指令  
	 * 
	 * @return  要对那个设备操作的指令串
	 */

	public JSONObject CloseBattlock(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("BATTLOCK");
		Fitting_lock_doorlock.closeLock();
		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;

	}

	/**
	 * 生成开箱固定锁指令 
	 * 
	 * @return  要对那个设备操作的指令串
	 */
	public JSONObject OpenBoxLock(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("BOXLOCK");
		Fitting_lock_doorlock.openLock();
		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;
	};

	/**
	 * 生成关箱固定锁指令 
	 * 
	 * @return   要对那个设备操作的指令串
	 */

	public JSONObject CloseFixlock(device device) throws JSONException {
		fittingLock Fitting_lock_doorlock = new fittingLock("BOXLOCK");
		Fitting_lock_doorlock.closeLock();
		JSONObject dev_json = device.Device_Json();
		JSONObject fitting_json = Fitting_lock_doorlock.Fitting_Json();
		dev_json.put("fittingLock", fitting_json);

		System.out.println(dev_json);
		return dev_json;

	}

	/**
	 * 智能盒网络连接设置
	 * 
	 * @return 要对那个设备操作的指令串
	 * 
	 */
	public JSONObject setLink(device device, fittingLink fitting_link) throws JSONException {

		JSONObject dev_json = device.Device_Json();
		dev_json.put("fittingLink", fitting_link.Fitting_Json());

		System.out.println(dev_json);
		return dev_json;
	}
    
	/**
	 * 生成智能物联箱的墨水屏显示字符指令
	 * @param  device  设备实例 <p>
	 *         text    显示的字符 [100汉字]<p>
	 *         x       显示X起始坐标 [硬件软件版本     18.06.01-beta 不支持]<p>
	 *         y       显示Y起始坐标 [硬件软件版本     18.06.01-beta 不支持]<p>
	 */
	public JSONObject ShowText(device device, String text, Integer X, Integer Y) throws JSONException {

		fittingInkScreen fitting_link = new fittingInkScreen();

		fitting_link.setShowtype(1);
		fitting_link.setContextString(text);

		JSONObject dev_json = device.Device_Json();

		dev_json.put("fittingInkScreen", fitting_link.Fitting_Json());

		System.out.println(dev_json);
		return dev_json;

	}

	/**
	 * 生成智能物联箱的墨水屏显示二维码指令
	 * @param  device  设备实例 <p>
	 *         text    显示的字符 [100汉字]<p>
	 *         x       显示X起始坐标 [硬件软件版本     18.06.01-beta 不支持]<p>
	 *         y       显示Y起始坐标 [硬件软件版本     18.06.01-beta 不支持]<p>
	 */
	
	public JSONObject ShowQC(device device, String QC, Integer X, Integer Y) throws JSONException {
		fittingInkScreen fitting_link = new fittingInkScreen();

		fitting_link.setShowtype(2);
		fitting_link.setContextString(QC);

		JSONObject dev_json = device.Device_Json();

		dev_json.put("fittingInkScreen", fitting_link.Fitting_Json());

		System.out.println(dev_json);
		return dev_json;
	}

	
	/**
	 * 获取功能件
	 * 
	 */
	public fittingClass getFitting_class() {
		return Fitting_class;
	}

	/**
	 * 设置功能件
	 * @param fitting_class
	 */
	public void setFitting_class(fittingClass fitting_class) {
		Fitting_class = fitting_class;
	}
}