package oneLevShop;

public class Computer extends oneLevShop.ElectronicsProduct {

    public Computer(String name, double price, double quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);

        this.guaranteePeriod = 24;
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        if (this.quantity > 1000) {
            return this.price * 0.95;
        }
        return this.price;
    }
}
