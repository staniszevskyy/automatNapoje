public class Coin {
    private int val;
    private int quant;

    public Coin(int val, int quant) {
        this.val = val;
        this.quant = quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;

    }

    public int getVal() {
        return val;
    }

    public int getQuant() {
        return quant;
    }
}
