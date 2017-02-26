
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicExchangeableWords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        System.out.println(magicExchangeableWords(input[0], input[1]));

    }

    private static boolean magicExchangeableWords(String shortest, String longest) {
        Map<Character, Character> chatMap = new HashMap<>();
        String small;
        String big;

        if (shortest.length() <= longest.length()) {
            big = longest;
            small = shortest;
        } else {
            big = shortest;
            small = longest;
        }
        for (int i = 0; i < small.length(); i++) {
            if (!chatMap.containsKey(big.charAt(i))) {
                chatMap.put(big.charAt(i), small.charAt(i));
            }
            if (chatMap.get(big.charAt(i)) != small.charAt(i)) {
                return false;
            }
        }
        for (int i = small.length(); i < big.length(); i++) {
            if (!chatMap.containsKey(big.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
