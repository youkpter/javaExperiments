package guessNumber;

/**
 * 貌似answer, totalTimes设置成static有问题
 * 因为这样new多个对象的时候这些值很乱
public class GuessNumber
{
	private static int totalTimes = 0;
    private static int answer;

    public static void guess(int low, int high)
    {
        int times = 0;
        int guess;

        do
        {
            guess = (low + high) / 2;
            times++;
            
            if(guess < answer)
                low = guess;
            else if(guess > answer)
                high = guess;
        }while(guess != answer);

        totalTimes += times;
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 100; i++)
        {
            answer = (int)(Math.random() * 100);
            guess(0, 100);
        }
        
        System.out.println("猜100次0-100之间的随机数，总共猜了" + totalTimes + "次！");
    }
}
