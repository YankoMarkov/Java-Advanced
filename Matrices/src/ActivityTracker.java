import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityTracker {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(read.readLine());
        Map<Integer, Map<String, Integer>> result = new TreeMap<>();
        Pattern pattern = Pattern.compile("\\d+/(?<month>\\d+)/\\d+\\s+(?<user>[a-zA-Z]+)\\s+(?<distance>\\d+)");

        for (int i = 0; i < num; i++) {
            String input = read.readLine();
            Matcher matcher = pattern.matcher(input);
            int month = 0;
            String user = "";
            int distance = 0;

            while (matcher.find()) {
                if (matcher.group("month") != null) {
                    month = Integer.valueOf(matcher.group("month"));
                    if (!result.containsKey(month)) {
                        result.put(month, new TreeMap<>());
                    }
                }
                if (matcher.group("user") != null) {
                    user = matcher.group("user");
                    if (!result.get(month).containsKey(user)) {
                        result.get(month).put(user, 0);
                    }
                }
                if (matcher.group("distance") != null) {
                    distance = Integer.valueOf(matcher.group("distance"));
                    if (result.get(month).get(user) == 0) {
                        result.get(month).put(user, distance);
                    } else {
                        result.get(month).put(user, distance + result.get(month).get(user));
                    }
                }
            }
        }

        result.entrySet().stream()
                .forEach(month -> {
                    System.out.printf("%d: ", month.getKey());
                    final String[] users = {""};
                    month.getValue().entrySet().stream()
                            .forEach(user -> users[0] += String.format("%s(%d), ", user.getKey(), user.getValue()));
                    users[0] = users[0].substring(0, users[0].length() - 2);
                    System.out.println(users[0]);
                });
    }
}
