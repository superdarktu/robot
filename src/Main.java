/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017Äê4ÔÂ5ÈÕ
 *
 */


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import running.FishRunning;
import running.Running;

/**
 * @author tumingjun
 *
 */
public class Main {

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot();
	//	RobotUtil ru = new RobotUtil(robot);
	//	ru.pressKey(KeyEvent.VK_X);
		/*robot.delay(2000);
		robot.keyPress(KeyEvent.VK_F);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_F);*/
		Running running = new FishRunning(13000);
		running.run();
	} 
	

}
