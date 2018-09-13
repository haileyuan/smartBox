package com.ebox.ebox;

import org.json.JSONException;
import org.json.JSONObject;

import com.ebox.device.*;
import com.ebox.device.fitting.*;

/**
 * 
  * ������������ <p>
 * 
 * -- 2018.06.01  <p>
 * -- Ӳ����·�汾    18.06.01<p>
 * -- Ӳ������汾     18.06.01-beta<p>
 * -- Ӧ�ð��汾         V6.001<p>
 * @author Lemon.Cao
  
 *���������� ���豸 �͹��ܼ����  [device.calss AND Fitting_class ]
 *
 *���������������װ�����ɸ���ָ��Ĺ���
 */
public class Ebox implements IEbox_command {

	private device device  ;
	// private Fitting_lock Fitting_lock_doorlock = new
	// Fitting_lock("doorlock");// Ver1.SH.1
	// ʳ�а�
	private fittingClass Fitting_class; // ��������

	public Ebox() {
		super();

	}

	/*
	 * public Ebox(device device, Fitting_lock fitting_lock) { this.device_main
	 * = device; this.Fitting_lock_doorlock = fitting_lock; }
	 */
	/**
	 * ��װһ������������
	 * @param device
	 * @param fittingClass
	 */
	public Ebox(device device, fittingClass fittingClass) {
		this.setDevice_main(device);
		this.setFitting_class(fittingClass);
	}
    
	
	/**
	 * ����BOX,ֻȡ�豸��
	 * @param device
	 */
	public Ebox(device device ) {
		this.setDevice_main(device);
		 
	}
    
	
	/**
	 * ��ô����ܺе��豸��Ϣ
	 * @return device 
	 */
	public device getDevice() {
		return device ;
	}
    
	/**
	 * ���ô����ܺе��豸��Ϣ
	 */
	public void setDevice_main(device device ) {
		this.device  = device ;
		this.Fitting_class = new fittingClass();
	}

	/**
	 * ���ܺ�ϵͳע�� Ҫ������ܺ���ϵͳ���е�ID �� Token
	 * ������д
	 * @param device_main
	 */

	public void Ebox_regedit(device device_main) {
		if (device_main.getDeviceId().equals(null) && device_main.getCcid().equals(null)) {
			device_main.setDeviceId("����uid");

		}

	}

	/**
	 * ������ָ�� ָ�������ο� 
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
	 * ������ָ�� ָ�������ο�  
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
	 * ���������� ,�� ���������������趨������
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
	 * ��������ѯ ,��ȡ ��������ֵ
	 * A)���ֻ�д��������ƣ�û��Ҫ�趨�Ĳ���ֵ������Ϊ��ѯ
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
	 * �����õ�
	 * 
	 * @return device   Ҫ���Ǹ��豸����
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
	 * �ر� ���õ�
	 * 
	 * @return Ҫ���Ǹ��豸������ָ�
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
	 * �����õ�
	 * 
	 * @return  Ҫ���Ǹ��豸������ָ�
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
	 * �ر� ���õ�
	 * 
	 * @return  Ҫ���Ǹ��豸������ָ�
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
	 * ���ɿ������ָ��   Ҫ���Ǹ��豸������ָ�
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
	 * ���ɹرյ����ָ��  
	 * 
	 * @return  Ҫ���Ǹ��豸������ָ�
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
	 * ���ɿ���̶���ָ�� 
	 * 
	 * @return  Ҫ���Ǹ��豸������ָ�
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
	 * ���ɹ���̶���ָ�� 
	 * 
	 * @return   Ҫ���Ǹ��豸������ָ�
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
	 * ���ܺ�������������
	 * 
	 * @return Ҫ���Ǹ��豸������ָ�
	 * 
	 */
	public JSONObject setLink(device device, fittingLink fitting_link) throws JSONException {

		JSONObject dev_json = device.Device_Json();
		dev_json.put("fittingLink", fitting_link.Fitting_Json());

		System.out.println(dev_json);
		return dev_json;
	}
    
	/**
	 * ���������������īˮ����ʾ�ַ�ָ��
	 * @param  device  �豸ʵ�� <p>
	 *         text    ��ʾ���ַ� [100����]<p>
	 *         x       ��ʾX��ʼ���� [Ӳ������汾     18.06.01-beta ��֧��]<p>
	 *         y       ��ʾY��ʼ���� [Ӳ������汾     18.06.01-beta ��֧��]<p>
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
	 * ���������������īˮ����ʾ��ά��ָ��
	 * @param  device  �豸ʵ�� <p>
	 *         text    ��ʾ���ַ� [100����]<p>
	 *         x       ��ʾX��ʼ���� [Ӳ������汾     18.06.01-beta ��֧��]<p>
	 *         y       ��ʾY��ʼ���� [Ӳ������汾     18.06.01-beta ��֧��]<p>
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
	 * ��ȡ���ܼ�
	 * 
	 */
	public fittingClass getFitting_class() {
		return Fitting_class;
	}

	/**
	 * ���ù��ܼ�
	 * @param fitting_class
	 */
	public void setFitting_class(fittingClass fitting_class) {
		Fitting_class = fitting_class;
	}
}