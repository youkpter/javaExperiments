package GuessBirthday;

import java.util.Scanner;

public class GuessBirthday
{
    public static void main(String[] args)
    {
        String set =
            " 1  3  5  7\t  2  3  6  7\t  4  5  6  7\t  8  9 10 11\t 16 17 18 19\n" +
            " 9 11 13 15\t 10 11 14 15\t 12 13 14 15\t 12 13 14 15\t 20 21 22 23\n" +
            "17 19 21 23\t 18 19 22 23\t 20 21 22 23\t 24 25 26 27\t 24 25 26 27\n";

        int birthday = 0;
        int[] setMeaning = {1, 2, 4, 8, 16};

        System.out.println(set);
        System.out.println("请问你生日在哪几个集合中(1 - 5)");
        Scanner input = new Scanner(System.in);
        String birthdayString = input.nextLine();

        //split birthdaystring to several setNumber Strings
        String[] setNumberString = birthdayString.split("\040+");

        //change String into int
        int temp;
        for(int i = 0; i < setNumberString.length; i++)
        {
             temp = Integer.parseInt(setNumberString[i]);
             birthday += setMeaning[temp-1];
        }

        System.out.println("your birthday is " + birthday);
    }
}
