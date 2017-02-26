
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int smallArr = 0;
        int mediumArr = 0;
        int largeArr = 0;
        Pattern pattern = Pattern.compile("(>----->)|(>>----->)|(>>>----->>)");
        for (int i = 0; i < 4; i++) {
            String arrows = scan.nextLine();
            Matcher matcher = pattern.matcher(arrows);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    smallArr++;
                } else if (matcher.group(2) != null) {
                    mediumArr++;
                } else if (matcher.group(3) != null) {
                    largeArr++;
                }
            }
        }
        String num = String.valueOf(smallArr) + String.valueOf(mediumArr) + String.valueOf(largeArr);
        int dec = Integer.valueOf(num);
        String bin = Integer.toBinaryString(dec);
        StringBuilder result = new StringBuilder();
        result.append(bin);
        for (int i = bin.length() - 1; i >= 0; i--) {
            result.append(bin.charAt(i));
        }
        System.out.println(new BigInteger(result.toString(), 2));
    }
}
