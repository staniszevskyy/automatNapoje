public class Drink {
    private String name;
    private int quant;
    private int price;
    private int num;

    public Drink(String name, int quant, int price, int num) {
        this.name = name;
        this.quant = quant;
        this.price = price;
        this.num = num;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNum() {
        return num;

    }
}
