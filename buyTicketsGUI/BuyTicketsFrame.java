package buyTicketsGUI;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.awt.event.*;
import javax.swing.*;

public class BuyTicketsFrame extends JFrame
{
    private MainPanel mainPanel;
    private ComfirmPanel comfirmPanel;

    public BuyTicketsFrame()
    {
        add(new WelcomePanel(), BorderLayout.NORTH);

        comfirmPanel = new ComfirmPanel();
        add(comfirmPanel, BorderLayout.SOUTH);

        mainPanel = new MainPanel();
        mainPanel.setLayout(new GridLayout(2, 2, 20, 20));
        mainPanel.addSubPanel("5");
        mainPanel.addSubPanel("3");
        mainPanel.addSubPanel("2");
        mainPanel.addSubPanel("1");
        add(mainPanel, BorderLayout.CENTER);

        pack();
    }

    private class WelcomePanel extends JPanel
    {
        private static final int DEFAULT_WIDTH = 400;
        private static final int DEFAULT_HEIGHT = 80;

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;

            String welcomeMessage = "Welcome To Take Subway!";

            Font f = new Font("SansSerif", Font.BOLD, 20);
            g2.setFont(f);

            //measure the size of the message
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = f.getStringBounds(welcomeMessage, context);

            //set (x, y) = top left corner of text
            double x = (getWidth() - bounds.getWidth()) / 2;
            double y = (getHeight() - bounds.getHeight()) / 2;

            //add ascent to y to reach the baseline
            double ascent = -bounds.getY();
            double baseY = y + ascent;

            //draw the message
            g2.drawString(welcomeMessage, (int)x, (int)baseY);
        }

        public Dimension getPreferredSize()
        {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    private class MainPanel extends JPanel
    {
        private ArrayList<SubPanel> subPanels = new ArrayList<>(4);

        public void addSubPanel(String ticketPrice)
        {
            SubPanel subPanel = new SubPanel(ticketPrice);
            this.add(subPanel);
            subPanels.add(subPanel);
        }

        public int getTotalTicketCost()
        {
            int totalCost = 0;

            for(SubPanel s : subPanels)
                totalCost += s.getTicketPrice() * s.getTicketNum();
            
            return totalCost;
        }
    }

    private class SubPanel extends JPanel
    {
        private JRadioButton ticketButton;
        private JTextField textField;

        public SubPanel(String ticketPrice)
        {
            setLayout(new GridLayout(2, 2, 3,5));
            ticketButton = new JRadioButton(ticketPrice + "元");
            textField = new JTextField(8);
            textField.setEditable(false);  //can't edit defaultly

            add(new JLabel("票价: ", JLabel.RIGHT));
            add(ticketButton);
            add(new JLabel("票数: ", JLabel.RIGHT));
            add(textField);

            pack();

            ticketButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        //reverse the status of textField
                        textField.setEditable(! textField.isEditable());
                    }
                });
        }

        /**
         * get the price of ticket
         * @return the price of the ticket in int if the JRadioButton is selected, 0 otherwise.
         */
        public int getTicketPrice()
        {
            if(ticketButton.isSelected())
            {
                //the first position in tieketButton's text is the price
                String priceString = ticketButton.getText().substring(0, 1);
                int price = Integer.parseInt(priceString);
                return price;
            }
            else //if the ticketButton is not selected
                return 0;
        }

        /**
         * get the number of ticket
         * @return the content of JTextField in int if the JRadioButton is
         * selected, 0 otherwise.
         */
        public int getTicketNum()
        {
            if(ticketButton.isSelected())
            {
                //trim leading and trailing sapces in the text field
                String numberStr = textField.getText().trim();
                int num = Integer.parseInt(numberStr);
                return num;
            }
            else //if the ticketButton isn't selected
                return 0;
        }
        public int getTicketCost()
        {
            return getTicketPrice() * getTicketNum();
        }
    }

    private class ComfirmPanel extends JPanel
    {
        private JButton OkButton;

        public ComfirmPanel()
        {
            setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
            OkButton = new JButton("OK");
            OkButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        int cost = mainPanel.getTotalTicketCost();
                        String inputStr = JOptionPane.showInputDialog(null, "The ticket price is " + cost +
                            ".\nPlease input meoney to pay", "pay for", JOptionPane.INFORMATION_MESSAGE);
                        int input = Integer.parseInt(inputStr);
                        while(input < cost)
                        {
                            String inStr = JOptionPane.showInputDialog(null, "must have other " + (cost - input),
                                "pay for", JOptionPane.INFORMATION_MESSAGE);
                            input += Integer.parseInt(inStr);
                        }

                        JOptionPane.showMessageDialog(null, "You input " + input + " money.\nThe rest is " +
                            (input - cost), "rest money", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            add(OkButton);
        }
    }
}
