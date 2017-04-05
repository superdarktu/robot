/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017年4月5日
 *
 */

package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @author tumingjun
 *
 */
public class Main {

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot(); //创建一个robot对象
		robot.delay(2000);
		for(int i=0;i<10;i++){
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);
			robot.delay(2000);
		}
	}

}
