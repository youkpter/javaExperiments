package card;

import javax.swing.JOptionPane;

/**This program demonstrates exercise 3.24 in page 88
 * @author youkpter
 * 2014年 09月 23日 星期二 20:52:16 CST
 */
public class getCard
{
    public static void main(String[] args)
    {
        String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King"};
        String[] colors = { "Clubs", "Diamond", "Heart", "Spades"};
        int a = (int)(Math.random() * 13);
        int b = (int)(Math.random() * 4);

        JOptionPane.showMessageDialog(null, "The card you picked is \n" + cards[a]
                +"   " + colors[b]);
    }
}
