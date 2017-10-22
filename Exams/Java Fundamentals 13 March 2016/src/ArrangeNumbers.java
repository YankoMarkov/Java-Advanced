
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class ArrangeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] input = read.readLine().split(",\\s+");
        Map<String, String> result = new TreeMap<>();

        for (String numbers : input) {
            StringBuilder number = new StringBuilder();

            for (int i = 0; i < numbers.length(); i++) {
                if (i != 0) {
                    number.append("-");
                }
                switch (numbers.charAt(i)) {
                    case '0':
                        number.append("zero");
                        break;
                    case '1':
                        number.append("one");
                        break;
                    case '2':
                        number.append("two");
                        break;
                    case '3':
                        number.append("three");
                        break;
                    case '4':
                        number.append("four");
                        break;
                    case '5':
                        number.append("five");
                        break;
                    case '6':
                        number.append("six");
                        break;
                    case '7':
                        number.append("seven");
                        break;
                    case '8':
                        number.append("eight");
                        break;
                    case '9':
                        number.append("nine");
                        break;
                    default:
                        break;
                }
            }
            if (result.containsKey(number.toString())) {
                String newValue = result.get(number.toString()) + ", " + numbers;
                result.put(number.toString(), newValue);
            } else {
                result.put(number.toString(), numbers);
            }
        }
        String total = String.join(", ", result.values());
        System.out.println(total);
    }
}
