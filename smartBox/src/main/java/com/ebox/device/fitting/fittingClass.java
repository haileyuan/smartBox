package com.ebox.device.fitting;

/**class description
 * 设备类 <p>
 * 
 * -- 2018.06.01  <p>
 * -- 硬件电路版本    18.06.01<p>
 * -- 硬件软件版本     18.06.01-beta<p>
 * -- 应用包版本         V6.001<p>
 * 
 * 
 */

public class fittingClass {
	private fittingLock Fitting_door_lock;
	private fittingLock Fitting_batt_lock;
	private fittingLock Fitting_box_lock;
	private fittingLight Fitting_Inter_light;
	private fittingLight Fitting_Out_light;
    private fittingInkScreen Fitting_InkScree;
	private fittingSensor Fitting_Sensor;
    private fittingBatt   Fitting_batt;
	public   fittingClass() {
		Fitting_door_lock 	= new fittingLock("DOORLOCK");
		Fitting_batt_lock 	= new fittingLock("BATTLOCK");
		Fitting_box_lock 	= new fittingLock("BOXLOCK");
		Fitting_Inter_light = new fittingLight("InLight");
		Fitting_Out_light 	= new fittingLight("OutLight");
		Fitting_batt         =new fittingBatt("BATT01") ;
		Fitting_InkScree    = new fittingInkScreen();
	}

	public fittingClass(fittingLock fitting_door_lock,
			fittingLock fitting_batt_lock, fittingLock fitting_box_lock,
			fittingLight fitting_Inter_light, fittingLight fitting_Out_light,
			fittingBatt   Fitting_batt) {
		super();
		Fitting_door_lock 	= fitting_door_lock;
		Fitting_batt_lock 	= fitting_batt_lock;
		Fitting_box_lock  	= fitting_box_lock;
		Fitting_Inter_light = fitting_Inter_light;
		Fitting_Out_light 	= fitting_Out_light;
		Fitting_batt = Fitting_batt;
	}

	public fittingLock getFitting_door_lock() {
		return Fitting_door_lock;
	}

	public void setFitting_door_lock(fittingLock fitting_door_lock) {
		Fitting_door_lock = fitting_door_lock;
	}

	public fittingLock getFitting_batt_lock() {
		return Fitting_batt_lock;
	}

	public void setFitting_batt_lock(fittingLock fitting_batt_lock) {
		Fitting_batt_lock = fitting_batt_lock;
	}

	public fittingLock getFitting_box_lock() {
		return Fitting_box_lock;
	}

	public void setFitting_box_lock(fittingLock fitting_box_lock) {
		Fitting_box_lock = fitting_box_lock;
	}

	public fittingLight getFitting_Inter_light() {
		return Fitting_Inter_light;
	}

	public void setFitting_Inter_light(fittingLight fitting_Inter_light) {
		Fitting_Inter_light = fitting_Inter_light;
	}

	public fittingLight getFitting_Out_light() {
		return Fitting_Out_light;
	}

	public void setFitting_Out_light(fittingLight fitting_Out_light) {
		Fitting_Out_light = fitting_Out_light;
	}

	public fittingSensor getFitting_temp_sensor() {
		return Fitting_Sensor;
	}

	public void setFitting_temp_sensor(fittingSensor fitting_temp_sensor) {
		Fitting_Sensor = fitting_temp_sensor;
	}

	public fittingBatt getFitting_batt() {
		return Fitting_batt;
	}

	public void setFitting_batt(fittingBatt fitting_batt) {
		Fitting_batt = fitting_batt;
	}

	public fittingInkScreen getFitting_InkScree() {
		return Fitting_InkScree;
	}

	public void setFitting_InkScree(fittingInkScreen fitting_InkScree) {
		Fitting_InkScree = fitting_InkScree;
	}

}