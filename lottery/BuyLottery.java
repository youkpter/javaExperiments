package lottery;

import java.util.Scanner;

/**
 * @author youkpter
 * 2014年 09月 23日 星期二 15:38:20 CST
 * 模拟福利彩票中奖，6个红球[1-33]，1个蓝球[1-16]
 */
public class BuyLottery
{
    public static void main(String[] args)
    {
        Lottery lottery = new Lottery();
        Scanner input   = new Scanner(System.in);
        int[] redNum    = new int[6]; //存放红球号码
        int   blue      = 0;         //存放蓝球号码

        System.out.println("Please input six digits(1<=x<=33) for red and one digit(1-16) for blue:");
        for(int i = 0; i < 6; i++)
            redNum[i] = input.nextInt();
        blue = input.nextInt();

        System.out.println(lottery.getAward(redNum, blue));
        System.out.println("中奖号码为：" + lottery. getHitResultString());
    }
}
