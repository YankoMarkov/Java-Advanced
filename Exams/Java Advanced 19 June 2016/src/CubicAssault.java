import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicAssault {
    
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputs = null;
        Map<String, Map<String, Long>> result = new HashMap<>();
        Map<String, Long> sortName = new HashMap<>();
        Pattern pattern = Pattern.compile("(?<name>[a-zA-Z\\s]+) -> (?<type>[a-zA-Z]+) -> (?<count>\\d+)");

        while (!(inputs = read.readLine()).equals("Count em all")) {
            Matcher matcher = pattern.matcher(inputs);
            String name = "";
            String type = "";
            long count = 0;
            long tempCount = 0;
            Map<String, Long> types = new TreeMap<>();

            while (matcher.find()) {
                if (matcher.group("name") != null) {
                    name = matcher.group("name");
                }
                if (matcher.group("count") != null) {
                    count = Long.valueOf(matcher.group("count"));
                }
                if (matcher.group("type") != null) {
                    type = matcher.group("type");
                }
                if (!result.containsKey(name)) {
                    result.put(name, types);
                }
                if (!types.containsKey(type)) {
                    types.put(type, count);
                    sortName.put(name, count);
                } else {
                    types.put(type, types.get(type) + count);
                    sortName.put(name, sortName.get(name) + count);
                }
                if (type.equals("Green")) {
                    if (types.get(type) >= 1000000) {
                        tempCount = types.get(type) / 1000000;
                        types.put(type, 0L);

                        types.put("Red", tempCount);
                    }
                }
                if (type.equals("Red")) {
                    if (types.get(type) >= 1000000) {
                        tempCount = types.get(type) / 1000000;
                        types.put(type, 0L);
                        types.put("Black", tempCount);
                    }
                }
            }
            result.entrySet().stream()
                    .sorted((s1, s2) ->)
        }
    }
}
