package printf;

/**
 * This program demonstrates the format for printf
 * @author youkpter
 * p76 and p83 t3.33
 * 2014年 09月 23日 星期二 10:40:34 CST
 */
public class PrintfTest
{
    public static void main(String[] args)
    {
        char ch = 'a';
        boolean b = true;
        int i = 67;
        double d = 12.34;
        double e = 12345678.5;
        String s = "good";

        //p76
        System.out.printf("%5c\n%1$-5c\n", ch);
        System.out.printf("%6b\n%1$-6b\n", b);
        System.out.printf("%5d\n%1$-5d\n", i);
        System.out.printf("%10.2f\n%1$-10.2f\n", d);
        System.out.printf("%10.2e\n%1$-10.2e\n", e);
        System.out.printf("%12s\n%1$-12s\n", s);

        //p83 t3.33
        System.out.printf("amount is %f %e\n", 32.32, 32.32);
        System.out.printf("amount is %5.4f, %5.4e\n", 32.32, 32.32);
        System.out.printf("%6b\n", (1 > 2));
        System.out.printf("%6s\n", "Java");
        System.out.printf("%-6b%s\n", (1 > 2), "Java");
        System.out.printf("%6b%-8s\n", (1 > 2), "Java");
    }
}
