package sort;

import javax.swing.JOptionPane;

/**
 * This program demonstrates exercise 3.8 in page 85
 * @author youkpter
 * 2014年 09月 23日 星期二 19:27:17 CST
 */
public class SortOfThreeIntegers
{
    public static void main(String[] args)
    {
        String inputString = JOptionPane.showInputDialog(null, "Please input three integers",
                "sortOfThreeIntegers", JOptionPane.QUESTION_MESSAGE);

        //split the string into three substring indicating num1, num2, num3
        String[] inputSubString =inputString.split("\040+");

        int[] num = new int[3];
        //parse string to int
        for(int i = 0; i < 3; i++)
            num[i] = Integer.parseInt(inputSubString[i]);

        String output = sortThreeIntegers(num[0], num[1], num[2]);
        JOptionPane.showMessageDialog(null, "这三个数由小到大排序为：\n" + output, "The result is",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static String sortThreeIntegers(int a, int b, int c)
    {
        if(a < b)
        {
            if(a < c)
            {
                if(b < c)
                    return String.format("%5d%5d%5d", a, b, c);
                else
                    return String.format("%5d%5d%5d", a, c, b);
            }
            else
                return String.format("%5d%5d%5d", c, a, b);
        }
        else
        {
            if(a < c)
                return String.format("%5d%5d%5d", b, a, c);
            else
            {
                if(b < c)
                    return String.format("%5d%5d%5d", b, c, a);
                else
                    return String.format("%5d%5d%5d", c, b, a);
            }
        }
    }
}
