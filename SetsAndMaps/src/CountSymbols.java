
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String txt = scan.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < txt.length(); i++) {
            char ch = txt.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        for (Map.Entry<Character, Integer> characters : map.entrySet()) {
            System.out.printf("%c: %d time/s\n", characters.getKey(), characters.getValue());
        }
    }
}
