import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputs = null;
        Pattern pattern = Pattern.compile("((?<symbol>[,_])(?<message>[a-zA-Z]+|[,_][a-zA-Z]+[\\d])(?<digit>\\d))");

        while (!(inputs = read.readLine()).equals("Ascend")) {
            String[] input = inputs.split("\\s+");
            String temporary = "";
            String result = "";
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                Matcher matcher = pattern.matcher(input[i]);
                String symbol = "";
                String message = "";
                int digit = 0;
                int index = 0;

                while (matcher.find()) {
                    if (matcher.group("symbol") != null) {
                        symbol = matcher.group("symbol");
                    }
                    if (matcher.group("message") != null) {
                        message = matcher.group("message");
                    }
                    if (matcher.group("digit") != null) {
                        digit = Integer.valueOf(matcher.group("digit"));
                    }
                    index = input[i].indexOf(matcher.group("digit")) + 1;
                }
                if (!message.equals("")) {
                    if (message.contains(",") || message.contains("_")) {
                        temporary = messagePattern(message);
                        result = messages(symbol, temporary, digit);
                        index++;
                    } else {
                        result = messages(symbol, message, digit);
                    }
                    res = res.append(result);
                    if (index <= input[i].length() - 1) {
                        String subStr = input[i].substring(index, input[i].length());
                        res = res.append(subStr);
                    }
                    res = res.append(" ");
                } else {
                    res = res.append(input[i]).append(" ");
                }
            }
            System.out.println(res);
        }
    }

    private static String messages(String symbol, String message, int digit) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if (symbol.equals(",")) {
                temp += digit;
            } else if (symbol.equals("_")) {
                temp -= digit;
            }
            res = res.append(temp);
        }
        return res.toString();
    }

    private static String messagePattern(String str) {
        Pattern pattern = Pattern.compile("((?<symbol>[,_])(?<message>[a-zA-Z]+)(?<digit>\\d))");
        Matcher matcher = pattern.matcher(str);
        String symbol = "";
        String message = "";
        int digit = 0;

        while (matcher.find()) {
            if (matcher.group("symbol") != null) {
                symbol = matcher.group("symbol");
            }
            if (matcher.group("message") != null) {
                message = matcher.group("message");
            }
            if (matcher.group("digit") != null) {
                digit = Integer.valueOf(matcher.group("digit"));
            }
        }
        return messages(symbol, message, digit);
    }
}

