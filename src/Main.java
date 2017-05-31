/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017��4��5��
 *
 */


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import running.FishRunning;
import running.Running;
import util.RobotUtil;

/**
 * @author tumingjun
 *
 */
public class Main {

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot();
		RobotUtil ru = new RobotUtil(robot);
	//	ru.pressKey(KeyEvent.VK_X);
		/*for(int i=0;i<240;i++){
			robot.delay(60000);
		}
		ru.pressKey(KeyEvent.VK_ENTER);*/
	/*	robot.delay(500);
		robot.keyRelease(KeyEvent.VK_F);*/
		Running running = new FishRunning(5000,573,415,1,2,3,4);
		running.run();
		/*robot.delay(5000);
		for(int i=0;i<20;i++){
			Point mousepoint = MouseInfo.getPointerInfo().getLocation();
			Color pixel = robot.getPixelColofr(573,415);
			System.out.print(mousepoint.x + "---");f
			System.out.print(mousepoint.y + "---");
			System.out.print(pixel.getRGB() + "---");
			System.out.print(pixel.getRed() + "---");
			System.out.print(pixel.getBlue() + "---");
			System.out.println(pixel.getGreen());
			System.out.println("------------------------------");
			robot.delay(1000);
		}*/
	} 
	

}
