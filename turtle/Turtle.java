package turtle;

import java.util.*;

public class Turtle{
    ArrayList<Integer> userCards;
    ArrayList<Integer> computerCards;

    public static void main(String[] args)
    {
        Turtle turtleGame = new Turtle();
        turtleGame.deployCards();
        turtleGame.playGame();
    }

    /**
     * 洗牌并发牌，双方玩家发到两张一样的牌（不考虑花色）就立即丢掉
     */
    public void deployCards() {
        userCards = new ArrayList<Integer>(14);
        computerCards = new ArrayList<Integer>(14);

        //洗牌，1表示A, 11表示J, 12表示Q, 13表示K, 14表示唯一的一张王
        Integer[] cards = {1,  1,  1,  1,  2,  2,  2,  2,  3,  3,  3,  3,  4,
            4, 4, 4, 5,  5,  5,  5,  6,  6,  6,  6,  7,  7,  7,  7,  8,  8,
            8, 8, 9,  9, 9,  9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12,
            12, 13, 13, 13, 13, 14};
        /* int temp, index; */
        for(int temp = 0, int index = 0, int i = 0; i < cards.length; i++) {
            index =(int)(Math.random() * cards.length);
            temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }

        //发牌
        //注意remove()方法有两个,一个参数为index，一个为Object
        for(int i = 0; i < cards.length - 1; i += 2) {
            if(userCards.contains(cards[i])) {
                //如果list中有cards[i]，就去掉list中的这张牌
                //因为这两张是相同的牌
                userCards.remove(cards[i]);
            } else {
                userCards.add(cards[i]);
            }

            if(computerCards.contains(cards[i+1])) {
                //同上，去掉重复的牌
                computerCards.remove(cards[i+1]);
            } else {
                computerCards.add(cards[i+1]);
            }
        }
        //发最后一张牌
        if(userCards.contains(cards[cards.length-1])) {
            userCards.remove(cards[cards.length-1]);
        } else {
            userCards.add(cards[cards.length-1]);
        }

        System.out.println("发牌完毕:");
        printCards();
    }

    public void playGame() {
        int random;
        Integer card;
        System.out.println("start game:");
        while(userCards.size() >= 1 && computerCards.size() >= 1) {
            //用户抽电脑的牌
            random = (int)(Math.random() * computerCards.size());
            card = computerCards.get(random);
            System.out.println("user: i got " + card);
            //从computer手中拿掉牌
            computerCards.remove(random);
            if( userCards.contains(card) ) {
                userCards.remove(card);
            } else {
                userCards.add(card);
            }

            printCards();

            //下面这个判断需要
            //用户抽完牌可能就没牌了
            //然后直接退出，电脑不用抽了
            if(userCards.size() == 0) {
                System.out.println("user: I win");
                System.exit(0);
            }

            //电脑抽用户的牌
            random = (int)(Math.random() * userCards.size());
            card = userCards.get(random);
            System.out.println("comp: i got " + card);
            //从user手中拿掉牌
            userCards.remove(random);
            if(computerCards.contains(card)) {
                computerCards.remove(card);
            } else {
                computerCards.add(card);
            }
            
            printCards();
        }
        //此时就是电脑赢了
        System.out.println("comp: I win");
    }

    public void printCards() {
        //输出用户的牌
        System.out.print("user: ");
        for(int i : userCards)
            System.out.print(i + " ");
        System.out.println();

        //输出电脑的牌
        System.out.print("comp: ");
        for(int i : computerCards)
            System.out.print(i + " ");
        System.out.println();

        System.out.println();
    }
}
