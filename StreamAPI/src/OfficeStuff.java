import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeStuff {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        Map<String, Map<String, Integer>> companies = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\|(.+)[\\s]+-[\\s]+(.+)[\\s]+-[\\s]+(.+)\\|");
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String company = matcher.group(1);
                String product = matcher.group(3);
                int amount = Integer.valueOf(matcher.group(2));
                if (!companies.containsKey(company)) {
                    companies.put(company, new LinkedHashMap<>());
                }
                if (!companies.get(company).containsKey(product)) {
                    companies.get(company).put(product, 0);
                }
                companies.get(company).put(product, companies.get(company).get(product) + amount);
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> company : companies.entrySet()) {
            result.append(String.format("%s: ", company.getKey()));
            for (Map.Entry<String, Integer> product : company.getValue().entrySet()) {
                result.append(String.format("%s-%d, ", product.getKey(), product.getValue()));
            }
            result.delete(result.length() - 2, result.length());
            result.append("\n");
        }
        System.out.println(result);
    }
}

