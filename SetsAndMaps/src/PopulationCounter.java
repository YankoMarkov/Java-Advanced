import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Long> country = new HashMap<>();
        HashMap<String, HashMap<String, Long>> city = new HashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("report")) {
                break;
            }
            Pattern pattern = Pattern.compile("(.+)\\|(.+)\\|(.+)");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String countries = matcher.group(2);
                String cities = matcher.group(1);
                long population = Integer.valueOf(matcher.group(3));
                if (!city.containsKey(countries)) {
                    city.put(countries, new HashMap<>());
                    country.put(countries, 0L);
                }
                country.put(countries, country.get(countries) + population);
                if (!city.get(countries).containsKey(cities)) {
                    city.get(countries).put(cities, population);
                }
            }
        }
        city.entrySet().stream().sorted((a1, a2) -> country.get(a2.getKey()).compareTo(country.get(a1.getKey()))).
                forEach(countries -> {
                    System.out.printf("%s (total population: %d)\n", countries.getKey(), country.get(countries.getKey()));
                    countries.getValue().entrySet().stream().sorted((b1, b2) -> b2.getValue().compareTo(b1.getValue())).
                            forEach(cities -> {
                                System.out.printf("=>%s: %d\n", cities.getKey(), cities.getValue());
                            });
                });
    }
}