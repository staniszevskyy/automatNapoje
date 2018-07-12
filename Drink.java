public class Drink {
    private String name;
    private int quant;
    private int price;

    public Drink(String name, int quant, int price) {
        this.name = name;
        this.quant = quant;
        this.price = price;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }
}
