
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterStudentsByEmailDomain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> students = new LinkedHashMap<>();
        String inputLine = null;
        while (!(inputLine = scan.nextLine()).equals("END")) {
            String[] input = inputLine.split("[\\s]+");
            String name = input[0] + " " + input[1];
            String email = input[2];
            students.put(name, email);
        }
        students.entrySet().stream()
                .filter(s -> s.getValue().endsWith("@gmail.com"))
                .forEach(s -> System.out.printf("%s\n", s.getKey()));
    }
}
