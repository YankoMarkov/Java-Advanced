
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
            String number = "";

            for (int i = 0; i < numbers.length(); i++) {
                if (i != 0) {
                    number += "-";
                }
                switch (numbers.charAt(i)) {
                    case '0':
                        number += "zero";
                        break;
                    case '1':
                        number += "one";
                        break;
                    case '2':
                        number += "two";
                        break;
                    case '3':
                        number += "three";
                        break;
                    case '4':
                        number += "four";
                        break;
                    case '5':
                        number += "five";
                        break;
                    case '6':
                        number += "six";
                        break;
                    case '7':
                        number += "seven";
                        break;
                    case '8':
                        number += "eight";
                        break;
                    case '9':
                        number += "nine";
                        break;
                    default:
                        break;
                }
            }
            if (result.containsKey(number)) {
                String newValue = result.get(number) + ", " + numbers;
                result.put(number, newValue);
            } else {
                result.put(number, numbers);
            }
        }
        String total = String.join(", ", result.values());
        System.out.println(total);
    }
}
