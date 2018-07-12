

public class CoinList {
    protected Coin[] coinList;

    public CoinList() {
        coinList = new Coin[9];
        coinList[0] = new Coin(1, 50);
        coinList[1] = new Coin(2, 50);
        coinList[2] = new Coin(5, 50);
        coinList[3] = new Coin(10, 50);
        coinList[4] = new Coin(20, 50);
        coinList[5] = new Coin(50, 50);
        coinList[6] = new Coin(100, 50);
        coinList[7] = new Coin(200, 50);
        coinList[8] = new Coin(500, 50);

    }

    public float calcSum(){
        float sum=0;
        for (Coin c : coinList){
            sum+=c.getVal()*c.getQuant();
        }
        return sum/100;
    }

}
