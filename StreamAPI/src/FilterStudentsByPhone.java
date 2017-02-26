
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterStudentsByPhone {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> students = new LinkedHashMap<>();
        String inputLine = null;
        while (!(inputLine = scan.nextLine()).equals("END")) {
            String[] input = inputLine.split("[\\s]+");
            String name = input[0] + " " + input[1];
            String phone = input[2];
            students.put(name, phone);
        }
        students.entrySet().stream()
                .filter(s -> s.getValue().startsWith("02") || s.getValue().startsWith("+3592"))
                .forEach(s -> System.out.printf("%s\n", s.getKey()));
    }
}
