package bitOperation;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 输入一个短整型的数，输出二进制表示形式
 * @author youkpter 2014年 10月 14日 星期二 22:57:26 CST
 */
public class BitOperation
{
    public static void main(String[] args)
    {
        short[] inputToArray = new short[16];
        Scanner inputStr = new Scanner(System.in);
        System.out.print("Please input the short integer: ");
        short input = inputStr.nextShort();

        inputToArray[15] = (short)(input & 0x0001);
        for(int i = 14; i >= 0 ; i--)
        {
            input >>= 1;
            inputToArray[i] = (short)(input & 0x0001);
        }
        
        System.out.print("The bits are ");
        for(short i : inputToArray)
            System.out.print(i);
        System.out.println();
    }
}
