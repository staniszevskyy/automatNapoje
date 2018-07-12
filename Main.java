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
            } else if (ans == 1) {
                //PODAJ NUMER NAPOJU
                System.out.println("Podaj numer napoju ktory chcesz kupic");
                ans = input.nextInt();
                while (ans<30 || ans>49){
                    System.out.println("Wybrano niepoprawny numer napoju");
                    ans = input.nextInt();
                }
                Drink drink=null;
                for  (int i=0; i<drinkList.drinks.length; i++){
                    if (drinkList.drinks[i].getNum() == ans)
                        drink = drinkList.drinks[i];
                }

                if (drink.getPrice() > userCoins.calcSum()){
                    System.out.println("Za malo hajsu biedaku");
                    //narazie koniec programu
                    return;
                }

            }

        }

        for (Coin coin : userCoins.coinList) {
            System.out.printf("%d groszy w ilosci: %d\n", coin.getVal(), coin.getQuant());
        }
    }


}
