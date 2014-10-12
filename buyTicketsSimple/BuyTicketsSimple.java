package buyTicketsSimple;
import java.util.Scanner;

/**
 * 买地铁票程序 简单版
 */
public class BuyTicketsSimple  {

    public static void buyTickets()  {
        int ticketsCost = 0;
        int totalInputMoney = 0;
        int ticketPrice, num, inputMoney;

        System.out.println("欢迎乘坐本公司地铁!\n"
                + "地铁票价为5元，3元，2元和1元\n"
                + "请输入不同票价的地铁票和相应的数量,\n"
                + "输入的票价小于0表示终止输入.\n"
                + "例如输入5 2 3 1 -1表示购买2张5元的票和1张3元的票");

        Scanner input = new Scanner(System.in);

        do  {
            ticketPrice =  input.nextInt();
            if(ticketPrice < 0)
                break;
            num         =  input.nextInt();
            ticketsCost += ticketPrice * num;
        }while(true);

        System.out.println("票价总共为" + ticketsCost + 
                "\n请放入现金进行支付: ");
        while(true)  {
            inputMoney = input.nextInt();
            totalInputMoney += inputMoney;
            if(totalInputMoney < ticketsCost)
                System.out.println("现金不足，请继续放入");
            else
                break;
        }
        System.out.println("收您" + totalInputMoney + "元，找您" + (totalInputMoney - ticketsCost) + "元");
    }

    public static void main(String[] args)  {
        buyTickets();
    }
}
