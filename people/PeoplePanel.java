package people;

import java.awt.*;
import javax.swing.JPanel;

/**
 * 绘制人群的面板
 */
public class PeoplePanel extends JPanel {
    private static final int DEFAULT_WIDTH  = 450;
    private static final int DEFAULT_HEIGHT = 450;

    People people = new People();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //绘制人群
        for(int i = 0; i < people.pos.length; i++) {
            g2.fill(people.getPeopleShape(i));
        }
        //绘制事件发生点
        g2.setPaint(Color.RED);
        g2.fill(people.getEventShape());
        //绘制事件围观圈
        g2.draw(people.eventCircle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
