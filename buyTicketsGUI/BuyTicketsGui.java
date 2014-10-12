package buyTicketsGUI;

import java.awt.*;
import javax.swing.*;

public class BuyTicketsGui
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    JFrame frame = new BuyTicketsFrame();
                    frame.setTitle("Welcome To Take Subway");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });
    }
}
