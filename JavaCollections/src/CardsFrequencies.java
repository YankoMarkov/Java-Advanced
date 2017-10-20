
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CardsFrequencies {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cards:");
        String[] cards = input.nextLine().split("\\W+");
        Map<String, Integer> cardsCount = new LinkedHashMap<>();
        double sumOfValues = 0;
        for (String card : cards) {
            Integer count = cardsCount.get(card);
            if (count == null) {
                count = 0;
            }
            cardsCount.put(card, count + 1);
            sumOfValues++;
        }
        for (Map.Entry<String, Integer> card : cardsCount.entrySet()) {
            double frequency = (card.getValue() / sumOfValues) * 100;
            System.out.printf("%s -> %.2f%%", card.getKey(), frequency);
            System.out.println();
        }
    }
}
