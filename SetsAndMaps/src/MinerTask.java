
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String str;

        while (!(str = scan.nextLine()).equals("stop")) {
            int num = Integer.valueOf(scan.nextLine());
            if (!map.containsKey(str)) {
                map.put(str, num);
            } else {
                map.put(str, map.get(str) + num);
            }
        }
        for (Map.Entry<String, Integer> resources : map.entrySet()) {
            System.out.printf("%s -> %s\n", resources.getKey(), resources.getValue());
        }
    }
}
