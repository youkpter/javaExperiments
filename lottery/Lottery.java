package lottery;

import java.util.Scanner;
import java.util.ArrayList;

public class Lottery
{
    private ArrayList<Integer> redNum = new ArrayList<>(6);
    private int blueNum = 0;

    public Lottery()
    {   //给出中奖号码
        int tempRedNum = (int)(Math.random() * 33 +1);

        //先任意加入一个红球号码
        redNum.add(tempRedNum); 
        //互斥地加入另外5个红球号码，使得redNum中的红球号码互不相同
        for(int i = 0; i < 5; i++)
        {
            do
            {
                //get a red number in [1,33] randomly
                tempRedNum = (int)(Math.random() * 33 +1);
            } while(redNum.contains(tempRedNum));
            
            //now redNum doesn't contain tempRedNum, so add it
            redNum.add(tempRedNum);
        }

        //get blue number 
        blueNum = (int)(Math.random() * 16 + 1);
    }

    //以String型输出中奖号码
    public String getHitResultString()
    {
        String temp = "red: ";
        for(int i : redNum)
            temp += (i + " ");
        temp += ("blue: " + blueNum);
        return temp; 
    }

    //根据参数得出用户中奖名次
    public String getAward(int[] redNum, int blueNum)
    {
        int hitRedNum = 0;
        boolean hitBlue = false;
        for(int i = 0; i < 6; i++)
            if(this.redNum.contains(redNum[i]))
                hitRedNum++;  //命中红球号码个数加1
        hitBlue = (this.blueNum == blueNum);

        if(hitBlue)     //命中了蓝球就有奖
        {
            if(hitRedNum == 6)        //中6+1
                return "一等奖";
            else if(hitRedNum == 5)  //中5+1
                return "三等奖";
            else if(hitRedNum == 4) //中4+1
                return "四等奖";
            else if(hitRedNum == 3) //中3+1
                return "五等奖";
            else                   //中2+1或1+1或0+1
                return "六等奖";
        }
        else
        {
            if(hitRedNum == 6)      //中6+0
                return "二等奖";
            else if(hitRedNum == 5) //中5+0
                return "三等奖";
            else if(hitRedNum == 4) //中4+0
                return "五等奖";
            else
                return "对不起，您没中";         //没中
        }
    }
}
