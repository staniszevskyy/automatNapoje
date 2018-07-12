import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // initializing data
        UserCoins userCoins = new UserCoins();
        CoinList coinList = new CoinList();
        DrinkList drinkList = new DrinkList();
        System.out.println("*************************************");
        System.out.println("Siemaneczko! Powiedz co chcesz zrobić:");
        System.out.println("1. Wplacic kase");
        System.out.println("2. Kupic napoj");
        System.out.println("*************************************");
        Scanner input = new Scanner(System.in);
        int ans = input.nextInt();
        if (ans == 1) {
            System.out.println("Wrzuc monete (podaj w groszach)");
            System.out.println("By zakonczyc wrzuc 0");
            //DO ZROBIENIA: gdy nauczysz sie wyjatkow
            ans = input.nextInt();
            while (ans != 0) {
                for (int i = 0; i < userCoins.coinList.length; i++) {
                    if (ans == userCoins.coinList[i].getVal()) {
                        userCoins.coinList[i].setQuant(userCoins.coinList[i].getQuant() + 1);
                    }
                }
                System.out.println("Moneta wrzucona");
                ans = input.nextInt();
            }

        }
        else if (ans == 2) {

        }
        for (int i=0; i < userCoins.coinList.length; i++){
            System.out.println(userCoins.coinList[i].getQuant());
        }
    }


}
