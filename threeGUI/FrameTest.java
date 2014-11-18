package threeGUI;

import java.util.Date;
import java.util.Random;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                JFrame frame1 = new MessageFrame(new Date().toString());
                JFrame frame2 = new MessageFrame(randomString());
                JFrame frame3 = new GUIComponents();

                frame2.setLocation(150, 150);
                frame3.setLocation(300, 300);

                frame1.setVisible(true);
                frame2.setVisible(true);
                frame3.setVisible(true);
            }
        });
    }


    /**
     * 使用当前时间产生10个100以内的随机数
     */
    private static String randomString() {
        int[] randomNum = new int[10];
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            randomNum[i] = random.nextInt(100);
        }

        return Arrays.toString(randomNum);
    }
}

class MessageFrame extends JFrame {
    MessagePanel panel;

    public MessageFrame(String message) {
        panel = new MessagePanel(message);
        panel.setFont(new Font("Serif", Font.BOLD, 20));
        add(panel);

        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MessagePanel  extends JPanel {
    //the message to display
    String message;

    public MessagePanel(String message) {
        this.message = message;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(message);
        int stringAscent = fm.getAscent();
        int xCoordinate = getWidth() / 2 - stringWidth / 2;
        int yCoordinate = getHeight() /2 + stringAscent / 2;

        g.drawString(message, xCoordinate, yCoordinate);
    }
}

class GUIComponents extends JFrame {
    JButton jbtOK = new JButton("OK");
    JButton jbtCancel = new JButton("Cancel");
    JLabel jlblName = new JLabel("Enter your name");
    JTextField jtfName = new JTextField("Type Name Here");
    JCheckBox jchkBold = new JCheckBox("Bold");
    JCheckBox jchkItalic = new JCheckBox("Italic");
    JRadioButton jrbRed = new JRadioButton("Red");
    JRadioButton jrbYellow = new JRadioButton("Yellow");
    JComboBox jcboColor = new JComboBox(new String[] {"Freshman",
        "Sophomore", "Junior", "Senior" });


    public GUIComponents() {
        JPanel panel = new JPanel();
        panel.add(jbtOK);
        panel.add(jbtCancel);
        panel.add(jlblName);
        panel.add(jtfName);
        panel.add(jchkBold);
        panel.add(jchkItalic);
        panel.add(jrbRed);
        panel.add(jrbYellow);
        panel.add(jcboColor);

        add(panel);
        setTitle("Show GUI Component");
        setSize(450, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

