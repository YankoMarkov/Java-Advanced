import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, HashSet<String>> handsMap = new LinkedHashMap<>();
        List<Character> powers = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
        List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');

        while (true) {
            String[] input = scan.nextLine().trim().split(": ");
            if (input[0].equals("JOKER")) {
                break;
            }
            String name = input[0];
            String[] hand = input[1].split(", ");

            if (!handsMap.containsKey(name)) {
                handsMap.put(name, new HashSet<>());
            }
            for (String hands : hand) {
                handsMap.get(name).add(hands);
            }
        }
        for (String name : handsMap.keySet()) {
            System.out.printf("%s: ", name);
            int handSize = 0;
            for (String card : handsMap.get(name)) {
                int power = powers.indexOf(card.charAt(0)) + 2;
                int suit = suits.indexOf(card.charAt(card.length() - 1)) + 1;
                handSize += power * suit;
            }
            System.out.println(handSize);
        }
    }
}
