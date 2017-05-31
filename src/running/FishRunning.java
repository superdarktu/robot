/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017年4月10日
 *
 */

package running;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import util.RobotUtil;

/**
 * @author tumingjun
 *
 */
public class FishRunning extends Running{

	private int waitTime;
	
	private int x = 573;
	private int y = 415;
	private int leftX = 1;
	private int leftY = 1;
	private int rightX = 1;
	private int rigthY = 1;


	public FishRunning(int waitTime){

		this.waitTime = waitTime;
	}
	public FishRunning(int waitTime,int x,int y,int leftX,int leftY,int rightX,int rigthY){

		this.waitTime = waitTime;
		this.x = x;
		this.y = y;
		this.leftX = leftX;
		this.leftY = leftY;
		this.rightX  =rightX;
		this.rigthY = rigthY;
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
		int lagan = 1;
		int konggan = 1;
		for(int i=1;;i++){
			
			System.out.println("第"+i+"次抛竿");
			robotUtil.pressKeyWithTime(KeyEvent.VK_F,500);
			int tempRGB = 1 ;
			for(int u =0;;u++){
				Color pixel = robot.getPixelColor(x,y);
				Color pixelLeft = robot.getPixelColor(573,415);
				Color pixelRight = robot.getPixelColor(573,415);
				System.out.println(pixel.getRGB());
				if(u>30) break;
				if(pixel.getRGB()>-10000 &&pixel.getRGB()<0){
					System.out.println("第"+lagan+"次拉竿");
					robotUtil.pressKey(KeyEvent.VK_F);
					lagan++;
					break;
				}else if(pixelLeft.getRGB()>-10000 &&pixelLeft.getRGB()<0){
					leftRight(1,2,3,4);
					System.out.println("第"+konggan+"次控杆");
					konggan++;
					break;
				}else if(pixelRight.getRGB()>-10000 &&pixelRight.getRGB()<0){
					leftRight(1,2,3,4);
					System.out.println("第"+konggan+"次控杆");
					konggan++;
					break;
				}else{
					tempRGB = pixel.getRGB();
					robot.delay(500);
				}
			}
			robot.delay(2000);
		}
	}
	void leftRight(Integer x1,Integer y1,Integer x2,Integer y2){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		RobotUtil robotUtil = new RobotUtil(robot);
		Color pixelLeft = robot.getPixelColor(x1,y1);
		Color pixelRight = robot.getPixelColor(x2,y2);
		for(;;)
		if(pixelLeft.getRGB()>-10000 &&pixelLeft.getRGB()<0){
			robotUtil.pressKey(KeyEvent.VK_A);
		}else if(pixelRight.getRGB()>-10000 &&pixelRight.getRGB()<0){
			robotUtil.pressKey(KeyEvent.VK_D);
		}else{
			break;
		}
	}
}
