public class UserCoins extends CoinList {
    public UserCoins() {
        coinList = new Coin[9];
        coinList[8] = new Coin(1, 0);
        coinList[7] = new Coin(2, 0);
        coinList[6] = new Coin(5, 0);
        coinList[5] = new Coin(10, 0);
        coinList[4] = new Coin(20, 0);
        coinList[3] = new Coin(50, 0);
        coinList[2] = new Coin(100, 0);
        coinList[1] = new Coin(200, 0);
        coinList[0] = new Coin(500, 0);
    }
}
