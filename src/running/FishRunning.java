/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017年4月10日
 *
 */

package running;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import util.RobotUtil;

/**
 * @author tumingjun
 *
 */
public class FishRunning extends Running{

	private int waitTime;
	
	public FishRunning(int waitTime){
		
		this.waitTime = waitTime;
	}
	public void run(){
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		RobotUtil robotUtil = new RobotUtil(robot);
		robot.delay(waitTime);
		System.out.println("自动钓鱼开始，抛竿到拉杆需要等待"+waitTime+"毫秒");
		for(int i=1;;i++){
			
			System.out.println("第"+i+"次抛竿");
			robotUtil.pressKeyWithTime(KeyEvent.VK_F,500);
			robot.delay(waitTime);
			System.out.println("第"+i+"次拉竿");
			robotUtil.pressKey(KeyEvent.VK_F);
			robot.delay(10000);
		}
	}
}
