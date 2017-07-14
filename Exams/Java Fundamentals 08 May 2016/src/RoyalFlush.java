import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalFlush {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        List<String> ranks = Arrays.asList(new String[]{"10", "J", "Q", "K", "A"});
        List<String> suits = Arrays.asList(new String[]{"c", "d", "h", "s"});
        String[] outputSuits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};

        Pattern pattern = Pattern.compile("(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)");
        Map<String, List<String>> currentCombination = new TreeMap<>();
        String total = "";
        int royalFlushes = 0;
        for (int i = 0; i < n; i++) {
            total += scan.nextLine();
        }
        Matcher matcher = pattern.matcher(total);
        while (matcher.find()) {
            String currentRanks = matcher.group(1);
            String currentSuits = matcher.group(2);

            if (!currentCombination.containsKey(currentSuits)) {
                currentCombination.put(currentSuits, new ArrayList<>());
            }
            if (currentCombination.get(currentSuits).size() == 0) {
                if (ranks.indexOf(currentRanks) == 0) {
                    currentCombination.get(currentSuits).add(currentRanks);
                }
            } else {
                if (ranks.indexOf(currentRanks) == currentCombination.get(currentSuits).size()) {
                    currentCombination.get(currentSuits).add(currentRanks);
                } else {
                    currentCombination.get(currentSuits).clear();
                    if (ranks.indexOf(currentRanks) == 0) {
                        currentCombination.get(currentSuits).add(currentRanks);
                    }
                }
            }
            if (currentCombination.get(currentSuits).size() == 5) {
                System.out.printf("Royal Flush Found - %s\n", outputSuits[suits.indexOf(currentSuits)]);
                currentCombination.get(currentSuits).clear();
                royalFlushes++;
            }
        }
        System.out.printf("Royal's Royal Flushes - %s.\n", royalFlushes);
    }
}
