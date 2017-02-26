import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExcellentStudents {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String inputLine = null;
        Pattern pattern = Pattern.compile("([a-zA-Z\\s]+)[\\s]+([0-9\\s]+)");
        while (!(inputLine = scan.nextLine()).equals("END")) {
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                String name = matcher.group(1);
                String[] mark = matcher.group(2).split("[\\s]+");
                List<Integer> marks = Arrays.stream(mark).map(Integer::valueOf).collect(Collectors.toList());
                students.put(name, marks);
            }
        }
        students.entrySet().stream()
                .filter(s -> s.getValue().contains(6))
                .forEach(s -> System.out.printf("%s\n", s.getKey()));
    }
}
