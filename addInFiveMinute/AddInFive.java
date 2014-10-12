package addInFiveMinute;

import java.util.*;
/**
 * 五分钟做完五道加法题，时间到了要报错
 * @author youkpter
 * 2014年 10月 08日 星期三 08:53:41 CST
 */
public class AddInFive
{
    private static int a, b;
    private static int answer;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {

        int count;
        Thread t = new Thread(new Timer());
        t.start();
        getQuestion();
        answer = input.nextInt();
        count = 1;

        while(count < 5)
        {
            while(answer != a - b)
            {
                System.out.print("Your are wrong! Please try again: ");
                answer = input.nextInt();
            }
            count++;
            System.out.println("You are right! Another question");
            getQuestion();
            answer = input.nextInt();
        }
        
        System.out.println("That'all! Bye");
        System.exit(0);
    }

    public static void getQuestion()
    {
        a = (int)(Math.random() * 100);
        b = (int)(Math.random() * 100);

        if(a < b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        System.out.print("What is " + a + "-" + b + "? ");
    }
}
