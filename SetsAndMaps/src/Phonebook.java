
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        String name;

        while (!(name = scan.nextLine()).equals("search")) {
            Pattern pattern = Pattern.compile("(.+)-(.+)");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                map.put(matcher.group(1), matcher.group(2));
            }
        }
        while (!(name = scan.nextLine()).equals("stop")) {
            if (map.containsKey(name)) {
                System.out.printf("%s -> %s\n", name, map.get(name));

            } else {
                System.out.println("Contact " + name + " does not exist.");
            }
        }
    }
}

