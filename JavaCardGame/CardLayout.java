package JavaCardGame;

import java.util.Random;

class CardLayout extends Thread {
    private int[] number;

    private String[] suits;

    private String[] ss;
    private static int ch=0;
    private Random r = new Random();

    public CardLayout() {
        number = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        suits = new String[]{"Spades", "Hearts", "Diamonds", "Clubs"};
        ss = new String[]{"", "", "", ""};
    }


    private int getNumber() {
        return number[r.nextInt(number.length)];
    }

    private String getSuit() {
        return suits[r.nextInt(suits.length)];
    }

    private int check(String[] a) {
        int count = 0, i = 0;
        String z = a[0];
        for (i = 0; i < 4; i++) {
            if (a[i].equals(z)) {
                count += 1;
            }
        }
        if (count == 4){
            return 1;

        }

        return -1;
    }


    public void run(int a) {
        int checker = 0, i = 0;

        for (i = 0; i < 4; i++) {
            String s = getSuit();
            ss[i] = s;
            System.out.println("Number generated is = " + getNumber() + " Of Suit = " + s);
        }
        checker = check(ss);
        if (checker == 1) {
            System.out.println("Player " + String.format("%d", a) + "  You won. Congratulations!");
            ch=1;
        } else {
            System.out.println("Sorry you lose Player " + String.format("%d", a));
        }
    }

    public static void main(String[] args) {
        CardLayout cp1 = new CardLayout();
        CardLayout cp2 = new CardLayout();
        //cp.run();
        while(ch!=1){
            cp1.run(1);
            if(ch==1){
                break;
            }
            cp2.run(2);
        }

    }



}
