package TransformTime;

import java.util.Scanner;

public class TransformTime  {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        int currentTime = 0;

        do  {
            System.out.print("Please input current time(0 - 86400): ");
            currentTime = input.nextInt();
        }while(currentTime < 0 || currentTime > 86400);

        int seconds = currentTime % 60;
        int remainingMinutes = currentTime / 60;

        int minutes = remainingMinutes % 60;
        int hours = remainingMinutes / 60;  //get the number of hours

        String amOrPm = (hours < 12) ? " am" : " pm";
        if(hours > 12)
            hours -= 12;   //make 0 <= hours <=12

        System.out.println("The current time is: " + hours + ":" +
                minutes + ":" + seconds + amOrPm);
    }
}
