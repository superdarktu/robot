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

import model.AWTColor;
import util.RobotUtil;

/**
 * @author tumingjun
 *
 */
public class FishRunning extends Running{

	private int waitTime;
	private boolean kaiguan;
	private int paoganTime;
	private int x = 573;
	private int y = 415;
	private int leftX = 1;
	private int leftY = 1;
	private int rightX = 1;
	private int rigthY = 1;


	public FishRunning(int waitTime){

		this.waitTime = waitTime;
	}
	public FishRunning(int waitTime,int paoganTime,int x,int y,int leftX,int leftY,int rightX,int rigthY){

		this.paoganTime = paoganTime;
		this.waitTime = waitTime;
		this.x = x;
		this.y = y;
		this.leftX = leftX;
		this.leftY = leftY;
		this.rightX  =rightX;
		this.rigthY = rigthY;
		this.kaiguan = true;
		System.out.println("初始化成功");
	}

	public void stop(){
		this.kaiguan = false;
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
		int lagan = 1;
		int konggan = 1;
		for(int i=1;;i++){
			if(!this.kaiguan) return; //停止后钓完最后一条鱼终止钓鱼
			System.out.println("第"+i+"次抛竿");
			robotUtil.pressKeyWithTime(KeyEvent.VK_F,paoganTime);
			int tempRGB = 1 ;
			for(int u =0;;u++){
				Color pixel = robot.getPixelColor(x,y);
				System.out.println(pixel.getRGB());
				if(u>30) break;
				if(pixel.getRGB()> AWTColor.FISHING_COLOR_DOWN &&pixel.getRGB()<AWTColor.FISHING_COLOR_UP){
					System.out.println("第"+lagan+"次拉竿");
					robotUtil.pressKey(KeyEvent.VK_F);
					lagan++;
					robot.delay(500);
					Color pixelLeft = robot.getPixelColor(this.leftX,this.leftY);
					Color pixelRight = robot.getPixelColor(this.rightX,this.rigthY);
					if(pixelLeft.getRGB()>AWTColor.FISHING_COLOR_DOWN &&pixelLeft.getRGB()<AWTColor.FISHING_COLOR_UP){
						leftRight(this.leftX,this.leftY,this.rightX,this.rigthY);
						System.out.println("第"+konggan+"次控杆");
						konggan++;
						break;
					}else if(pixelRight.getRGB()>AWTColor.FISHING_COLOR_DOWN &&pixelRight.getRGB()<AWTColor.FISHING_COLOR_UP){
						leftRight(this.leftX,this.leftY,this.rightX,this.rigthY);
						System.out.println("第"+konggan+"次控杆");
						konggan++;
						break;
					}
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
		if(pixelLeft.getRGB()>AWTColor.FISHING_COLOR_DOWN &&pixelLeft.getRGB()<AWTColor.FISHING_COLOR_UP){
			robotUtil.pressKey(KeyEvent.VK_A);
		}else if(pixelRight.getRGB()>AWTColor.FISHING_COLOR_DOWN &&pixelRight.getRGB()<AWTColor.FISHING_COLOR_UP){
			robotUtil.pressKey(KeyEvent.VK_D);
		}else{
			break;
		}
	}
}
