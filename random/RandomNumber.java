package random;

public class RandomNumber
{
    private int a = 0;
    private int b = 0;

    //exclude a and b a<x<b
    public void outputTenRandomForExaExb()
    {
        System.out.println("ten random numbers in (a,b):");
        for(int i = 0; i < 10; i++)
            System.out.print((int)(Math.random() * (b-a-1) + (a+1)) + "  ");
        System.out.println();
    }

    //exclude a and include b a<x<=b
    public void outputTenRandomForExaInb()
    {
        System.out.println("ten random numbers in (a,b]:");
        for(int i = 0;i < 10; i++)
            System.out.print((int)(Math.random() * (b-a) + (a+1)) + "  ");
        System.out.println();
    }

    //include a , exclude b a<=x<b
    public void outputTenRandomForInaExb()
    {
        System.out.println("ten random numbers in [a,b):");
        for(int i = 0; i < 10; i++)
         System.out.print((int)((Math.random() * (b-a)) + a) + "  ");
        System.out.println();
    }

    //include a and b a<=x<=b
    public void outputTenRandomForInaInb()
    {
        System.out.println("ten random numbers in [a,b]:");
        for(int i = 0; i < 10; i++)
            System.out.print((int)(Math.random() * (b-a+1) + a) + "  ");
        System.out.println();
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public void setB(int b)
    {
        this.b = b;
    }
}
