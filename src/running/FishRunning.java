/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017��4��10��
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
		System.out.println("�Զ����㿪ʼ���׸͵�������Ҫ�ȴ�"+waitTime+"����");
		for(int i=1;;i++){
			
			System.out.println("��"+i+"���׸�");
			robotUtil.pressKeyWithTime(KeyEvent.VK_F,500);
			robot.delay(waitTime);
			System.out.println("��"+i+"������");
			robotUtil.pressKey(KeyEvent.VK_F);
			robot.delay(10000);
		}
	}
}
