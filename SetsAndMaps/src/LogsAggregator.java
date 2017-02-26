
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.valueOf(input[2]);

            if (!map.containsKey(user)) {
                map.put(user, new TreeMap<>());
            }
            if (!map.get(user).containsKey(ip)) {
                map.get(user).put(ip, 0);
            }
            map.get(user).put(ip, map.get(user).get(ip) + duration);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> userToMap : map.entrySet()) {
            System.out.printf("%s: ", userToMap.getKey());
            int totalDuration = 0;
            String listOfIps = "";
            for (Map.Entry<String, Integer> ipToDuration : userToMap.getValue().entrySet()) {
                totalDuration += ipToDuration.getValue();
                listOfIps += ipToDuration.getKey() + ", ";
            }
            listOfIps = listOfIps.substring(0, listOfIps.length() - 2);
            System.out.printf("%d [%s]%n", totalDuration, listOfIps);
        }
    }
}