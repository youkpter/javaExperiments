package learnAdd;

import javax.swing.JOptionPane;

/**
 * This program demonstrates exercise 3.4 in page 85
 * @author youkpter
 */
public class SumOfTwoInt
{
    public static void main(String[] args)
    {
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);

        String inputString = JOptionPane.showInputDialog(null, "Please input the sum of " + a + " "+ b,
                "SumOfTwoInt", JOptionPane.QUESTION_MESSAGE);
        int answer = Integer.parseInt(inputString);
        
        if(answer == (a + b))
            JOptionPane.showMessageDialog(null, "true", "SumOfTwoInt", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "false", "SumOfTwoInt", JOptionPane.INFORMATION_MESSAGE);
    }
}
