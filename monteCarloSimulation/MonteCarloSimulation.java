package monteCarloSimulation;

public class MonteCarloSimulation
{
    public static void main(String[] args)
    {
        double x, y;
        int hit = 0; 
        for(int i = 0; i < 1000000; i++)
        {
            x = Math.random() * 2 - 1;
            y = Math.random() * 2 - 1;
            if(x < 0 || (x > 0 && y > 0 && x + y < 1))
                hit++;
        }
        System.out.println("命中奇数标识的区域的概率为: " + hit / 1000000.0);
    }
}
