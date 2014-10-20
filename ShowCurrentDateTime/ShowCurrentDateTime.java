package ShowCurrentDateTime;

public class ShowCurrentDateTime
{
    public static void main(String[] args)
    {
        int currentYear = 1970;
        int currentMonth = 0; //0 represents January
        int currentDay = 1;
        int[] daysOfMonthes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        long totalMilliseconds = System.currentTimeMillis();

        //Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;
        //get the current second
        long currentSecond = totalSeconds % 60;
        
        //get the total minutes
        long totalMinutes = totalSeconds / 60;
        //get the current minute
        long currentMinute = totalMinutes % 60;
        
        //get the total hours
        long totalHours = totalMinutes / 60;
        //get the current hour(按24小时制)
        long currentHour = totalHours % 24;

        //get the total days
        long totalDays = totalHours / 24;
        
        //get current year
        while(totalDays >= 365)
        {
            if(isLeapYear(currentYear))
                totalDays -= 366;
            else
                totalDays -= 365;
            currentYear++;
        }

        //if current year is leap year
        if(isLeapYear(currentYear))
            daysOfMonthes[1]++;

        //get current month
        while(totalDays >= daysOfMonthes[currentMonth])
        {
            totalDays -= daysOfMonthes[currentMonth];
            currentMonth++;
        }

        //get current day
        currentDay += totalDays;

        System.out.println("The current date and time is " + currentYear + "年 "
                + (currentMonth + 1) + "月 " + currentDay + "日 " + currentHour
                + ":" + currentMinute + ":" + currentSecond);
    }

    public static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
