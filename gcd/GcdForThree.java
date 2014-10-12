package gcd;

import java.util.Scanner;
/**
 * This program demonstrates how to get the gcd 
 * for three numbers
 * @author youkpter
 * 2014年 10月 10日 星期五 22:43:53 CST
 */
public class GcdForThree
{
    public static void main(String[] args)
    {
        int[] numbers = new int[3];
        Scanner input = new Scanner(System.in);
        int gcd;

        System.out.print("Please input three numbers: ");
        for(int i = 0; i < 3; i++)
            numbers[i] = input.nextInt();

        gcd = gcd(gcd(numbers[0], numbers[1]), numbers[2]);
        System.out.println("The gcd is " + gcd);
    }

    public static int gcd(int a, int b)
    {
        //如果一个数是另一个数的约数就直接取约数
        if(a % b == 0)
            return b;
        else if (b % a == 0)
            return a;
        else
        {
            int k = 2;
            int gcd = 1;

            //一个数的除数最大为本身的一半(不包括数本身)
            int high1 = a / 2; 
            int high2 = b / 2;
            while(k <= high1 && k <= high2)
            {
                if( b % k == 0 && a % k == 0)
                    gcd = k;
                k++;
            }
            return gcd;
        }
    }
}
