package guessCoin;

import javax.swing.JOptionPane;

/**
 * This program demonstrates exercise 3.14 in page 85
 * @author youkpter
 * 2014年 09月 23日 星期二 20:32:01 CST
 */
public class GuessCoin
{
    public static void main(String[] args)
    {
        int option;  //是否继续猜测
        String inputString;
        int input;
        int coin;

        do
        {
            coin = (int)(Math.random() * 2);
            inputString = JOptionPane.showInputDialog("Please input the digit indicating the face of coin");
            input = Integer.parseInt(inputString);
            
            if(input == coin)
               option = JOptionPane.showConfirmDialog(null,"You are right!\nTry again?");
            else
                option = JOptionPane.showConfirmDialog(null, "Sorry, You are wrong!\n Try again?");
        }while(option == JOptionPane.YES_OPTION);
    }
}
