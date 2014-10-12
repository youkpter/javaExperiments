package bankgui;

import javax.swing.JOptionPane;

public class BankGui
{
    public static void main(String[] args)
    {
        String password = "134552";
        int option;
        int count = 0;
        String input;

        while(count < 3)
        {
            input = JOptionPane.showInputDialog("Please input your password: ");
            if(input.equals(password))
            {
                JOptionPane.showMessageDialog(null, "Congratulation");
                System.exit(0);
            }
            else
            {
                //第三次的时候不要再继续弹continue的提示框
                if(count == 2)
                    break;
                option = JOptionPane.showConfirmDialog(null, "You are wrong!\nYou have " +
                        (2- count) + " chance(s) to try. Continue?");
                if( option != JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Bye");
                    System.exit(0);
                }
            }
            count++;
        }
        JOptionPane.showMessageDialog(null, "Sorry! Your card is locked");
    }
}
