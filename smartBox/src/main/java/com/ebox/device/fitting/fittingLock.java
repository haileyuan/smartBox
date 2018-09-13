package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * @author Lemon.Cao
 *
 * @version -- 硬件电路版本 18.06.01 -- 硬件软件版本 18.06.01-beta -- 应用包版本 V6.001
 *  2018.06.01 <p>
 *  
 *  智能物联箱锁设定 <p>
 *  
 *  1.此硬件版本的锁有三中 ：<p>
 *    DOORLOCK   门锁 <p>
 *    BATTLOCK   电池锁<p>
 *    BOXLOCK    固箱锁<p>
 *    
  * <table border="1">
 *<tr>
 *<th>成员</th>
 * *<th>数据类型</th>
 *<th>长度</th>
 *<th>说明</th>
 *</tr>
 * <tr>
 *  <td> lockName </td><td> String </td><td> 16	</td><td>  		锁名 </td>
 * </tr>
 * <tr>
 *  <td>lockCommand	</td><td> String </td><td> 8	</td><td>	开关锁[OPEN,CLOSE] </td>
 * </tr>
 *	<tr>
 *  <td>lockStat</td><td> String </td><td> 8</td><td>		锁状态[OPEN,CLOSE] </td>
 * </tr>
* </table>   
 */

public class fittingLock {
	private String lockName;
	private String lockCommand;
	private String lockStat;

	public fittingLock(String LockName) {
		setLockName(LockName);

	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public String getLockCommand() {
		return lockCommand;
	}

	
	/**
	 * Ver1.0 setLockcomm
	 * 
	 * @param lockCommand :
	 *         锁命令  Ver1.0 只能是    OPEN or CLOSE
	 * 
	 */
	public void setLockCommand(String lockCommand) {

		if (lockCommand.equals("OPEN") || lockCommand.equals("CLOSE")){
		    this.lockCommand = lockCommand;
		}
		else {
			throw new  deviceException("锁命令不正确。");
		}
	}
    
	
	/**
	 * 获得锁状态 
	 *  
	 */
	public String getLockStat() {
		return lockStat;
	}
    
	/**
	 * 设置锁状态
	 * @param lockStat
	 */
	public void setLockStat(String lockStat) {
		lockStat = lockStat;
	}

	/**
	 * 设置开锁
	 *  
	 */
	public String openLock() {
		this.setLockCommand("OPEN");
		JSONObject json = new JSONObject(this);
		return json.toString();
	}

	/**
	 * 设置关锁
	 *  
	 */
	public JSONObject closeLock() {
		this.setLockCommand("CLOSE");
		JSONObject json = new JSONObject(this);
		//return json.toString();
		return json;
	}
	
	
	public JSONObject Fitting_Json(){
		JSONObject json = new JSONObject(this);
		return json;
	}
}