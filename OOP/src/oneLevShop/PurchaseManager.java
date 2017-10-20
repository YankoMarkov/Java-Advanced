package oneLevShop;

public class PurchaseManager {

    public static void processPurchase(Customer customer, Product product) {

        double balanceAfterPurchase = customer.getBalance() - product.getPrice();
        if (balanceAfterPurchase <= 0 || customer.getBalance() < product.getPrice()) {
            System.out.println("You do not have enough money to buy this product!!");
        } else {
            customer.setBalance(balanceAfterPurchase);
        }

        double quantityAfterPurchase = product.getQuantity() - 1;
        if (quantityAfterPurchase <= 0) {
            System.out.println("The product is out of stock!");
        } else {
            product.setQuantity(quantityAfterPurchase);
        }

        if ((product instanceof Expirable) && ((FoodProduct)product).getDaysLeft() == 0) {
            System.out.println("The product is expired!");
        } else if (product.getAgeRestriction() == AgeRestriction.ADULT && customer.getAge() < 18) {
            System.out.println("You are too young to buy this product!");
        }
    }
}
