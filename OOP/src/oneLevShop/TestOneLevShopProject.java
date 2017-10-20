package oneLevShop;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestOneLevShopProject {

    public static void main(String[] args) throws ParseException {
        Customer mery = new Customer("Mery Popins", 17, 36.32);
        FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 1400, AgeRestriction.ADULT, "2016-10-20");

        PurchaseManager.processPurchase(mery, cigars);
        System.out.println();

        Customer dani = new Customer("Dani Devito", 17, 500);
        Computer lenovo = new Computer("Lenovo", 888.99, 1001, AgeRestriction.TEENAGER);

        PurchaseManager.processPurchase(dani, lenovo);
        System.out.printf(mery.getName() + " balance: %.2f lv.\n", dani.getBalance());
        System.out.println();

        Customer mani = new Customer("Mani Banani", 17, 500);
        Appliance usb = new Appliance("usb", 65.66, 49, AgeRestriction.TEENAGER);

        PurchaseManager.processPurchase(mani, usb);
        System.out.printf(mani.getName() + " balance: %.2f lv.\n", mani.getBalance());
        System.out.println();

        List<Product> products = new ArrayList<>();
        products.add(new FoodProduct("banana", 2.55, 12, AgeRestriction.NONE, "2014-12-01"));
        products.add(new FoodProduct("apple", 2.25, 12, AgeRestriction.NONE, "2014-11-01"));
        products.add(new FoodProduct("milk", 1.99, 12, AgeRestriction.NONE, "2014-10-30"));
        products.add(new Computer("Asus", 989.88, 3, AgeRestriction.ADULT));
        products.add(new Appliance("pc battery", 25.55, 5, AgeRestriction.TEENAGER));

        Comparator<Product> byExpiryDate = (p1, p2) -> Long.compare(
                ((FoodProduct) p1).getDaysLeft(), ((FoodProduct) p2).getDaysLeft());

        products.stream()
                .filter(p -> p instanceof Expirable)
                .sorted(byExpiryDate)
                .forEach((p) -> System.out.printf("%s expires in %s days\n",
                        (((FoodProduct) p).getName()), ((FoodProduct) p).getDaysLeft()));

        Comparator<Product> orderByPrice =(s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice());

        products.stream()
                .filter(p -> p.getAgeRestriction() == AgeRestriction.ADULT)
                .sorted(orderByPrice)
                .forEach((p) -> System.out.println((Product) p));
    }
}
