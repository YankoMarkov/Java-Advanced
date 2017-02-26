
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            Pattern ipPat = Pattern.compile("IP=(\\d+\\.\\d+\\.\\d+\\.\\d+)" +
                    "|IP=(\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+)");
            Matcher ipMatch = ipPat.matcher(input);
            Pattern useNamePat = Pattern.compile("user=(\\w+)");
            Matcher userNameMatch = useNamePat.matcher(input);

            while (ipMatch.find() && userNameMatch.find()) {
                String ip = ipMatch.group(1) != null ? ipMatch.group(1) : ipMatch.group(2);
                String username = userNameMatch.group(1);
                if (!map.containsKey(username)) {
                    map.put(username, new LinkedHashMap<>());
                    map.get(username).put(ip, 0);
                }
                if (!map.get(username).containsKey(ip)) {
                    map.get(username).put(ip, 1);
                } else {
                    int ipCount = map.get(username).get(ip);
                    map.get(username).put(ip, ipCount + 1);
                }
            }
        }
        for (String user : map.keySet()) {
            System.out.printf("%s:\n", user);
            String ipOutput = "";
            for (String ip : map.get(user).keySet()) {
                ipOutput += String.format("%s => %d, ", ip, map.get(user).get(ip));
            }
            ipOutput = ipOutput.substring(0, ipOutput.length() - 2) + '.';
            System.out.println(ipOutput);
        }
    }
}
