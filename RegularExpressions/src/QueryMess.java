import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        Pattern pattern = Pattern.compile("([^?=&]+)=([^?=&]+)");

        while (!(input = scan.nextLine()).equals("END")) {
            input = input.replaceAll("\\+", " ");
            input = input.replaceAll("%20", " ");
            input = input.replaceAll("\\s+", " ");
            Matcher matcher = pattern.matcher(input);
            Map<String, List<String>> map = new LinkedHashMap<>();

            while (matcher.find()) {
                String key = matcher.group(1).trim();
                String value = matcher.group(2).trim();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(value);
            }
            for (Map.Entry<String, List<String>> result : map.entrySet()) {
                System.out.printf("%s=%s", result.getKey(), result.getValue());
            }
            System.out.println();
        }
    }
}
