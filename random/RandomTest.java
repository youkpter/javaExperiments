package random;

import java.util.Scanner;

/*
 * This program demonstrate the way to calculate random number in
 * a <= x < b
 * a <= x <= b
 * a < x < b
 * a < x <= b
 * @author youkpter
 * 2014年 09月 23日 星期二 10:46:28 CST
 */

public class RandomTest
{
    public static void main(String[] args)
    {
        RandomNumber ranNum = new RandomNumber(); 

        System.out.print("please input integer a and b: ");
        Scanner input = new Scanner(System.in);
        ranNum.setA(input.nextInt());
        ranNum.setB(input.nextInt());

        ranNum.outputTenRandomForExaExb();
        ranNum.outputTenRandomForExaInb();
        ranNum.outputTenRandomForInaExb();
        ranNum.outputTenRandomForInaInb();
    }
}
