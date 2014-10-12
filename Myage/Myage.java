package Myage;
/*
 * 2014年 09月 09日 星期二 13:00:10 CST
 * 输入出生日期(年，月，日),输出岁数(xx年xx月xx日,其中年为365天，月为30天)
 * Bugs:出生日期格式应该为19xx xx xx，年份不小于1970,对输入不进行任何检查
 */

import java.util.Scanner;

public class Myage  {
    public static void main(String[] args)  {
        System.out.print("Please input your birthday(19xx xx xx): ");
        Scanner inputAge = new Scanner(System.in);
        int yearsOfLeap  = 0;
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int year  = inputAge.nextInt();
        int month = inputAge.nextInt();
        int day   = inputAge.nextInt();

        //算出1970(包括)- 出生年份前一年(包括)的闰年数
       for(int i = 1970; i < year; i++)
            if(isLeapYear(i))
                yearsOfLeap++;

        //先将年份转换为天数，考虑闰年
        long daysOfBirth = (year - 1970) * 365 + yearsOfLeap;
        
        //如果出生的那年为闰年且出生月份大于2则天数加1
        if(isLeapYear(year) && month > 2)
            daysOfBirth++; 

        //将月份转为天数
        for(int i = 0; i < month-1; i++)
            daysOfBirth += daysOfMonth[i];
        
        //加上最后的天数
        daysOfBirth += day;

        //获取当前时间距离1970,01,01的天数
        long totalMilliseconds = System.currentTimeMillis();
        long daysOfCurrent     = totalMilliseconds / (1000 * 60 * 60 * 24);
        long totalSavedDays    = daysOfCurrent - daysOfBirth;

        long savedYears      = totalSavedDays / 365;
        long totalDays       = totalSavedDays % 365;
        long savedMonth      = totalDays / 30;
        long savedDays       = totalDays % 30;
        
        System.out.println("You have saved " + totalSavedDays + " days." + "That is "+ savedYears +
                " years " + savedMonth + " monthes " + savedDays + " days");
    }

    public static boolean isLeapYear(int year)  {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }
}
