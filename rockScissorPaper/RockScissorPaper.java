package rockScissorPaper;

import java.util.Scanner;
/**
 * 实现石头剪刀布游戏，用户或电脑有一方连续赢了
 * 两次就退出
 */
public class RockScissorPaper
{

    private static final String[] gesture = { "scissor", "rock", "paper"};
    public static void main(String[] args)
    {
        //单盘的赢家,1表示用户赢了，0表示平局，-1表示电脑赢了
        int winner;
        int userContinualWinCount = 0;
        int computerContinualWinCount = 0;
        int computer; //电脑出什么
        int user;    //用户出什么
        Scanner input = new Scanner(System.in);

        while(userContinualWinCount < 2 && computerContinualWinCount < 2)
        {
            System.out.print("srissor (0), rock (1), paper (2)\n"
                   + "Please input the number: ");
            user = input.nextInt();
            while(user != 0 && user != 1 && user != 2)
            {
                System.out.println("Your input is illeagl, Please input again: ");
                user = input.nextInt();
            }

            computer = (int)(Math.random() * 3);
            //1表示用户赢了，0表示平局，-1表示电脑赢了
            winner = getWinner(user, computer);
            if(winner == 1) 
            {
                userContinualWinCount++;
                //用户赢了则电脑连续赢的盘数要清零
                computerContinualWinCount = 0;
            }
            else if(winner == -1)
            {
                computerContinualWinCount++;
                //电脑赢了则用户连续赢的盘数要清零
                userContinualWinCount = 0;
            }
            else //平局则都清零
            {
                computerContinualWinCount = 0;
                userContinualWinCount = 0;
            }
        }
        if(userContinualWinCount == 2)
            System.out.println("You have won twice continually. Congratulations!");
        else
            System.out.println("Sorry! The computer has won twice continually");
    }

    /**
     * get the winner
     * @param user the gesture of user
     * @param computer the gesture of computer
     * @return 1 if user win, 0 if it's a draw, -1 otherwise
     */
    public static int getWinner(int user, int computer)
    {
        if(user == computer)
        {
            System.out.println("The computer is " + gesture[computer]
                    + ". You are " + gesture[user] + " too. It's a draw");
            return 0;
        }
        if(user == 0) //剪刀
            if(computer == 1) //石头
            {
                System.out.println("The computer is rock. You are scissor The computer won");
                return -1;
            }
            else //此时不会有用户和电脑相同的情况，所以computer是2(paper)
            {
                System.out.println("The computer is paper. You are scissor. You won");
                return 1;
            }
        else if(user == 1) //石头
        {
            if(computer == 2) //布
            {
                System.out.println("The computer is paper. You are rock. The computer won");
                return -1;
            }
            else
            {
                System.out.println("The computer is scissor. You are rock. You won");
                return 1;
            }
        }
        else //布
        {
            if(computer == 0)
            {
                System.out.println("The computer is scissor. You are paper. The computer won");
                return -1;
            }
            else
            {
                System.out.println("The computer is rock. You are paper. You won");
                return 1;
            }
        }
    }
}
