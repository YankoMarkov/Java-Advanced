package oneLevShop;

public abstract class Product implements Buyable {

    private String name;
    protected double price;
    protected double quantity;
    private AgeRestriction ageRestriction;

    public Product(String name, double price, double quantity, AgeRestriction ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return this.name +
                ": price " + this.price + "lv" +
                ", quantity "+ this.quantity +
                ", age restriction " + this.ageRestriction;
    }
}
