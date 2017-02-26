
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> special = new HashMap<>();
        Map<String, Integer> junk = new HashMap<>();

        special.put("shards", 0);
        special.put("fragments", 0);
        special.put("motes", 0);

        Pattern delimiter = Pattern.compile("\\s+");
        scan.useDelimiter(delimiter);

        String legendary = null;
        while(legendary == null) {
            int quantity = Integer.parseInt(scan.next());
            String material = scan.next().toLowerCase();
            switch (material) {
                case "shards":
                case "fragments":
                case "motes":
                    special.put(material, special.get(material) + quantity);
                    if (special.get(material) >= 250) {
                        special.put(material, special.get(material) - 250);
                        switch (material) {
                            case "shards":
                                legendary = "Shadowmourne";
                                break;
                            case "fragments":
                                legendary = "Valanyr";
                                break;
                            case "motes":
                                legendary = "Dragonwrath";
                                break;
                        }
                    }
                    break;
                default:
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
            }
        }

        System.out.printf("%s obtained!%n", legendary);
        special.entrySet().stream().sorted((o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        }).forEach(stringIntegerEntry ->
                System.out.printf("%s: %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue())
        );
        junk.entrySet().stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey())).forEach(stringIntegerEntry ->
                System.out.printf("%s: %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue())
        );
    }
}
