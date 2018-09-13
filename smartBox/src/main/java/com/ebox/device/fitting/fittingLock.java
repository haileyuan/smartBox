package com.ebox.device.fitting;

import org.json.JSONObject;

import com.ebox.exception.deviceException;

/**
 * 
 * @author Lemon.Cao
 *
 * @version -- Ӳ����·�汾 18.06.01 -- Ӳ������汾 18.06.01-beta -- Ӧ�ð��汾 V6.001
 *  2018.06.01 <p>
 *  
 *  �������������趨 <p>
 *  
 *  1.��Ӳ���汾���������� ��<p>
 *    DOORLOCK   ���� <p>
 *    BATTLOCK   �����<p>
 *    BOXLOCK    ������<p>
 *    
  * <table border="1">
 *<tr>
 *<th>��Ա</th>
 * *<th>��������</th>
 *<th>����</th>
 *<th>˵��</th>
 *</tr>
 * <tr>
 *  <td> lockName </td><td> String </td><td> 16	</td><td>  		���� </td>
 * </tr>
 * <tr>
 *  <td>lockCommand	</td><td> String </td><td> 8	</td><td>	������[OPEN,CLOSE] </td>
 * </tr>
 *	<tr>
 *  <td>lockStat</td><td> String </td><td> 8</td><td>		��״̬[OPEN,CLOSE] </td>
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
	 *         ������  Ver1.0 ֻ����    OPEN or CLOSE
	 * 
	 */
	public void setLockCommand(String lockCommand) {

		if (lockCommand.equals("OPEN") || lockCommand.equals("CLOSE")){
		    this.lockCommand = lockCommand;
		}
		else {
			throw new  deviceException("�������ȷ��");
		}
	}
    
	
	/**
	 * �����״̬ 
	 *  
	 */
	public String getLockStat() {
		return lockStat;
	}
    
	/**
	 * ������״̬
	 * @param lockStat
	 */
	public void setLockStat(String lockStat) {
		lockStat = lockStat;
	}

	/**
	 * ���ÿ���
	 *  
	 */
	public String openLock() {
		this.setLockCommand("OPEN");
		JSONObject json = new JSONObject(this);
		return json.toString();
	}

	/**
	 * ���ù���
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