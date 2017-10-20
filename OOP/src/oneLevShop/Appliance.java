package oneLevShop;

public class Appliance extends oneLevShop.ElectronicsProduct {

    public Appliance(String name, double price, double quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);

        this.guaranteePeriod = 6;
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        if (this.quantity < 50) {
            return this.price * 1.05;
        }
        return this.price;
    }
}
