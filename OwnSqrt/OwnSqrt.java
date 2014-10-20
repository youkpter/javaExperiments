package OwnSqrt;

import java.util.*; 
/**
 * 近似求平方根
 * nextGuess = (lastGuess + (num / lastGuess)) / 2
 * 设置lastGuess的初始值为1
 * 如果lastGuess与nextGuess相差小于某个数就认为求到了
 * 平方根
 * @author youkpter
 * 2014年 10月 15日 星期三 11:33:22 CST
 */
public class OwnSqrt
{
    public static void main(String[] args)
    {
        double number, sqrt;
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a non-negative number to get the sqrt: ");
        while( (number = input.nextDouble()) < 0 )
            System.out.print("Your input are illegal. Please try again: ");

        sqrt = getSqrt(number);
        System.out.println("The sqrt of " + number + " is " + sqrt);
    }

    public static double getSqrt(double number)
    {
        double DEVIATION = 0.0001;
        double lastGuess = 1.0; //当前的猜测值，初始值为1
        double nextGuess;
        double currentDeviation;
        
        do
        {
            nextGuess = (lastGuess + (number / lastGuess)) / 2;
            currentDeviation = nextGuess - lastGuess;
            //如果当前误差大于指定值, 即: |currentDeviation| < DEVIATION
            if(currentDeviation > 0 ? currentDeviation > DEVIATION :
                    currentDeviation < -DEVIATION)
                lastGuess = nextGuess;
            else
                break;

        }while(true);
        
        return nextGuess;
    }
}
