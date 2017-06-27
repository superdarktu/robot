package ui.jpanel;

import model.Position1366;
import running.FishRunning;
import running.Running;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FishingJPanel extends JPanel {

    private Running running;

    public FishingJPanel() {

        super();
        this.setLayout(null);

        JLabel timeLabel = new JLabel("时间:");
        timeLabel.setBounds(10,50,80,25);
        timeLabel.setFont(new Font("微软雅黑",1,15));
        this.add(timeLabel);

        JTextField timeText = new JTextField(20);
        timeText.setBounds(100,50,165,25);
        this.add(timeText);

        JButton startButton = new JButton("开始");
        startButton.setFont(new Font("微软雅黑",1,15));
        startButton.setBounds(10, 100, 80, 25);
        this.add(startButton);

        JButton stopButton = new JButton("暂停");
        stopButton.setFont(new Font("微软雅黑",1,15));
        stopButton.setBounds(100, 100, 80, 25);
        this.add(stopButton);

        String remark = "<html>时间输入框输入蓄力时间，单位是毫秒<br />可以自己多次测试确定时间，比较精准</html>";
        JLabel remarkLabel = new JLabel(remark);
        remarkLabel.setBounds(10,150,400,100);
        remarkLabel.setFont(new Font("微软雅黑",1,15));
        this.add(remarkLabel);

        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String time = timeText.getText();
                int paoganTime = 500;
                if(time != null && time.length()>0){
                    try{
                        paoganTime = Integer.parseInt(time);
                    }catch (Exception ex){

                    }
                }

                running = new FishRunning(5000,paoganTime, Position1366.FISHING_X,Position1366.FISHING_Y,Position1366.FISHING_LEFT_X,Position1366.FISHING_LEFT_Y,Position1366.FISHING_RIGHT_X,Position1366.FISHING_RIGHT_Y);

                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        running.run();
                    }
                });
                thread.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("结束钓鱼");
                if (running != null)
                    running.stop();
            }
        });
    }
}
