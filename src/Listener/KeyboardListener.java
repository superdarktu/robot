/**
 * Coryright 2015-2020 www.eyaomall.cn
 * All rights reserved.
 * @author tumingjun
 * @date 2017年4月5日
 *
 */

package Listener;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * @author tumingjun
 *
 */
public class KeyboardListener extends JFrame{
	
	public void run(){
		System.out.println("监听开始");
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {  
           
			@Override  
            public void eventDispatched(AWTEvent event) {  
                // TODO Auto-generated method stub  
            	System.out.println("222222222");
            	System.out.println(((KeyEvent)event).getID());
                if(((KeyEvent)event).getID()==KeyEvent.KEY_PRESSED){  
                	
                    switch (((KeyEvent)event).getKeyCode()) {  
                    case KeyEvent.VK_F1:  
                        System.out.println("f1"); 
                        break;  
                    case KeyEvent.VK_F2:  
                    	System.out.println("f2"); 
                        break;  
                    case KeyEvent.VK_F3:  
                    	System.out.println("f3"); 
                        break;  
                    case KeyEvent.VK_F4:  
                    	System.out.println("f4"); 
                        break;  
                    case KeyEvent.VK_F5:  
                    	System.out.println("f5"); 
                        break;  
                    case KeyEvent.VK_F6:  
                    	System.out.println("f6"); 
                        break;  
                    case KeyEvent.VK_F7:  
                    	System.out.println("f7"); 
                        break;  
                    case KeyEvent.VK_F8:  
                    	System.out.println("f8");  
                        break;  
                    }  
                }  
            }  
        }, AWTEvent.WINDOW_EVENT_MASK);  
	}
}
