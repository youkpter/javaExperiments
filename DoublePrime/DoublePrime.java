package DoublePrime;

/**
 * exercise5.30 计算1000以内的所有双素数
 * @author youkpter
 * 2014年 10月 20日 星期一 16:35:20 CST
 */
public class DoublePrime
{
    public static void main(String[] args)
    {
        for(int i = 2; i < 998; i++)
            if(isPrime(i) && isPrime(i + 2))
                System.out.println("(" + i + ", " + (i + 2) + ")");
    }

    public static boolean isPrime(int num)
    {
        if(num <= 1)
            return false;

        for(int i = 2; i<= num / 2; i++)
            if(num % i == 0)
                return false;
        
        //如果程序运行到此, 则num为素数
        return true;
    }
}
