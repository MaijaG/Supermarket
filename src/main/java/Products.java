import java.util.ArrayList;
import java.util.UUID;

public class Products {
    String id;
    String name;
    int totalNumber;
    double priceBuy;
    double priceSell;
    int weight;


    Products(String name, int totalNumber, double priceBuy, double priceSell, int weight) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.totalNumber = totalNumber;
        this.priceBuy = priceBuy;
        this.priceSell = priceSell;
        this.weight = weight;
    }

    public String toString() {
        return "product name --" + this.name + "--  product count --" + this.totalNumber + "--  product price --" + this.priceSell + "-- product weight --" + this.weight + " -- ";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
