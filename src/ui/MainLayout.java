package ui;

import ui.jpanel.AutoKillJPanel;
import ui.jpanel.FishingJPanel;
import ui.jpanel.One20JPanel;

import javax.swing.*;
import java.awt.*;

public class MainLayout extends JFrame{

    public MainLayout(){

        super();
        Container container = this.getContentPane();
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

        tab.addTab("钓鱼", new FishingJPanel());
        tab.addTab("打怪", new One20JPanel());
        tab.addTab("120", new AutoKillJPanel());
        tab.setFont(new Font("微软雅黑",1,15));
        container.add(tab);
        this.setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("我欲成仙，快乐齐天");
        this.setVisible(true);
    }

    public static void main(String args[]){

        MainLayout mainLayout = new MainLayout();
    }
}
