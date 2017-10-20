package oneLevShop;

public abstract class ElectronicsProduct extends oneLevShop.Product {

    protected int guaranteePeriod;

    public ElectronicsProduct(String name, double price, double quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return super.toString() + ", Guarantee Period " + this.guaranteePeriod;
    }
}
