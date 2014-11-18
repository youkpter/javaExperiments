package people;

import java.awt.*;
import java.awt.geom.*;

/**
 * 将人群中距离彼此最近的两个点的中间作为事件发生地，
 * 其他所有的点都向该点靠拢
 * 1,2点有问题
 */
public class People {
    //十个人的坐标(x, y)
    double[][] pos = {{40, 257}, {110, 72}, {166, 40}, {185, 327}, {210, 157},
                     {237, 184}, {278, 69}, {333, 42}, {379, 9}, {380, 109}};
    //各点到事件点的直线的斜率k
    double[] allK = new double[10];
    //事件发生地点
    double[] eventPosition = new double[2];
    //事件围观圈(自己发明的一个名字，在此程序中表示人进入此圈中就不再靠拢)
    Ellipse2D eventCircle;
    //靠事件发生地最近的两点,这两点不动
    int p1 = 0, p2 = 1;

    //表示人的点的大小
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;

    public People() {
        setEventPosition();
        setAllK();
    }
    /**
     * 找到事件发生地点--距离最近的两点的中点
     */
    public void setEventPosition() {
        double tempDistance = 0;
        double closestDistance = getDistance(pos[0][0], pos[0][1], pos[1][0], pos[1][1]);
        for(int i = 0; i < pos.length; i++) {
            for(int j = i + 1; j < pos.length; j++) {
                tempDistance = getDistance(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
                if(closestDistance > tempDistance) {
                    p1 = i;
                    p2 = j;
                    closestDistance = tempDistance;
                }
            }
        }

        eventPosition[0] = (pos[p1][0] + pos[p2][0]) / 2;  //x coordinate
        eventPosition[1] = (pos[p1][1] + pos[p2][1]) / 2;  //y coordinate

        //设置事件围观圈^_^
        double radius = closestDistance / 2 + XSIZE * 2;
        eventCircle = new Ellipse2D.Double();
        eventCircle.setFrameFromCenter(eventPosition[0], eventPosition[1],
                eventPosition[0] + radius, eventPosition[1] + radius);
    }

    /**
     * 得到表示人的圆点
     * @param i 表示第i个人
     */
    public Ellipse2D getPeopleShape(int i) {
        return new Ellipse2D.Double(pos[i][0], pos[i][1], XSIZE, YSIZE);
    }

    /**
     * 得到表示事件发生地的点
     */
    public Ellipse2D getEventShape() {
        return new Ellipse2D.Double(eventPosition[0], eventPosition[1], 4, 4);
    }

    /**
     * 计算所有点(除了最近的那两个点)的斜率k
     */
    public void setAllK() {
        for(int i = 0; i < pos.length; i++) {
            if(i == p1 || i == p2)
                continue;
            if(pos[i][0] == eventPosition[0])
                continue;
            //由于显示的面板的坐标系是以左上角为原点，所以斜率相反加负号
            allK[i] = Math.abs((pos[i][1] - eventPosition[1]) / (pos[i][0] - eventPosition[0]));
        }
    }
    /**
     * 移动到事件发生地，每次移动15个像素
     * 如果所有的人都在事件围观圈内则返回true
     */
    public boolean move() {
        double xStep;
        //起初就有两个人在该圈内
        int peopleInCircle = 2;
        for(int i = 0; i < pos.length; i++) {
            if(i == p1 || i == p2) 
                continue;
            //如果在事件围观圈内
            if(eventCircle.contains(pos[i][0], pos[i][1])) {
                ++peopleInCircle;
                continue;
            }
            //如果该点的x坐标与事件点的x坐标相等(直线没有斜率)
            if(pos[i][0] == eventPosition[0]) {
                if(pos[i][1] > eventPosition[1])
                    pos[i][1] -= 15;
                else
                    pos[i][1] += 15;
                continue;
            }

            //X^2 + Y^2 = 15^2
            xStep = 15 / Math.sqrt(allK[i] * allK[i] + 1);
            if(pos[i][0] < eventPosition[0]) {
                pos[i][0] += xStep;
            } else {
                pos[i][0] -= xStep;
            }
            if(pos[i][1] < eventPosition[1]) {
                pos[i][1] += allK[i] * xStep;
            } else {
                pos[i][1] -= allK[i] * xStep;
            }
        }
        if(peopleInCircle == 10) {
            System.out.println("over!");
            return true;
        }
        else
            return false;
    }

    /**
     * 求两点间的距离
     */
    public double getDistance(double x1,double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
