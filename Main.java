import java.util.Scanner;

class menu {
    public static void mainMenu() {
        System.out.println("*************************************");
        System.out.println("Siemaneczko! Powiedz co chcesz zrobić:");
        System.out.println("1. Wplacic kase");
        System.out.println("2. Kupic napoj");
        System.out.println("0. Zakoncz program");
        System.out.println("*************************************");
    }

    public static void insertCoinMenu() {
        System.out.println("Wrzuc monete (podaj w groszach)");
        System.out.println("By zakonczyc wrzuc 0");
    }

}

public class Main {

    public static void main(String args[]) {

        // initializing data
        UserCoins userCoins = new UserCoins();
        CoinList coinList = new CoinList();
        DrinkList drinkList = new DrinkList();
        Scanner input = new Scanner(System.in);
        menu.mainMenu();
        int ans = input.nextInt();
        if (ans == 1) {
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

        } else if (ans == 2) {
            ans = input.nextInt();

        }

        for (Coin coin : userCoins.coinList) {
            System.out.printf("%d groszy w ilosci: %d\n", coin.getVal(), coin.getQuant());
        }
    }


}
