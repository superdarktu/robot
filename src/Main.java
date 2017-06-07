/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017��4��5��
 *
 */


import java.awt.*;
import java.awt.event.KeyEvent;

import running.FishRunning;
import running.Running;
import ui.MainLayout;
import util.RobotUtil;

/**
 * @author tumingjun
 *
 */
public class Main {

	public static void main(String[] args) throws AWTException {

	    if(true) {
            MainLayout mainLayout = new MainLayout();
        }

        if(false) {
            Robot robot = new Robot();
            robot.delay(5000);
            for (int i = 0; i < 20; i++) {
                Point mousepoint = MouseInfo.getPointerInfo().getLocation();
                Color pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
                System.out.print(mousepoint.x + "---");
                System.out.print(mousepoint.y + "---");
                System.out.print(pixel.getRGB() + "---");
                System.out.println("------------------------------");
                robot.delay(1000);
            }
        }
	} 
	

}
