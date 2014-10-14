package hextodec;

import java.util.Scanner;

public class HexToDec
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a hexdecimal number: ");
        String inputStr = input.nextLine();
        int result = hexToDec(inputStr);
        System.out.println("the decimal value of " + "0x" + inputStr
                + " is " + result);
    }

    public static int hexToDec(String inputStr)
    {
        char[] inputChar = inputStr.toCharArray();
        int weight = 1;
        int result = 0;
        for(int i = inputChar.length - 1; i >= 0; i--)
        {
            result += charToInt(inputChar[i]) * weight;
            weight *= 16;
        }
        
        return result;
    }

    /**
     * 16进制的字符转换为十进制的数字
     * 假设a符合条件
     */
    public static int charToInt(char a)
    {
        if(a <= '9' && a >= '0')
            return (int)(a - '0');
        else if(a <= 'F' && a >= 'A')
            return (int)(a - 'A') + 10;
        else 
            return (int)(a - 'a') + 10;
    }
}
