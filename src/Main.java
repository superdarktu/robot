/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017Äê4ÔÂ5ÈÕ
 *
 */


import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

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
