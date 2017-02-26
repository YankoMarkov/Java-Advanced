
import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        System.out.println(characterMultiplier(input[0],input[1]));
    }

    private static long characterMultiplier(String first, String second) {
        long result = 0;
        int length = Math.min(first.length(), second.length());
        for (int i = 0; i < length; i++) {
            result += first.charAt(i) * second.charAt(i);
        }
        while (length < first.length()) {
            result += first.charAt(length);
            length++;
        }
        while (length < second.length()) {
            result += second.charAt(length);
            length++;
        }
        return result;
    }
}
