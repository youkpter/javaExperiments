package addInFiveMinute;

import javax.swing.*;

/**
 * 一个倒计时线程，时间为1分钟
 * @author youkpter
 * 2014年 10月 08日 星期三 09:11:20 CST
 */
public class Timer implements Runnable
{
    private static final int DELAY = 200;
    public void run()
    {
        long startTime = System.currentTimeMillis();
        try
        {
            //为了测试方便，只提供1分钟答题
            while(System.currentTimeMillis() - startTime < 60000)
                Thread.sleep(DELAY);
        }
        catch(InterruptedException e)
        { //don't know how to handle thiw exception
        }
        
        System.out.println("\nTime out");
        System.exit(0);
    }
}
