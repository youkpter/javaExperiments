package weekdayForEachMonth;

import java.util.Scanner;

/**
 * 根据用户输入的年份和代表该年1月1号的星期号
 * 输入该年每月1号的星期号
 * @author youkpter
 * 2014年 10月 14日 星期二 15:43:50 CST
 */
public class WeekdayForEachMonth
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a year and the weekday of  1st January: ");
        int year = input.nextInt();
        int weekday = input.nextInt();

        printWeekdayForEachMonth(year, weekday);
    }

    public static void printWeekdayForEachMonth(int year, int weekday)
    {
        String[] monthes = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "Oct0ber", "December", "November"};
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday"};

        //days of each month(don't consider leap year)
        int[] daysForEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] weekdaysForEachMonth = new int[12];
        weekdaysForEachMonth[0] = weekday;

        int weekdayForCurrentMonth = 0;
        for(int i = 2; i <= 12; i++)
        {
            //数组下标是i-2，i表示月份，[i-1]表示该月在数组中的位置，
            //i-2表示上一月的位置
            weekdayForCurrentMonth = (daysForEachMonth[i-2] + weekdaysForEachMonth[i-2]) % 7;
            //如何求三月1号的星期号则要考虑闰年
            if(i == 3) 
                if(isLeapYear(year))
                    weekdayForCurrentMonth++;
            weekdaysForEachMonth[i-1] = weekdayForCurrentMonth;
        }

        for(int i = 0; i < 12; i++)
            System.out.printf("%9s 1, %d is %9s\n", monthes[i], year, weekdays[weekdaysForEachMonth[i]]);
    }
    
    public static boolean isLeapYear(int year)
    {
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }
}
