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
import java.awt.event.InputEvent;
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
	private boolean buff = false;
	private boolean stop = false;


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

	public void useBuff(){

		this.stop = true;
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(5000);
		System.out.println("使用BUFF");
		RobotUtil robotUtil = new RobotUtil(robot);
		int i = 180;
		for(;;){
			if(!this.kaiguan) return;
			if(i==180){
				this.stop = true;
				while(this.buff){
					robot.delay(1000);
				}
				robotUtil.pressKey(KeyEvent.VK_SPACE);
				robot.delay(3000);
				i=0;
				robotUtil.pressKeyWithShift(KeyEvent.VK_4);
				robotUtil.pressKeyWithShift(KeyEvent.VK_5);
				robotUtil.pressKeyWithShift(KeyEvent.VK_6);
				robotUtil.pressKeyWithShift(KeyEvent.VK_7);
				robot.delay(1000);
				robot.mouseMove(940,460);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(100);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(100);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.delay(3000);
				this.stop = false;
			}
			i++;
			robot.delay(10000);
		}
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
			while(this.stop){
				robot.delay(1000);
			}
			System.out.println("第"+i+"次抛竿");
			robotUtil.pressKeyWithTime(KeyEvent.VK_F,paoganTime);
			this.buff = true;
			int tempRGB = 1 ;
			for(int u =0;;u++){
				Color pixel = robot.getPixelColor(x,y);
				if(u>400){ this.buff = false;break;}
				if(pixel.getRGB()> AWTColor.FISHING_COLOR_DOWN &&pixel.getRGB()<AWTColor.FISHING_COLOR_UP){
					System.out.println("第"+lagan+"次拉竿");
					robotUtil.pressKey(KeyEvent.VK_F);
					lagan++;
					for(int p=0;p<12;p++){
						robot.delay(100);
						Color pixelLeft = robot.getPixelColor(this.leftX,this.leftY);
						Color pixelRight = robot.getPixelColor(this.rightX,this.rigthY);
						Color pixelLeft2 = robot.getPixelColor(this.leftX,this.leftY-10);
						Color pixelRight2 = robot.getPixelColor(this.rightX,this.rigthY-10);
						Color pixelLeft3 = robot.getPixelColor(this.leftX,this.leftY-20);
						Color pixelRight3 = robot.getPixelColor(this.rightX,this.rigthY-20);
						if((pixelLeft.getRGB()>-300000 &&pixelLeft.getRGB()<0) ||
								(pixelLeft2.getRGB()>-300000 &&pixelLeft2.getRGB()<0) ||
								(pixelLeft3.getRGB()>-300000 &&pixelLeft3.getRGB()<0) ){
							leftRight(this.leftX,this.leftY,this.rightX,this.rigthY);
							System.out.println("第"+konggan+"次控杆");
							konggan++;
							break;
						}else if((pixelRight.getRGB()>-300000 &&pixelRight.getRGB()<0) ||
								(pixelRight2.getRGB()>-300000 &&pixelRight2.getRGB()<0) ||
								(pixelRight3.getRGB()>-300000 &&pixelRight3.getRGB()<0) ){
							leftRight(this.leftX,this.leftY,this.rightX,this.rigthY);
							System.out.println("第"+konggan+"次控杆");
							konggan++;
							break;
						}
					}
					this.buff = false;
					break;
				}else{
					tempRGB = pixel.getRGB();
					robot.delay(100);
				}
			}
			robot.delay(2000);
		}
	}
	void leftRight(Integer x1,Integer y1,Integer x2,Integer y2){
		System.out.println(123123);
		int aaa = 0;
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		RobotUtil robotUtil = new RobotUtil(robot);
		for(;;){
			Color pixelLeft = robot.getPixelColor(x1,y1);
			Color pixelRight = robot.getPixelColor(x2,y2);
			Color pixelLeft2 = robot.getPixelColor(x1,y1-10);
			Color pixelRight2 = robot.getPixelColor(x2,y2-10);
			Color pixelLeft3 = robot.getPixelColor(x1,y1-20);
			Color pixelRight3 = robot.getPixelColor(x2,y2-20);
			if((pixelLeft.getRGB()>-300000 &&pixelLeft.getRGB()<0)||
					(pixelLeft2.getRGB()>-300000 &&pixelLeft2.getRGB()<0)||
					(pixelLeft3.getRGB()>-300000 &&pixelLeft3.getRGB()<0)){
				robotUtil.pressKey(KeyEvent.VK_A);
				aaa = 0;
			}else if((pixelRight.getRGB()>-300000 &&pixelRight.getRGB()<0) ||
					(pixelRight2.getRGB()>-300000 &&pixelRight2.getRGB()<0) ||
					(pixelRight3.getRGB()>-300000 &&pixelRight3.getRGB()<0) ){
				robotUtil.pressKey(KeyEvent.VK_D);
				aaa = 0;
			}else if(aaa > 10){
				break;
			}else{
				aaa++;
			}
		}
	}
}
