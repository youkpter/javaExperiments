package Dice;

/**
 * execise 5.32 掷骰子
 * @author youkpter
 * 2014年 10月 20日 星期一 17:20:52 CST
 */
public class Dice
{
    public static void main(String[] args)
    {
        int winCount = 0;
        for(int i = 0; i < 10000; i++)
            if(playGame())
                winCount++;

        System.out.println("You totally won " + winCount + " times");
    }

    public static boolean playGame()
    {
        int dice1, dice2, sum;
        
        dice1 = (int)(Math.random() * 6) + 1;
        dice2 = (int)(Math.random() * 6) + 1;
        sum = dice1 + dice2;

        if(sum == 2 || sum == 3 || sum == 12)
            return false;
        if(sum == 7 || sum == 11)
            return true;

        int temp;
        do
        {
            dice1 = (int)(Math.random() * 6) + 1;
            dice2 = (int)(Math.random() * 6) + 1;
            temp = dice1 + dice2;
        
            if(temp == 7)
                return false;
            if(temp == sum)
                return true;
            sum = temp; //更新sum
        }while(true);
    }
}
