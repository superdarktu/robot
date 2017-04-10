/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017��4��10��
 *
 */

package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @author tumingjun
 *
 */
public class RobotUtil {
	
	private Robot robot;
	
	public RobotUtil(Robot robot) {
		
		this.robot = robot;
	}

	//��������
	public void pressKey(int keyvalue){
		
		this.robot.keyPress(keyvalue);
		this.robot.keyRelease(keyvalue);
	}
	
	//shift+ĳ��
	public  void pressKeyWithShift(int keyvalue) {
	   
		this.robot.keyPress(KeyEvent.VK_SHIFT);
	    this.robot.keyPress(keyvalue);
	    this.robot.keyRelease(keyvalue);
	    this.robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	//alt+ĳ��
	public  void pressKeyWithAlt(int keyvalue) {
	   
		this.robot.keyPress(KeyEvent.VK_ALT);
	    this.robot.keyPress(keyvalue);
	    this.robot.keyRelease(keyvalue);
	    this.robot.keyRelease(KeyEvent.VK_ALT);
	} 
	
	//ctrl+ĳ��
	public  void pressKeyWithCtrl(int keyvalue) {
	   
		this.robot.keyPress(KeyEvent.VK_CONTROL);
	    this.robot.keyPress(keyvalue);
	    this.robot.keyRelease(keyvalue);
	    this.robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	//����
	public void pressKeyWithTime(int keyvalue, int time){
		this.robot.keyPress(keyvalue);
		this.robot.delay(time);
	    this.robot.keyRelease(keyvalue);
	}
}
