package people;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new EventFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class EventFrame extends JFrame {
    private PeoplePanel panel;
    private JPanel buttonPanel;

    public EventFrame() {
        panel = new PeoplePanel();
        buttonPanel = new JPanel();

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Runnable r = new PeopelRunnable(panel);
                Thread t = new Thread(r);
                t.start();

            }
        });
        buttonPanel.add(startButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}

class PeopelRunnable implements Runnable {
    //延时半秒
    private static final int DELAY = 500;
    private PeoplePanel peoPanel;

    public PeopelRunnable(PeoplePanel peoPanel) {
        this.peoPanel = peoPanel;
    }

    public void run() {
        boolean isOver = false;
        while(true) {
            try {
                //如果人群都在事件围观圈中就退出
                isOver = peoPanel.people.move();
                peoPanel.repaint();
                if(isOver)
                    break;
                Thread.sleep(DELAY);
            } catch(InterruptedException e) {
            }
        }
        System.out.println("thread over");
    }
}
