import java.util.Scanner;

import static java.lang.Math.*;

class menu {
    public static void mainMenu() {
        System.out.println("*************************************");
        System.out.println("Siemaneczko! Powiedz co chcesz zrobić:");
        System.out.println("1. Wplacic kase");
        System.out.println("2. Kupic napoj");
        System.out.println("3. Sprawdz saldo");
        System.out.println("0. Zakoncz program");
        System.out.println("*************************************");
    }

    public static void insertCoinMenu() {
        System.out.println("Wrzuc monete (podaj w groszach)");
        System.out.println("By zakonczyc wrzuc 0");
    }

    public static void buyDrinkMenu() {
        System.out.println("***************************************************");
        System.out.println("Kupujesz napój. Znasz jego numer czy wypisac liste?");
        System.out.println("1. Znam numer");
        System.out.println("2. Wypisz napoje");
        System.out.println("***************************************************");
    }


}


public class Main {

    public static void main(String args[]) {

        // initializing data
        UserCoins userCoins = new UserCoins();
        CoinList coinList = new CoinList();
        DrinkList drinkList = new DrinkList();
        Scanner input = new Scanner(System.in);

        while (true) {
            menu.mainMenu();
            int ans = input.nextInt();
            if (ans == 1) {
                menu.insertCoinMenu();
                //DO ZROBIENIA: gdy nauczysz sie wyjatkow
                ans = input.nextInt();
                while (ans != 0) {
                    for (Coin coin : userCoins.coinList) {
                        if (ans == coin.getVal()) {
                            coin.setQuant(coin.getQuant() + 1);
                        }
                    }
                    System.out.println("Moneta wrzucona");
                    System.out.println("Obecny hajs: " + userCoins.calcSum() / 100);
                    ans = input.nextInt();
                }

            } else if (ans == 2) {
                menu.buyDrinkMenu();
                ans = input.nextInt();
                if (ans == 2) {
                    //WYPISZ NAPOJE
                    for (Drink drink : drinkList.drinks) {
                        System.out.println(drink.getNum() + ". " + drink.getName());
                    }

                }
                //PODAJ NUMER NAPOJU
                System.out.println("Podaj numer napoju ktory chcesz kupic");
                ans = input.nextInt();
                while (ans < 30 || ans > 49) {
                    System.out.println("Wybrano niepoprawny numer napoju");
                    ans = input.nextInt();
                }
                Drink drink = null;
                for (int i = 0; i < drinkList.drinks.length; i++) {
                    if (drinkList.drinks[i].getNum() == ans)
                        drink = drinkList.drinks[i];
                }

                if (drink.getPrice() > userCoins.calcSum()) {
                    System.out.println("Za malo hajsu biedaku");
                    //narazie koniec programu
                    return;
                } else if (drink.getPrice() == userCoins.calcSum()) {
                    zeroUserMoney(userCoins, coinList);
                    System.out.println("Otrzymujesz napoj " + drink.getName() + ". Brak reszty. Smacznego");
                } else if (ans == 2) {
                    float rest = abs(drink.getPrice() - userCoins.calcSum());
                    zeroUserMoney(userCoins, coinList);
                    for (Coin c : coinList.coinList) {
                        while (c.getQuant() != 0 && rest - c.getVal() >= 0) {

                            rest -= c.getVal();
                            Coin usermoney = findCoin(userCoins, c.getVal());
                            usermoney.setQuant(usermoney.getQuant() + 1);
                            c.setQuant(c.getQuant() - 1);

                        }
                    }
                    System.out.println("Otrzymujesz napoj " + drink.getName() + ". Twoja reszta to: " + userCoins.calcSum() / 100);
                }


            } else {
                System.out.println("Twoj hajs to: " + userCoins.calcSum() / 100);
            }

        }


    }

    private static void zeroUserMoney(UserCoins userCoins, CoinList coinList) {
        for (Coin uCoin : userCoins.coinList) {
            int quant = uCoin.getQuant();
            for (Coin bankCoin : coinList.coinList) {
                if (bankCoin.getVal() == uCoin.getVal()) {
                    uCoin.setQuant(0);
                    bankCoin.setQuant(bankCoin.getQuant() + quant);
                }
            }
        }
    }

    private static void dispCoins(CoinList userCoins) {
        for (Coin coin : userCoins.coinList) {
            System.out.printf("%d groszy w ilosci: %d\n", coin.getVal(), coin.getQuant());

        }
    }

    private static Coin findCoin(CoinList coins, int val) {
        for (Coin coin : coins.coinList) {
            if (coin.getVal() == val)
                return coin;
        }
        return null;
    }
}
